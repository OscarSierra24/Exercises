#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Jan  9 21:46:51 2019

@author: oscar
"""

import math

def one_way(str1, str2):
    if (math.fabs(len(str1) - len(str2)) > 1): #if length differences exceed 1, then we can assume there are more than 1 string movements (insert, delete, replace)
        return False
    
    modifications_done = 0
    str1_aux, str2_aux = 0, 0
    
    if len(str1) != len(str2): #insertion or remove
       for i in range((len(str1))):
           print(i+str1_aux)
           if i+str1_aux >= len(str1)-1:
               break
           
           if str1[i+str1_aux] != str2[i+str2_aux]:
               modifications_done += 1
               if len(str1) > len(str2):
                   str1_aux+=1
               else:
                   str2_aux+=1
                  
           if modifications_done > 1:
                return False
        
    else: #replace case
        for i in range(len(str1)):
            if str1[i] != str2[i]:
                modifications_done += 1
            
            if modifications_done > 1:
                return False
    
    return True
        
    

string1, string2 = "pale", "baes"
print(one_way(string1, string2))