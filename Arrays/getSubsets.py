#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Sep  5 19:36:34 2019

@author: oscar
"""

def getSubsetsIt(arr):
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


def _get_subsets_rec(arr, n):
    if len(arr) == n:
        return [[]]
    
    all_subsets = _get_subsets_rec(arr, n + 1)
    current_subset = []
    current_subsets = []
    val = arr[n]
    for subset in all_subsets:
        current_subset = list(subset)
        current_subset.append(val)
        current_subsets.append(current_subset)
        
    all_subsets.extend(current_subsets)
    return all_subsets
    

def get_subsets_rec(arr): 
    return _get_subsets_rec(arr, 0)
    
    
    
print(get_subsets_rec([1,2,3,4]))