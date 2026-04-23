n = int(input())
dp = [False] * 1001  # 상근이 승리 여부
dp[2], dp[4] = True, True
for i in range(5, 1001):
    if not dp[i-1] or not dp[i-3] or not dp[i-4]:
        dp[i] = True
print("SK" if dp[n] else "CY")
