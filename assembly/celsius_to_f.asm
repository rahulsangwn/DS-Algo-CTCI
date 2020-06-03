.386
.model flat, c

.const
r8_9by5 real8 1.8			;9/5
i4_32 dword 32

.code
CtoF proc
	push ebp
	mov ebp, esp

	fild [i4_32]
	fld real8 ptr[ebp+8]
	fld [r8_9by5]

	fmulp
	fadd

	mov esp, ebp
	pop ebp
	ret
CtoF endp
 end