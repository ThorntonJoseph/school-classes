
;.686P		; Pentium Pro or later
;.MODEL flat, stdcall
;.STACK 4096
include irvine32.inc

HEX_TO_ASCII	PROTO

	.STACK   

;CONSTANTS

	.CONST
cstCR 		EQU 0Dh
cstLF  		EQU 0Ah
cstSPACE	EQU 20h
cstEOL		EQU 24h		
	.CODE

	


;sends buffer of unpacked hex data to video screen
;inputs DataBuffer pointer to unpacked hex numbers
;outputs none
PRINT_BUFFER	PROC	NEAR	PUBLIC
	PUSH	eBP		;Save eBP, NOW eIP=eBP+4
	MOV		eBP,eSP		;Get current stack address
	PUSH	AX
	PUSH	eDX
	PUSH	eSI

	MOV 	eSI,[eBP+8]	;Retrive Pointer to beginning of data buffer
CONV_LOOP:
	MOV	AL,[eSI]
	CMP	AL,cstEOL
	JE	CONV_DONE
	call	HEX_TO_ASCII
	MOV	[eSI],AL
    INC     eSI
	JMP	CONV_LOOP
CONV_DONE:
	mov edx, [eBP+8] 	;load location of buffer
	call writestring

	POP	eSI
	POP	eDX
	POP	AX
	POP eBP			;restore BP from stack for calling routine
	RET	4
PRINT_BUFFER	ENDP


;**************************************************
CONV_BUFFER		PROC	NEAR	PUBLIC
	PUSH	eBP		;Save eBP, NOW eIP=eBP+4
	MOV		eBP,eSP		;Get current stack address
	PUSH	AX
	PUSH	eDX
	PUSH	eSI

	MOV 	eSI,[eBP+8]	;Retrive Pointer to beginning of data buffer
CONV_LOOP:
	MOV	AL,[eSI]
	CMP	AL,cstEOL
	JE	CONV_DONE
	call	HEX_TO_ASCII
	MOV	[eSI],AL
    INC     eSI
	JMP	CONV_LOOP
CONV_DONE:
	mov al,0
	mov	[esi], al

	POP	eSI
	POP	eDX
	POP	AX
	POP eBP			;restore BP from stack for calling routine
	RET	4
CONV_BUFFER	ENDP


;**************************************************

CLRBUF PROC NEAR C USES eax ebx edx,address:dword, lengthbuf:word
	xor ecx,ecx
	MOV	CX,lengthbuf
	mov ebx,address
	mov al,0
CLRLOOP:
	MOV [ebx],AL
	INC ebx
	loopne CLRLOOP
	ret
CLRBUF ENDP

	END   		;End of program
