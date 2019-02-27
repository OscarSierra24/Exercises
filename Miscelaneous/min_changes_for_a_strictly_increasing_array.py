def len_of_longest_non_decreasing_subsequence(arr):
    lds = [1] * len(arr)
    max_len = lds[0]
    for i in range(1, len(lds)):
        for j in range(0, i):
            if arr[j] <= arr[i]:
                lds[i] = max(lds[i], lds[j] + 1)
                if lds[i] > max_len:
                    max_len = lds[i]
    return max_len
    
    
def min_changes_for_a_strictly_increasing_array(arr):
    memory = [0] * len(arr)
    for i in range(0, len(arr)):
        memory[i] = arr[i] - i
    lolnds = len_of_longest_non_decreasing_subsequence(memory)
    return len(arr) - lolnds

arr = [3,2,1,0]
min_changes_for_a_strictly_increasing_array(arr)
