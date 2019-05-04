#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri May  3 18:46:01 2019

@author: oscar
"""


"""
1.7 Rotate Matrix: Given an image  represented by an NxN matrix, where each pixel in the image is 4 bytes,
write a method to rotate the image by 90 degrees. Can you do this in place?
"""

def construct_nxn_matrix(n):
    m = [[j+(i*n)+1 for j in range(n)] for i in range(n)]
    return m

def rotate_matrix(matrix):
    n = len(matrix)
    
    first, last = 0, n-1
    
    #tmp temporary
    #tl top-left
    #bl bottom-left
    #br bottom-right
    #tr top-right
    
    for l in range(n//2): #navigates the bidimensional array layers: outside->inside
        
        for i in range(n-1-(2*l)): #i iterates rows, its length is decreasing as l travels inside the matrix
            #tmp stores tr
            tmp = matrix[first][last - i]
            
            #tr copies br
            matrix[first][last - i] = matrix[last - i][last]
            
            #br copies bl
            matrix[last - i][last] = matrix[last][first + i]
            
            #bl copies tl
            matrix[last][first + i] = matrix[first + i][first]
            
            #tl copies tmp
            matrix[first + i][first] = tmp
        
        first+=1
        last-=1

    return matrix        
        
matrix = construct_nxn_matrix(5)
print(matrix)
print(rotate_matrix(matrix))