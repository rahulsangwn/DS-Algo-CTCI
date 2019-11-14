def remove(str):
    string = list(str)

    flag = 1
    while flag == 1:
        i = 0
        j = 1
        flag = 0
        flag2 = 0
        while j < len(string):
            while j < len(string) and string[i] == string[j]:
                flag = 1
                flag2 = 1
                temp = string.pop(j)
            if flag2 == 1:
                string.pop(i)
                flag2 = 0
            i = i + 1
            j = j + 1

    for i in range(len(string)):
        print(string[i], end="")
def main():
    testCases = int(input())

    for i in range(testCases):
        remove(input())
        print()

main()