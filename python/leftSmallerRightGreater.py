# Source: https://practice.geeksforgeeks.org/problems/unsorted-array/0
# Time Complexity: O(n)
# using leftMax and rightMin array

def findNumber():
    number = -1

    leftMax = []
    maximum = array[0]
    for i in array:
        maximum = max(maximum, i)
        leftMax.append(maximum)

    rightMin = []
    minimum = array[len(array) - 1]
    for i in range(len(array) - 1, -1, -1):
        minimum = min(minimum, array[i])
        rightMin.append(minimum)

    rightMin.reverse()
    for i in range(0, len(array)):
        if leftMax[i] == rightMin[i]:
            number = leftMax[i]
            return number

    return number


array = [4, 3, 2, 7, 8, 9]
# array = [5, 1, 4, 3, 6, 7, 1, 8, 10, 6, 9]
print(findNumber())
