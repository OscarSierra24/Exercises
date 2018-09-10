# -*- coding: utf-8 -*-
"""
Created on Mon Sep 10 10:14:13 2018

@author: oscar
"""

#Checks if a string is anagram of another

def anagram(string_a, string_b):
    dict = {}
    for el in string_a.lower():
        if el in dict:
            dict[el] += 1
        else:
            dict[el] = 1
 
    for el in string_b.lower():
        if el in dict:
            dict[el] -= 1
            continue
        else:
            return False
    
    for key in dict:
        if dict[key] == 0:
            continue
        else:
            return False
    return True
    