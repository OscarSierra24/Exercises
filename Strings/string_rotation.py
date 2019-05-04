#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri May  3 21:43:09 2019

@author: oscar
"""

"""String Rotation: Assume you have a method i5Substring which checks ifone word is a substring
of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
call to isSubstring
"""

def isSubstring(s1, s2):
    i_s1 = 0
    l_s1 = len(s1)
    for i_s2 in range(len(s2)):
        if i_s1 >= l_s1:
            return True
        
        if s2[i_s2] == s1[i_s1]:
            i_s1+=1
            continue
        
        i_s1 = 0
    return False

def string_rotation(s1, s2):
    s2+=s2
    return isSubstring(s1,s2)
    

s1 = "waterbottle"
s2 = "aterbottlew"

print(string_rotation(s1,s2))