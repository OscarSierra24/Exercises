# -*- coding: utf-8 -*-
"""
Created on Mon Sep 10 19:17:58 2018

@author: oscar
"""

def fibonacci(n, mem):
    if n==1:
        mem[1] = 1
        return 0
    if n==2:
        mem[2] = 1
        return 1
    else:
        if mem[n] is None:
            mem[n] = fibonacci(n-1, mem) + fibonacci(n-2, mem)
        return mem[n]