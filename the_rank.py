# -*- coding: utf-8 -*-
"""
Created on Thu Sep 20 15:38:36 2018

@author: oscar
"""

stud_numbers = int(input())
thom_smith_score = sum([int(i) for i in input().split()])
rank = 1
for i in range(1, stud_numbers):
    if(thom_smith_score < sum([int(i) for i in input().split()])):
        rank+= 1
print(rank)
    