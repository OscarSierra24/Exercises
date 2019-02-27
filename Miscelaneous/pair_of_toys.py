# -*- coding: utf-8 -*-
"""
Created on Wed Sep 19 12:24:21 2018

@author: oscar
"""

import math

def combinations(num_toys, total_cost):
    if(num_toys + num_toys-1 < total_cost or total_cost <= 2):
        return 0
    else:
        if total_cost > num_toys:
            rigth = num_toys
        else:
            rigth = total_cost - 1
        
        left = total_cost - rigth
        
        answer = rigth - left
        answer/=2  
        return math.ceil(answer)
        
    
print(combinations(1000000000000, 1000000000001))