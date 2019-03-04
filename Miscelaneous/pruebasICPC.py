#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Feb 16 11:48:24 2019

@author: oscar
"""

class Node:
    def __init__(self, value):
        self.value = value
        self.next = None

    def next(self, value):
        self.next = value
class ll:
    def __init__(self, value):
        node = Node(value)
        self.head = node
        self.tail = node
        
    def add(self, value): 
        new_node = Node(value)               
        self.tail.next = new_node
        self.tail = self.tail.next
    
    def get_node(self, pos):
        current = self.head
        
        for i in range(pos):
            if(current == None):
                return None
            current = current.next
        
        return current

#---------------------------------------------------------- 
def count_pairs(ll_1, ll_2, value):
    memory = set()
    result = 0
    
    current = ll_1.head
    while(current != None):
        memory.add(current.value)
        current = current.next

    current = ll_2.head
    while(current!=None):
        if (value - current.value) in memory:
            result+=1
        current = current.next
            
    return result

#ll_1 = ll(5)
#ll_1.add(4)
#ll_1.add(3)
#ll_1.add(2)
#ll_1.add(1)
#ll_2 = ll(4)
#ll_2.add(10)
#ll_2.add(11)
#ll_2.add(12)
#ll_2.add(13)
#print(count_pairs(ll_1, ll_2, 15)) 
#--------------------------------------------------------------
def are_identical(ll_1, ll_2):
    current_1 = ll_1.head
    current_2 = ll_2.head
    
    if(current_1 == None and current_2 == None):
        return True
    
    while(current_1.value == current_2.value):
        current_1 = current_1.next
        current_2 = current_2.next
        if(current_1 == None and current_2 == None):
            return True
    
    return False

        
"""ll_1 = ll(5)
ll_1.add(4)
ll_1.add(3)
ll_1.add(2)
ll_1.add(1)
ll_2 = ll(5);
ll_2.add(4);
ll_2.add(3);
ll_2.add(2);
ll_2.add(1);

are_identical(ll_1, ll_2)"""
#--------------------------------------------------------------
    
def sum_of_last_n_nodes(ll, n):
    p1 = ll.head
    p2 = ll.head
    
    for i in range(n):
        if p2 != None:
            p2 = p2.next
    
    while(p1 != None):
        if(p2 == None):
            break
        
        p2 = p2.next
        p1 = p1.next
    
    res = 0
    while(p1 != None):
        res+= p1.value
        p1 = p1.next
    return res
    
#ll_1 = ll(5)
#ll_1.add(4)
#ll_1.add(3)
#ll_1.add(2)
#ll_1.add(1)
#print(sum_of_last_n_nodes(ll_1, 0))

#-----------------------------------------------------------------

def is_circular_ll(ll):
    l = ll.head
    t = ll.head
    while(l != None):
        l = l.next
        if(l == None):
            return False
        l = l.next
        if(l == None):
            return False
        t = t.next

        if(l == t):
            return True
    
    
#ll_1 = ll(5)
#ll_1.add(4)
#ll_1.add(3)
#ll_1.add(2)
#ll_1.add(1)
#ll_1.tail.next = ll_1.get_node(2)

#print(is_circular_ll(ll_1))       
#-----------------------------------------------------------------    

def strcmp(ll_a, ll_b):
    #return 0 when ll are equal, return -1 when ll_b is lexicographycally greater, return 1 when ll_a is lexicographycally greater
    p_a = ll_a.head
    p_b = ll_b.head
    
    while(p_a != None and p_b != None):
        if ord(p_a.value) == ord(p_b.value):
            p_a = p_a.next
            p_b = p_b.next
            continue
        
        if ord(p_a.value) < ord(p_b.value):
            return 1
        else:
            return -1
        
    if p_a == None and p_b != None:
        return 1
    elif p_a != None and p_b == None:
        return -1
    
    return 0
    
    
    
"""ll_1 = ll("a")
 
ll_2 = ll("a")
ll_2.add("b") 
ll_2.add("c")
ll_2.add("d")
ll_2.add("e")
ll_2.add("f")
ll_2.add("g")   

print(strcmp(ll_1, ll_2))
""" 
#----------------------------------------------------------------

def make_union(ll_a, ll_b):
    current = ll_a.head
    memory = set()
    ll_c = ll_b
    
    while current != None:
        memory.add(current.value)
        current = current.next
    
    current = ll_b.head
    while(current != None):
        if current.value not in memory:
            ll_c.add(current)
    return ll_c
    
        

ll_1 = ll(1)
ll_1.add(2)
ll_1.add(3) 
ll_1.add(4)
ll_1.add(8)  

ll_2 = ll(2)
ll_2.add(3) 
ll_2.add(1)
ll_2.add(9)  

ll_c = make_union(ll_1, ll_2)
print(ll_c.get_node(1).value)
























   
    