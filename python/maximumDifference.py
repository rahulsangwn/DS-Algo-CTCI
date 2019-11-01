# Source: https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
# Using minElement and maxDiff
# Time Complexity: O(n)

def maxDiff():
    minEle = array[0]
    maxDiff = array[1] - array[0]

    for i in range(0, len(array)):
        if array[i] < minEle:
            minEle = array[i]

        if array[i] - minEle > maxDiff:
            maxDiff = array[i] - minEle

    return maxDiff

array = [2, 3, 10, 6, 4, 8, 1]
print(maxDiff())