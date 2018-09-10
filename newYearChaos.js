# -*- coding: utf-8 -*-
"""
Created on Mon Sep 10 10:41:00 2018

@author: oscar
"""

'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.replace(/\s*$/, '')
        .split('\n')
        .map(str => str.replace(/\s*$/, ''));

    main();
});

function readLine() {
    return inputString[currentLine++];
}

// Complete the minimumBribes function below.
function minimumBribes(q) {
    let bribes = 0;
    //generates a new array of q length
    let a = new Array(q.length)
    //fils 'a' array with the order that it is suppossed to have 
    for (let i = 0; i<a.length;i++){
        a[i] = i+1;
    }
    
    //iterates over 'a' array
    for(let i = 0; i<a.length; i++){
        if(a[i] == q[i]){
            continue;
        }
        
        //looks up to two positions to the right to see if the q[i]
        let isChaotic = true;
        for(let j = i+1; j<=i+2;j++){
            if(a[j] == q[i]){
                isChaotic = false
                while(j>i){
                    bribes = bribes + 1;
                    let save = a[j-1]
                    a[j-1] = a[j]
                    a[j] = save
                    j = j - 1;
                }
                break;
            }
        }
        if(isChaotic){
            return ("Too chaotic");
        }
    }
    return bribes
    
}

function main() {
    const t = parseInt(readLine(), 10);

    for (let tItr = 0; tItr < t; tItr++) {
        const n = parseInt(readLine(), 10);

        const q = readLine().split(' ').map(qTemp => parseInt(qTemp, 10));

        console.log(minimumBribes(q));
    }
}
