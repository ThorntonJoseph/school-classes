TITLE MASM main						(main.asm)

;.686P		; Pentium Pro or later
;.MODEL flat, stdcall
;.STACK 4096

INCLUDE Irvine32.inc


	.DATA

;Define data variables for program
asciibuffer	BYTE   200 DUP(?)	;input buffer
	
prompt1 BYTE "Type a hex number>",0
prompt2 BYTE "Type D to display all numbers or enter to add another number>",0
                                
;
; Note add more variables if needed
;

;Define Constants

cstCR 		= 0Dh		;ascii carraige return char
cstLF  		= 0Ah		;ascii line feed char
cstSPACE	= 20h		;ascii space bar char
cstEOL		= 0h		;end of string of chars

	
	.CODE
 
MAIN	PROC

	mov 	esi,OFFSET asciibuffer

NEWNUMBER:

	mov edx, OFFSET  prompt1 	;load location of buffer
	call writestring

WAITFORDIGIT:

	call 	readchar		;read char from keyboard
	call	writechar		;echo it to monitor
	cmp 	al,cstCR		;look for carraige return 
	JE 	NUMBERENTERED		;if CR then number entered
	call 	ASCII_TO_HEX		;AH returns 1 if error
;	cmp	ah,1			
;	call 	ERROR_HANDLER		;this routine needs to be written
	mov 	[esi],al		;save converted character
	inc 	esi			;point to next char to save
	jmp 	WAITFORDIGIT		;jmp to get next char

NUMBERENTERED:		
	call	crlf			;go to next line

	mov 	al,cstSPACE		;add a space between numbers
	mov 	[esi],al
	inc 	esi

	mov 	edx, OFFSET  prompt2 	;load location of prompt string
	call 	writestring		;display prompt

	call 	readchar		;read char for next decision
	cmp 	al,'D'
	je 	DISPLAYNUMBERS		;if char=D display numbers 
	call	crlf
	jmp 	NEWNUMBER

DISPLAYNUMBERS:
	mov 	al,cstEOL		;end msg string with a null
	mov 	[esi],al
	mov 	esi,OFFSET asciibuffer	;Point to beginning of outbuffer
CONV_LOOP:
	mov 	al,[esi]
	cmp 	al,cstEOL
	je	CONV_DONE
	call	HEX_TO_ASCII
	mov 	[esi],al
	inc 	esi
	jmp	CONV_LOOP
CONV_DONE:
	mov edx, OFFSET  asciibuffer 	;load location of buffer
	call 	writestring
	call	crlf

	exit
MAIN  	ENDP


 
;*************** SUBROUTINES ********************

;ascii to hex conversion routine
;inputs   AL input ascii character between 0 to 9, A to F, or a to f
;outputs AL, contains hex number between 0 and F
;	AH, input number out of range AH=1, otherwise AH=0
ASCII_TO_HEX	 PROC  
  	
	mov 	AH,0		;Clear return error

	cmp 	al,39H		;test for 0 to 9
	jg	ALPHABET
	cmp 	al,30H
	jl	CONVERT_ERROR
	sub	al,30H
	jmp	CONVERT_DONE
ALPHABET:
	cmp 	al,46H		;test for A to F
	jg	CONVERT_LOWER
	cmp 	al,41H
	jl	CONVERT_ERROR
	sub	al,37H
	jmp	CONVERT_DONE
CONVERT_LOWER:
	cmp 	al,66H		;test for a to f
	jg	CONVERT_ERROR
	cmp 	al,61H
	jl	CONVERT_ERROR
	sub	al,57H
	jmp	CONVERT_DONE
CONVERT_ERROR:
	mov	ah,1		;set invalid char error
CONVERT_DONE:
	Ret
ASCII_TO_HEX	 ENDP

;hex to ascii conversion routine
;inputs AL input number between 0 and 0Fh
;outputs AL ascii character between 0 and F
;	 AH input number out of range AH=1, otherwise AH=0

HEX_TO_ASCII	PROC     	
;Add your new code here
HEX_TO_ASCII	ENDP

	END 	main	;End of program
