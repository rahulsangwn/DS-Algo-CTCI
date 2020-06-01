.386
.model flat, c

.code
; extern "C" int mul_div(const int a, const int b, int* prod, int* quo, int* rem);
mul_div proc
	push ebp
	mov ebp, esp
	push ebx

	xor eax, eax

	mov ecx, [ebp+8]
	mov edx, [ebp+12]

	or edx, edx
	jz InvalidDivisor

	imul edx, ecx

	mov ebx, [ebp+16]
	mov [ebx], edx

	mov eax, ecx
	cdq
	idiv dword ptr[ebp+12]

	mov ebx, [ebp+20]
	mov [ebx], eax

	mov ebx, [ebp+24]
	mov [ebx], edx

	mov eax, 1

InvalidDivisor:
	pop ebx
	pop ebp
	ret
mul_div endp
 end
