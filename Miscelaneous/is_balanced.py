# -*- coding: utf-8 -*-
"""
Created on Mon Sep 10 09:49:37 2018

@author: oscar
"""

"""
    Checks if the input has balanced parenthesis, brackets and square brackets
"""
def is_balanced(string):
    arr = list(string)
    stack = []
    dict = {
        "(" : ")",
        "[" : "]",
        "{" : "}"
    } 
    for el in arr:
        #print(stack) #uncomment this to see how it works
        if not stack:
            stack.append(el)
        else:
            if(dict[stack[-1]] == el):
                stack.pop()
            else:
                if el in stack:
                    stack.append(el)
                else:
                    return False
    if not stack:
        return True
    else: 
        return False
    
