def permute_util(chars, count, result, level)
  if level == result.length
    puts result.join
    return
  end
  chars.each do |chr|
    next if count[chr] == 0
    # choose
    count[chr] -= 1
    result[level] = chr

    # explore
    permute_util(chars, count, result, level + 1)

    # un-choose
    count[chr] += 1
  end
end

def permute(str)
  count = {}
  str.each_char do |chr|
    count[chr] ||= 0
    count[chr] += 1
  end

  chars = count.keys.sort

  # puts chars.to_s
  # puts count.to_s
  result = Array.new(str.length)
  level = 0
  permute_util(chars, count, result, level)

end

permute('ABAC')
