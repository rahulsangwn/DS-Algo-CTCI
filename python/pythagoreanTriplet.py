# Source: https://practice.geeksforgeeks.org/problems/pythagorean-triplet/0
# using Combination and Hashing
# Time Complexity: O(n^2)

def count():
    result = 0
    # Case 1: (0, 0, 0)
    result += (freq(0) * (freq(0) - 1) * (freq(0) - 2) // 6)

    # Case 2: (0, x^2, x^2)
    for i in range(0, len(array)):
        result += (freq(0) * freq(i*i) * (freq(i*i) - 1) // 2)

    # Case 3: (x^2, y^2, x^2+y^2)
    for i in range(0, len(array)):
        for j in range(i + 1, len(array)):
            result += (freq(i*i) * freq(j*j) * freq(i*i+j*j))

    return result


def freq(square):
    if square not in dictionary:
        return 0
    else:
        return dictionary[square]


array = [3, 2, 4, 6, 5]
dictionary = {}

for i in array:
    square = i * i
    if square in dictionary:
        dictionary[square] += 1
    else:
        dictionary[square] = 1

if count() > 0:
    print("YES")
else:
    print("NO")