# Source: https://practice.geeksforgeeks.org/problems/anagram/0
# using bitwise XOR
# Time Complexity: O(n)

def main():
    testCases = int(input())
    result = []

    for i in range(testCases):
        str = input().split();
        result.append(isAnagram(str[0], str[1]))

    for i in result:
        print(i)

def isAnagram(string1, string2):
    value = 0

    if len(string1) != len(string2):
        return "NO"
    else:
        for i in range(len(string1)):
            value = value ^ ord(string1[i])
            value = value ^ ord(string2[i])

    if value == 0:
        return "YES"
    else:
        return "NO"

main()