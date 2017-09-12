dosseg
.model small
.stack 200h
.data
.code
hexbin proc
mov ax,@data
mov ds,ax
mov dx,0abcdh
mov ah,02
mov cx,0fh
mov bx,0
reverse:
push dx
and dx,1
add bx,dx
shl bx,1
pop dx
ror dx,1
dec cx
jnz reverse
and dx,1
add bx,dx
mov dx,bx
mov cx,0010h

send:
rol dx,1
push dx
and dx,0001
add dx,30h
int 21h
pop dx
dec cx
jnz send
int 3
mov ax,4c00h
int 21h
hexbin endp
end

