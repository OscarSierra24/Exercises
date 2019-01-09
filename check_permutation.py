#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Jan  9 00:53:45 2019

@author: oscar
"""


def check_permutation(string1, string2):
    if len(string1) != len(string2):
        return False
    
    known_chars = {} #known chars that one string contains and their respective frequency
    
    for i in range(len(string1)):
        if string1[i] not in known_chars:
            known_chars[string1[i]] = 1
        else:
            known_chars[string1[i]] += 1
    
    for i in range(len(string2)):
        if string1[i] in known_chars:
            if known_chars[string1[i]] == 1:
                del known_chars[string1[i]]
            else:
                known_chars[string1[i]] -= 1
        else:
            return False
    
    if not known_chars:
        return True
    else:
        return False


string1, string2 = "abcedfga", "gfdebcaa"
print(check_permutation(string1, string2))