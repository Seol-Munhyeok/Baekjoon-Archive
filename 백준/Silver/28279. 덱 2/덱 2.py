from collections import deque
import sys

q = deque()


def process_command(command):
    cmd = int(command[0])

    if cmd == 1:
        num = int(command[1])
        q.append(num)

    if cmd == 2:
        num = int(command[1])
        q.appendleft(num)

    if cmd == 3:
        try:
            print(q.pop())
        except IndexError:
            print(-1)

    if cmd == 4:
        try:
            print(q.popleft())
        except IndexError:
            print(-1)

    if cmd == 5:
        print(len(q))

    if cmd == 6:
        if len(q) == 0:
            print(1)
        else:
            print(0)

    if cmd == 7:
        try:
            print(q[-1])
        except IndexError:
            print(-1)

    if cmd == 8:
        try:
            print(q[0])
        except IndexError:
            print(-1)


n = int(sys.stdin.readline())
for _ in range(n):
    command = sys.stdin.readline().split()
    process_command(command)
