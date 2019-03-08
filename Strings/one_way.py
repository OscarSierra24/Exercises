#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Mar  7 14:48:46 2019

@author: oscar
"""

def one_away(str_a, str_b):
    len_a = len(str_a)
    len_b = len(str_b)
    
    if abs(len_a - len_b) > 1:
        return False
    
    jumps = 1
    if len_a < len_b or len_a == len_b:
        a = str_a
        b = str_b
        if len_a == len_b:
            jumps = 0
    else:
        a = str_b
        len_a = len_b
        b = str_a
    
    j = 0
    change_happened = False
    for i in range(len_a):
        print(a[i], b[j])
        if a[i] != b[j]:
            if change_happened:
                return False
            else:
                j+=jumps
                change_happened = True
        j+=1
        
    return True
        
        
print(one_away("pale", "pale"))