
#Implement an algorithm to determine if a string has all unique characters. What if you
#cannot use additional data structures? - bit vector

def is_unique(text):
    charFlag = [0] * 128
    len_text = len(text)

    if len_text > 128: #if text is bigger than the possible chars it is impossible for it to have all unique chars 
        return False 

    for i in range(len_text):
        char_position = ord(text[i])

        if charFlag[char_position] == 1:
            return False
        else:
            charFlag[char_position] = 1
    return True

s = "ABCDEFasdGHIJK"
print(is_unique(s))