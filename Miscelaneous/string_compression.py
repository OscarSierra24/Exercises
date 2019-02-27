#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Jan 10 00:42:09 2019

@author: oscar
"""

def string_compression(string):
    if len(string) == 0:
        return string
    
    current = string[0]
    current_repeated_times = 1
    
    res = ""
    
    for i in range(len(string)):
    	if string[i] == current:
    		current_repeated_times+=1
    	else:
            res += ""+current+str(current_repeated_times)
            current = string[i]
            current_repeated_times = 0		
    
    if len(res) >= len(string):
        return string
    
    return res

string = "aaaaabbbbbcccde"
print(string_compression(string))
