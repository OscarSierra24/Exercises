#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Mar  7 14:16:42 2019

@author: oscar
"""

def is_palindrome(string):
    char_arr = [0] * 128
    string = string.lower().replace(" ", "")
    
    for i in range(len(string)):
        char_pos = ord(string[i])
        if char_arr[char_pos] == 1:
            char_arr[char_pos] = 0
        else:
            char_arr[char_pos] = 1
     
    if len(string) % 2 == 0:
        an_odd_is_permitted = False
    else:
        an_odd_is_permitted = True
    
    for i in range(len(char_arr)):
        if char_arr[i] == 1:
            if an_odd_is_permitted:
                an_odd_is_permitted = False
                continue
            else:
                return False
    
    return True
        
            
print(is_palindrome("Tact coa"))