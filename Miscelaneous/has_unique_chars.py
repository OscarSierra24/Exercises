#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Jan  9 00:40:50 2019

@author: oscar
"""


def has_unique_chars(string):
    visited = set()
    
    for i in range(len(string)):
        if string[i] not in visited:
            visited.add(string[i])
        else:
            return False
    return True

def has_unique_chars_without_data_structures(string):
    for i in range(len(string)-1):
        for j in range(i+1, len(string)):
            if string[i] == string[j]:
                return False
    return True

    
string = "abcdefgh"
print(has_unique_chars(string))
print(has_unique_chars_without_data_structures(string))