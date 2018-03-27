class MinHeap
  attr_reader :matrix, :arr, :n

  def initialize(matrix)
    @matrix = matrix
    @n = matrix[0].length
    @arr = []
  end

  def build_from_matrix
    matrix.each_with_index do |list, row|
      insert(list[0], row, 0)
    end
  end

  def size
    arr.length
  end

  def insert(key, row, indx)
    i = arr.length
    arr[i] = {key: key, row: row, indx: indx}
    while i != 0
      # parent
      parent = (i - 1) / 2
      if arr[parent][:key] > arr[i][:key]
        arr[parent], arr[i] = arr[i], arr[parent]
        i = parent
      else
        break
      end
    end
  end

  def extract
    key = arr[0][:key]

    if arr[0][:indx] == n - 1
      arr[0] = arr.pop
    else
      indx = arr[0][:indx]
      row = arr[0][:row]
      arr[0][:key] = matrix[row][indx + 1]
      arr[0][:indx] = indx + 1
    end
    heapify(0)
    return key
  end

  def heapify(indx)
    left_c = (indx * 2) + 1
    right_c = (indx * 2) + 2
    smallest = indx

    if right_c < size && arr[smallest][:key] > arr[right_c][:key]
      smallest = right_c
    end

    if left_c < size && arr[smallest][:key] > arr[left_c][:key]
      smallest = left_c
    end

    if smallest != indx
      arr[smallest], arr[indx] = arr[indx], arr[smallest]
      heapify(smallest)
    end
  end
end


def merge_k_sorted_arrays(matrix)

  result = Array.new(matrix.length * matrix[0].length)

  heap = MinHeap.new matrix
  heap.build_from_matrix

  0.upto(result.length - 1).each do |i|
    result[i] = heap.extract
  end

  return result
end

# arrays = [
#   [1,3,5,7],
#   [2,4,6,8],
#   [0,9,10,11]
# ]

arrays = [
  [2, 6, 12, 34],
  [1, 9, 20, 1000],
  [23, 34, 90, 2000]
]
list = merge_k_sorted_arrays(arrays)

puts "Result: #{list}"
