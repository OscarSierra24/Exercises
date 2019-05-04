#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri May  3 20:54:29 2019

@author: oscar
"""

""" 1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0."""

import random

def zero_matrix(m):
   row = set()
   col = set()
   
   l_r = len(m)
   l_c = len(m[0])
   
   for i in range(l_r):
       for j in range(l_c):
           if m[i][j] == 0:
               row.add(i)
               col.add(j)

   for i in row:
       for j in range(l_c):
           m[i][j] = 0
           
   for j in col:
       for i in range(l_r):
           m[i][j] = 0
           
   return m
   
    
   


def generate_random_matrix(m,n,minVal,maxVal):        
    matrix = [[random.randint(minVal,maxVal) for j in range(n)] for i in range(m)] 
    return matrix

m = generate_random_matrix(5,5,0,10)
print(m)
zero_matrix(m)
print(m)