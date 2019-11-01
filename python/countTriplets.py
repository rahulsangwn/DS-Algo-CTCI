# Source: https://www.geeksforgeeks.org/count-triplets-such-that-one-of-the-numbers-can-be-written-as-sum-of-the-other-two/
# Using permutation and combination
# Time Complexity: O(n^2)

class Solution:
    def count(self):
        res = 0

        # case 1: (0, 0, 0)
        if freq[0] > 2:
            res += (freq[0] * (freq[0] -1 ) * (freq[0] - 2) // 6)

        # case 2: (0, x, x)
        for i in range(1, max + 1):
            res += (freq[0] * freq[i] * (freq[i] - 1) // 2)

        # case 3: (x, x, 2x)
        for i in range(1, (max + 1) // 2):
            res += (freq[i] * (freq[i] - 1) // 2 * freq[2*i])

        # case 4: (x, y, x+y)
        for i in range(1, max + 1):
            for j in range(i + 1, max + 1 - i):
                res += (freq[i] * freq[j] * freq[i+j])

        return res


solution = Solution()
freq = []
array = [1, 2, 3, 4, 5]
max = max(array)

def adjust():
    for i in range(0, max + 1):
        freq.append(0)

    for i in array:
        freq[i] += 1


adjust()
print(solution.count())