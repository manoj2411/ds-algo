# https://leetcode.com/problems/ugly-number-ii/
#
# @param {Integer} n
# @return {Integer}
def nth_ugly_number(n)

    min_heap = [1]
    visited = {}
    visited[1] = true

    for i in 2..n
        #
        # 1. extract from heap
        root = extract(min_heap)
        # puts "extract: #{root} \t heap: #{min_heap}"
        #
        #
        # build 3 next nums
        #  push nums which are not in visited
        [2,3,5].each do |j|
            next_num = root * j
            next if visited.key?(next_num)

            insert(min_heap, next_num)
            visited[next_num] = true
            # puts "insert: #{next_num} \t heap: #{min_heap}"
        end

    end
    # return result i.e. root of min_heap
    min_heap.first
end


def extract(min_heap)
    min = min_heap[0]
    min_heap[0] = min_heap.last
    min_heap.pop
    heapify(min_heap, 0) if not min_heap.empty?
    min
end

def heapify(arr, i)
    len = arr.length
    left = (i * 2) + 1
    right = (i * 2) + 2

    # puts "left: #{left}, len: #{len}"
    return if left >= len

    min = i
    min = left if arr[min] > arr[left]
    min = right if right < len && arr[min] > arr[right]

    if min != i
        arr[min], arr[i] = arr[i], arr[min]
        heapify(arr, min)
    end
end

def insert(min_heap, x)
    # put item at the last, now to maintain heap property compare with parent
    i = min_heap.length
    min_heap[i] = x
    parent_i = parent(i)

    while i != 0 && min_heap[i] < min_heap[parent_i]
        min_heap[i], min_heap[parent_i] =  min_heap[parent_i], min_heap[i]
        i = parent_i
        parent_i = parent(i)
    end
end

def parent(i)
    (i - 1) / 2
end




puts nth_ugly_number(10) # 12
puts nth_ugly_number(67) # 500
puts nth_ugly_number(100) # 1536

# for i in 1..15
    # puts "i: #{i} \t #{nth_ugly_number(i)}"
# end

