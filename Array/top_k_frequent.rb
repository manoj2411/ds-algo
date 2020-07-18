
# @param {Integer[]} nums
# @param {Integer} k
# @return {Integer[]}
def top_k_frequent(nums, k)
    _h = {}
    nums.each do |e|
        _h[e] ||= 0
        _h[e] += 1
    end
    pairs = _h.map { |k,v| [-v,k] }
    qsort(pairs, 0, pairs.length - 1, k)
    pairs.take(k).map{|pair| pair.last }
end

# modified quick sort
def qsort(arr, left, right, k)
    if left <= right
        mid = partition(arr, left, right)
        if mid == k - 1
            return
        elsif mid < k - 1
            qsort(arr, mid + 1, right, k)
        else
            qsort(arr, left, mid - 1, k)
        end
    end
end

def partition(arr, left, right)
    pivot = arr[right].first
    # mid -- all less than be in left and greater will be in right

    mid = left - 1
    for i in left..right
        if arr[i].first <= pivot
            mid += 1
            arr[i], arr[mid] = arr[mid], arr[i]
        end
    end
    mid
end

puts top_k_frequent([1,1,1,2,2,3], 2).to_s # [1, 2]
