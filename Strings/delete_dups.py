#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri May  3 23:37:03 2019

@author: oscar
"""

class Node:
    def __init__(self, value):
        self.value = value
        self.next = None
class ll:
    def __init__(self):
        self.head = None
        self.tail = None
    
    def insert(self, value):
        new_node = Node(value)
        if self.tail == None:
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node
    
    def print_ll(self):
        current = self.head
        while current != None:
            print(current.value + "-->", end="")
            current = current.next
        print("None")
        
    def delete_duplicates(self):
        seen = set()
        current = self.head
        prev = current
        while(current != None):
            #print("current: ", current.value, "prev: ", prev.value)
            if current.value in seen:
                prev.next = current.next
            else: 
                seen.add(current.value)
                prev = current

            current = current.next
            
        
    
ll = ll()
ll.insert("a")
ll.insert("b")
ll.insert("c")
ll.insert("d")
ll.insert("a")
ll.insert("b")
ll.insert("a")
ll.insert("e")
ll.insert("e")
ll.insert("d")

print("ll with duplicates:")
ll.print_ll()
ll.delete_duplicates()
print("--------------------------")
print("ll without duplicates")
ll.print_ll()
    