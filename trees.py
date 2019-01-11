#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Jan 11 11:05:23 2019

@author: oscar
"""

class Graph:
    def __init__(self, root):
        self.root = root
    
    def bfs(self, root):
        if root == None:
            return
        
        queue = []
        visited = set()
        
        current = root
        queue.append(current)
        visited.add(current)
        while(queue):
            current = queue.pop(0)
            print(current.data)
            
            for neighbor in current.neighbors:
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append(neighbor)
    
    def dfs(self, root):
        if root == None:
            return
        
        stack = []
        visited = set()
        
        stack.append(root)
        visited.add(root)

        while stack:
            current = stack.pop()
            
            print(current.data)
            
            for neighbor in current.neighbors:
                if neighbor not in visited:
                    visited.add(neighbor)
                    stack.append(neighbor)
        
        
    
        
class Node:
    def __init__(self, data):
        self.data = data
        self.neighbors = []
    
    def add_neighbor(self, neighbor):
        self.neighbors.append(neighbor)
        
node1 = Node(1)
node2 = Node(2)
node3 = Node(3)
node4 = Node(4)
node5 = Node(5)
node6 = Node(6)
node7 = Node(7)
node8 = Node(8)

#node1.add_neighbor(node2)
#node1.add_neighbor(node3)
#node1.add_neighbor(node1)

#node2.add_neighbor(node1)
#node2.add_neighbor(node3)
#node2.add_neighbor(node2)

#node3.add_neighbor(node1)
#node3.add_neighbor(node2)
#node3.add_neighbor(node3)

node1.add_neighbor(node2)
node1.add_neighbor(node3)

node2.add_neighbor(node4)
node2.add_neighbor(node5)

node3.add_neighbor(node5)
node3.add_neighbor(node6)

node5.add_neighbor(node8)

graph = Graph(node1)

graph.dfs(node1)