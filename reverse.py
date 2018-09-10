# -*- coding: utf-8 -*-
"""
Created on Mon Sep 10 12:35:36 2018

@author: oscar
"""
"reverses a string ej. Oscar Sierra becomes arreiS racsO"
def reverse(string):
    if len(string) == 0:
        return ""
    return string[-1] + reverse(string[0:len(string)-1])