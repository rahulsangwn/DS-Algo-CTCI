.386
.model flat, c

.code
occurences proc
	push ebp
	mov ebp, esp
	push esi

	mov esi, [ebp+8]
	mov cx, [ebp+12]
	mov edx, 0

	@@:
		lodsw		; load word form esi to ax and increment esi
		or ax, ax	; check for end of string
		jz @F		
		cmp ax, cx
		jne @B
		inc edx
		jmp @B

	@@:
		mov eax, edx

	pop esi
	mov esp, ebp
	pop ebp
	ret				; return number of occurences; eax register

occurences endp
 end
