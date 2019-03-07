#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Mar  7 13:59:18 2019

@author: oscar
"""

def urlify(string, last_char_index):
    string = list(string)
    
    new_char_pos = len(string) - 1
    
    last_char_index-=1
    for i in range(last_char_index, -1, -1):
        if string[i] == " ":
            string[new_char_pos] = "0"
            new_char_pos -= 1
            string[new_char_pos] = "2"
            new_char_pos -= 1
            string[new_char_pos] = "%"
            new_char_pos -= 1
            continue
        
        string[new_char_pos] = string[i]
        new_char_pos -= 1
    
    return "".join(string)
    

print(urlify("Mr John Smith    ", 13))