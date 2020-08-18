def permute_util(chars, count, result, pos)
  if pos == result.length
    puts result.join
    return
  end

  chars.each do |chr|
    next if count[chr] == 0

    # choose
    count[chr] -= 1
    result[pos] = chr

    # explore
    permute_util(chars, count, result, pos + 1)

    # un-choose
    count[chr] += 1
  end
end

def permute(str)
  count = Hash.new(0)
  str.each_char do |chr|
    count[chr] += 1
  end

  chars = count.keys.sort

  # puts chars.to_s
  # puts count.to_s
  result = Array.new(str.length)
  pos = 0
  permute_util(chars, count, result, pos)

end

for str in ['aab', 'ABAC']
  puts "Str: #{str}"
  permute(str)
  puts
end

