#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Jul 23 22:58:01 2019

@author: oscar
"""

def rotate_arr(arr, steps):
	first, next, l = 0, 0, len(arr)
	tmp = arr[first]
	for counter in range(l):
		next = (next + steps) % l
		arr[next], tmp = tmp, arr[next]
		if (next == first):
			first += 1
			next = first
			tmp = arr[first % l]
	return arr

print(shift(["a","b","c","d", "e", "f", "g", "h", "i" ], 6))
    
