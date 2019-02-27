#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Jan  9 21:15:11 2019

@author: oscar
"""

#IT IS CASE SENSITIVE
def palindrome_permutation(string):
    ascii_rep = [0] * 128 #ascii representation, each slot represents a letter 1 indicates that it has been seen an odd
                          #number of times whereas 0 represents that it hasn't been seen or it has been seen an even number of times
    string = string.replace(' ','')
    
    for i in range(len(string)):    
        pos = ord(string[i])
        if ascii_rep[pos] == 0:
            ascii_rep[pos] = 1
        else:
            ascii_rep[pos] = 0
    
    if len(string) % 2 == 0: # if it is even
        for i in range(len(ascii_rep)):
            if ascii_rep[i] == 1:
                return False
    else:
        an_odd_has_been_seen = False
        for i in range(len(ascii_rep)):
            if ascii_rep[i] == 1 and an_odd_has_been_seen:
                return False
            if ascii_rep[i] == 1:
                an_odd_has_been_seen = True
    
    return True
        
    
string = "anita lava la tina"
print(palindrome_permutation(string))