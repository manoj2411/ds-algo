# Counting Elements
#   Given an integer array arr, count element x such that x + 1 is also in arr.
#   If there're duplicates in arr, count them seperately
def count_elements(arr)
  count = Array.new
  arr.each { |e| count[e] = true }
  result = 0
  arr.each do |n|
    result += 1 if count[n + 1]
  end
  result
end

for input in [
  [1,1,2], # 2
  [1,2,3], # 2
  [1,1,3,3,5,5,7,7], # 0
  [1,3,2,3,5,0], # 3
  [1,1,2,2], # 2
]
  puts "Input: #{input}"
  puts count_elements(input)
end
