#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Mar  2 16:18:25 2019

@author: oscar
"""

def is_permutation(s_a, s_b):
    if len(s_a) != len(s_b):
        return False

    char_freq_table = [0] * 128
    for char in s_a:
        char_freq_table[ord(char)] += 1
    for char in s_b:
        char_freq_table[ord(char)] -= 1
    
    for val in char_freq_table:
        if val != 0:
            return False
    return True

s_a = "Hello world"
s_b = "world Holel"
print(is_permutation(s_a, s_b))