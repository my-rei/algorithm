import sys

n = int(sys.stdin.readline())

a = list(map(int, sys.stdin.readline().split()))
b = list(map(int, sys.stdin.readline().split()))

res = 0

a.sort()
b.sort()

for i in range(n):
    res += a[i]*b[n-i-1]
    
print(res)

