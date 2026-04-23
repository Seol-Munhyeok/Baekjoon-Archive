import sys

open_brackets = ['(', '[']
close_brackets = [')', ']']


def is_balanced(sentence):
    stack = []
    for letter in sentence:
        if letter in open_brackets:
            stack.append(open_brackets.index(letter))
        if letter in close_brackets:
            if len(stack) == 0:
                return 'no'
            else:
                if stack[-1] == close_brackets.index(letter):
                    stack.pop()
                else:
                    return 'no'
    if len(stack) == 0:
        return 'yes'
    else:
        return 'no'


while True:
    sentence = sys.stdin.readline()
    sentence = sentence.replace('\n', '')
    if sentence == '.':
        break
    print(is_balanced(sentence))
