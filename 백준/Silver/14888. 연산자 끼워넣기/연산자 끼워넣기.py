def findMax(cur, cnt, newCal, endNum):
    global curMax, numList
    # 놓고
    # 유망성 판단
    # 다음 위치로 이동
    if cnt == endNum:
        if curMax < cur:
            curMax = cur
        return

    for ind, c in enumerate(newCal):
        if c > 0:
            a = numList[cnt]
            if ind == 0:
                newCur = cur + a
            elif ind == 1:
                newCur = cur - a
            elif ind == 2:
                newCur = cur * a
            elif ind == 3:
                if cur < 0:
                    newCur = ((-1 * cur) // a) * -1
                else:
                    newCur = cur // a

            newCnt = cnt+1
            newCalList = []
            for n in newCal:
                newCalList.append(n)
            newCalList[ind] -= 1
            findMax(newCur, newCnt, newCalList, endNum)


def findMin(cur, cnt, newCal, endNum):
    global curMin, numList
    # 놓고
    # 유망성 판단
    # 다음 위치로 이동
    if cnt == endNum:
        if curMin > cur:
            curMin = cur
        return

    for ind, c in enumerate(newCal):
        if c > 0:
            a = numList[cnt]
            if ind == 0:
                newCur = cur + a
            elif ind == 1:
                newCur = cur - a
            elif ind == 2:
                newCur = cur * a
            elif ind == 3:
                if cur < 0:
                    newCur = ((-1 * cur) // a) * -1
                else:
                    newCur = cur // a

            newCnt = cnt + 1
            newCalList = []
            for n in newCal:
                newCalList.append(n)
            newCalList[ind] -= 1
            findMin(newCur, newCnt, newCalList, endNum)


n = int(input())

numList = list(map(int, input().split()))
calculList = list(map(int, input().split()))

curMin = 100**n
curM1 = numList[0]
cntM1 = 1

curMax = -1 * (100**n)
curM2 = numList[0]
cntM2 = 1


findMax(curM1, cntM1, calculList, n)
findMin(curM2, cntM2, calculList, n)

print("%d" %curMax)
print("%d" %curMin)

'''
maxList = [mn, di, pl, mu]
minList = [pl, di, mn, mu]
maxCal = []
minCal = []
maxCals = ['-', '/', '+', '*']
minCals = ['+', '/', '-', '*']

for ind, m in enumerate(maxList):
    for i in range(m):
        maxCal.append(maxCals[ind])

for ind, m in enumerate(minList):
    for i in range(m):
        minCal.append(minCals[ind])

print(maxCal, minCal)
maxCur = aList[0]
minCur = aList[0]
for a in aList[1:]:
    maxCurCal = maxCal.pop(0)
    if maxCurCal == '+':
        maxCur += a
    elif maxCurCal == '-':
        maxCur -= a
    elif maxCurCal == '*':
        maxCur *= a
    elif maxCurCal == '/':
        if maxCur < 0:
            maxCur = ((-1 * maxCur) // a) * -1
        else:
           maxCur = maxCur // a
        print(maxCur)

    minCurCal = minCal.pop(0)
    if minCurCal == '+':
        minCur += a
    elif minCurCal == '-':
        minCur -= a
    elif minCurCal == '*':
        minCur *= a
    elif minCurCal == '/':
        print(minCur, a)
        minCur = minCur // a
        print(minCur)
print("%d" %maxCur)
print("%d" %minCur)
'''

