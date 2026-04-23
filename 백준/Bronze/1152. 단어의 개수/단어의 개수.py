s = input()
count = 0

if s[0] != " " and s[-1] != " ":
    count += 1
elif s[0] == " " and s[-1] == " ":
    count -= 1

for i in range(len(s)):
    if s[i] == " ":
        count += 1

print(count)
