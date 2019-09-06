#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Sep  5 19:36:34 2019

@author: oscar
"""

def getSubsets(arr):
    l = len(arr)
    combinations = pow(2, l)
    print("combinations:", combinations)
    for c in range(combinations):
        subset = []
        for i in range(l):
            pos = l - arr[i]
            if (pow(2, pos) & c) != 0:
                subset.append(arr[i])
        
        print(subset)
        
    
    
getSubsets([1,2,3,4,5,6,7,8])