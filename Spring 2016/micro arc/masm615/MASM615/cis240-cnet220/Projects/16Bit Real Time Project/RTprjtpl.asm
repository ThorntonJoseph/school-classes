        .Model Small
        .LIST

        .STACK  200
	.DATA

CountSecHdths    	PROTO
ResetCountSecHdths	PROTO
TdelayCount		PROTO



	.CODE

INCLUDE DISPLAY.INC

	.STARTUP
Main PROC
LOCAL   WheelPosition:WORD

	mov	bx,WheelPosition
	xor	ax,ax
	mov	[bx],ax
 	invoke	ClearScreen, 25*80

LOOPTOP:

	mov	al,50
	mov	ah,0
	invoke	TdelayCount
	invoke	CenterCursor, 0CH,24H
        invoke  RotateWheel, WheelPosition


   	jmp     LOOPTOP
Main 	ENDP
	.EXIT


       	END
