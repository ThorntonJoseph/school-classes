ClearScreen	PROC	NEAR C USES ax bx dx, ScreenLength:WORD

;reset cursor position LINE0,CHAR0
        mov     AH,02H
        mov     BH,0
        mov     DH,0H
        mov     DL,0H
        int     10H
;clear screen
        mov     bX,ScreenLength
BLANKSCREEN:
        mov     AH,02
        mov     DL,20H
        int     21H
        dec     bx
        jne     BLANKSCREEN

	ret
ClearScreen	ENDP

CenterCursor	PROC	NEAR C USES ax bx dx, VertPos:BYTE, HorzPos:BYTE

;Center cursor position
        mov     AH,02H
        mov     BH,0
        mov     DH,VertPos
       	mov     DL,HorzPos
        int     10H

	ret
CenterCursor	ENDP


RotateWheel	PROC	NEAR C USES ax bx dx, WheelPosition:WORD ;NEAR PTR WORD ;if defined as variable

 	mov	bx,WheelPosition
	mov	ax,[bx]
	and	ax,3
SELECT_CASE_CYCLE_DISPLAY:
	cmp	ax,0
	jne	TEST_CYCLE_CASE_ONE
   CASE_CYCLE_DISPLAY_ZERO:
	mov	ax,[bx]
	inc	ax
	mov	[bx],ax

     	mov	ah,2
	mov	dl,2dh
	int	21h
	jmp	CASE_CYCLE_DISPLAY_END
TEST_CYCLE_CASE_ONE:	
	cmp	ax,1
	jne	TEST_CYCLE_CASE_TWO
   CASE_CYCLE_DISPLAY_ONE:
	mov	ax,[bx]
	inc	ax
	mov	[bx],ax

   	mov	ah,2
	mov	dl,5ch
	int	21h
	jmp	CASE_CYCLE_DISPLAY_END
TEST_CYCLE_CASE_TWO:
	cmp	ax,2
	jne	TEST_CYCLE_CASE_THREE
   CASE_CYCLE_DISPLAY_TWO:
	mov	ax,[bx]
	inc	ax
	mov	[bx],ax

   	mov	ah,2
	mov	dl,7ch
	int	21h

	jmp	CASE_CYCLE_DISPLAY_END
TEST_CYCLE_CASE_THREE:
	cmp	ax,3
	jne	CASE_CYCLE_DISPLAY_END
   CASE_CYCLE_DISPLAY_THREE:
	mov	bx,WheelPosition
	xor	ax,ax
	mov	[bx],ax

   	mov	ah,2
	mov	dl,2fh
	int	21h


CASE_CYCLE_DISPLAY_END:
        ret

RotateWheel     ENDP
