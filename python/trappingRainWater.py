# Source: https://practice.geeksforgeeks.org/problems/trapping-rain-water/0
# Brute force technique
# Time Complexity: O(n)

list = [1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]


def main():
    result = 0
    for i in range(0, len(list)):
        number = min(lmax(i), rmax(i))
        if(number >= list[i]):
            result += number - list[i]
    print(result)


def lmax(i):
    l = list[: i]
    if len(l) == 0:
        return 0
    else:
        return max(l)





def rmax(i):
    l = list[i+1: len(list)]

    if len(l) == 0:
        return 0
    else:
        return max(l)


main()



