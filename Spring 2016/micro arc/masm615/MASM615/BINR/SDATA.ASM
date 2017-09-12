

TITLE	ADC-READ PROGRAM

	PAGE   	,132

COMMENT *This program moves a block of specified number of bytes
	from one place to another place*


;Define constants used in this program


	ADC_DAT=	379H		;lpt port serial data (ON BIT 7)
	ADC_CTL=	37AH		;lpt port configure
	READ_BIT=	80H		;data Mask bit 
	CLK_BIT=	1H		;adc clock control
	ADC_CS = 	2H		;adc select bit
	CONV_ASCII=	30H
	SHIFT_BYTE=	8

STACK_SEG	SEGMENT		STACK 'STACK'
		DB		200 DUP(?)
STACK_SEG	ENDS


CODE_SEG	SEGMENT		'CODE'
ADCREAD	        PROC     	FAR
	ASSUME	CS:CODE_SEG,SS:STACK_SEG

;To return to DEBUG program put return address on the stack

	PUSH	DS
	MOV	AX, 0
	PUSH	AX

	MOV	BL,0
	MOV	DX,ADC_CTL
	MOV	AL,ADC_CS
	OUT	DX,AL
	MOV	CX,SHIFT_BYTE
GETBYTE:
	MOV	DX,ADC_CTL
	XOR	AL,CLK_BIT
	OUT	DX,AL
	XOR	AL,CLK_BIT
	OUT	DX,AL
	PUSH	AX
	MOV	DX,ADC_DAT
	IN	AL,DX
	AND	AL,READ_BIT
	ROL	AL,1
	OR	BL,AL
	SHL	BX,1
        POP     AX
	DEC	CX
	JNZ	GETBYTE
	SHR	BX,1

;clear screen
        MOV     CX,0FFFH
CLEARSCREEN:
        MOV     AH,02
        MOV     DL,20H
        INT     21H
        LOOPNE  CLEARSCREEN

;reset cursor position
        MOV     AH,02H
        MOV     BH,0
        MOV     DH,14H
        MOV     DL,24H
        INT     10H

;send byte to output
	MOV 	AH,2H
	MOV	DL,BL
	INT	21H
	RET			;Return to DEBUG program
ADCREAD     	ENDP
CODE_SEG        ENDS
	END  	ADCREAD     	;End of program
