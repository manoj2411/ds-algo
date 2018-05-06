def form_largest(arr)
  max = get_max(arr)
  n = get_digits(max)
  pairs = build_padded_pairs(arr, n)
  # puts "#{pairs}"
  pairs = pairs.sort {|a,b| b[1] <=> a[1] }
  str = ""
  pairs.each {|e| str << "#{e[0]}"}
  return str
end

def get_max(arr)
  max = arr[0]
  for i in 0...arr.length
    if max < arr[i]
      max = arr[i]
    end
  end
  return max
end

def get_digits(num)
  "#{num}".length
end

def build_padded_pairs(arr, n)
  for i in 0...arr.length
    arr[i] = [arr[i], padded(arr[i], n + 1)]
  end
  return arr
end

def padded(num, n)
  len = get_digits num
  str = stringified(num)
  for i in len...n
    str << str[i % len]
  end
  return aoti(str)
end


def aoti(str)
  str.to_i
end

def stringified(num)
  "#{num}"
end


[[1, 34, 3, 98, 9, 76, 45, 4, 121, 12], [12, 121], [121, 12]].each do |arr|
  puts "\nArr: #{arr}"
  puts "Result: #{form_largest(arr)}"
end
