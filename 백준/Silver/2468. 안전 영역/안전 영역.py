import sys
# dfs 사용하여 막히면 닫는다

def dfs(x, y):
    global n, h, mapList, mapCheck

    mapCheck[x][y] = True

    # 인접 노드 (갈 수 있는)
    goList = [[x-1, y], [x, y-1], [x+1, y], [x, y+1]]
    for gX, gY in goList:
        if gX < 0 or gY < 0 or gX >= n or gY >= n:
            continue
        if not mapList[gX][gY] > h:
            continue
        if not mapCheck[gX][gY]:
            dfs(gX, gY)

    return

sys.setrecursionlimit(100000)
input = sys.stdin.readline
n = int(input())
mapList = []
mapCheck = [[False for _ in range(n)] for _ in range(n)]
maxH = 0
for _ in range(n):
    targetList = list(map(int, input().split()))
    mapList.append(targetList)
    if maxH < max(targetList):
        maxH = max(targetList)

maxA = 0
for h in range(0, maxH+1):
    cnt = 0
    mapCheck = [[False for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            cur = mapList[i][j]
            sList = []
            if cur > h and not mapCheck[i][j]:
                dfs(i, j)
                cnt += 1
    if maxA < cnt:
        maxA = cnt


print("%d" %maxA)