TITLE MASM asc2hex			(asc2hex.asm)

.686P		; Pentium Pro or later
.MODEL flat, stdcall
.STACK 4096
	
	.CODE


;ascii to hex conversion routine
;inputs AL input ascii character between 0 to 9, A to F, or a to f
;outputs AL ascii number between 0 and F
;	 AH returns number out of range if 1 otherwise 0 if ok
ASCII_TO_HEX	PROC     	NEAR	PUBLIC
	MOV	AH,0		;Clear return error

	CMP	AL,39H		;test for 0 to 9
	JG	ALPHABET
	CMP	AL,30H
	JL	CONVERT_ERROR
	SUB	AL,30H
	JMP	CONVERT_DONE
ALPHABET:
	CMP	AL,46H		;test for A to F
	JG	CONVERT_LOWER
	CMP	AL,41H
	JL	CONVERT_ERROR
	SUB	AL,37H
	JMP	CONVERT_DONE
CONVERT_LOWER:
	CMP	AL,66H		;test for a to f
	JG	CONVERT_ERROR
	CMP	AL,61H
	JL	CONVERT_ERROR
	SUB	AL,57H
	JMP	CONVERT_DONE
CONVERT_ERROR:
	MOV	AH,1		;set invalid char error
CONVERT_DONE:
	RET
ASCII_TO_HEX	ENDP
	 
	END   		;End of program
