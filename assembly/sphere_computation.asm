.386
.model flat, c

.const
r8_4p0 real8 4.0
r8_3p0 real8 3.0

.code
sphere_computation proc
	push ebp
	mov ebp, esp

	fld real8 ptr[ebp+8]	; st(0) = r
	fldz					; st(0) = 0.0 && st(1) = r
	fcomip st(0), st(1)		; compares 0.0 to r
	fstp st(0)				; pop register st(0)

	jp done		; jump if unordered 
	ja done		; jump if r less than equal to 0

	fstp st(0)

	fld real8 ptr[ebp+8]
	fld st(0)				; st(0) = r, st(1) = r
	fmul st(0), st(0)

	fldpi				; st(0) = pi
	fmul [r8_4p0]		; st(0) = 4 * pi
	fmulp				; st(0) = 4 * pi * r * r

	mov edx, [ebp+16]
	fst real8 ptr[edx]

	fmulp				; st(0) = 4 * pi * r * r * r
	fdiv [r8_3p0]		; st(0) = 4 * pi * r * r * r / 3

	mov edx, [ebp+20]
	fstp real8 ptr[edx]

	done:
		mov esp, ebp
		pop ebp
		ret
sphere_computation endp
end
