def is_unique(text):
    charFlag = [0] * 128
    len_text = len(text)

    for i in range(len_text):
        char_position = ord(text[i])

        if charFlag[char_position] == 1:
            return False
        else:
            charFlag[char_position] = 1
    return True

s = "ABCDEFasdGHIJK"
print(is_unique(s))