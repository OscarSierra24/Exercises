# -*- coding: utf-8 -*-
"""
Created on Mon Sep 10 19:17:58 2018

@author: oscar
"""

def fibonacci(n):
    if n==1:
        return 0
    if n==2:
        return 1
    else: 
        return fibonacci(n-1) + fibonacci(n-2)
    