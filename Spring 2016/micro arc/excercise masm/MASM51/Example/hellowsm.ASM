            TITLE   hello
            DOSSEG                     ; Use Microsoft segment conventions
            .MODEL  SMALL              ;   conventions and small model

            .STACK  100h               ; Allocate 256-byte stack

            .DATA
message     DB      "Hello, world.",13,10  ; Message to be written
lmessage    EQU     $ - message            ; Length of message

            .CODE
        
start proc
newdata     DW 0
            mov     ax,@DATA           ; Load segment location
            mov     ds,ax              ;   into DS register

            mov     bx,1               ; Load 1 - file handle for
                                       ;   standard output
            mov     cx,lmessage        ; Load length of message
            mov     dx,OFFSET message  ; Load address of message
            mov     ah,40h             ; Load number for DOS Write function
            int     21h                ; Call DOS


	    mov     newdata,100
            mov     bx,OFFSET newdata
            mov     [bx],ah
            push    bx
            call    addone
	    mov     dx,ax
            mov     ah,2	       ;write value to monitor
	    int     21h

            mov     ax,4C00h           ; Load DOS Exit function (4Ch)
                                       ;   in AH and 0 errorlevel in AL
            int     21h                ; Call DOS

start         ENDP     


addone proc
        push bp
        mov bp,sp
        mov bx,[bp+4]
        mov ax,[bx]
	inc ax
        pop bp
        ret 4
addone endp  

        end

        
