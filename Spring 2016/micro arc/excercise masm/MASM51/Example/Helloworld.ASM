            TITLE   hello
            DOSSEG                     ; Use Microsoft segment conventions
            .MODEL  SMALL              ;   conventions and small model

            .STACK  100h               ; Allocate 256-byte stack

            .DATA
message     DB      "Hello, world.",13,10  ; Message to be written
lmessage    EQU     $ - message            ; Length of message

            .CODE
start:      mov     ax,@DATA           ; Load segment location
            mov     ds,ax              ;   into DS register

            mov     bx,1               ; Load 1 - file handle for
                                       ;   standard output
            mov     cx,lmessage        ; Load length of message
            mov     dx,OFFSET message  ; Load address of message
            mov     ah,40h             ; Load number for DOS Write function
            int     21h                ; Call DOS

            mov     ax,4C00h           ; Load DOS Exit function (4Ch)
                                       ;   in AH and 0 errorlevel in AL
            int     21h                ; Call DOS

            END     start
