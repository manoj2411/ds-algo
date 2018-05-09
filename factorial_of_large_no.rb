def factorial(num)
  result = "1"
  2.upto(num) do |i|
    carry = 0
    tmp = ""
    result.each_char do |chr|
      digit = (chr.to_i * i) + carry
      # binding.pry
      tmp << (digit % 10).to_s
      carry = digit / 10
    end
    # binding.pry
    while carry > 0
      tmp << (carry % 10).to_s
      carry = carry / 10
    end
    result = tmp
  end
  result.reverse
end

# better performing!
def fact(n)
  if n == 0 || n == 1
    return 1
  end

  arr = [1]

  for i in 2..n
    carry = 0

    for j in 0...arr.length
      num = (arr[j] * i) + carry
      arr[j] = num % 10
      carry = num / 10
    end

    if carry > 0
      arr[arr.length] = carry
    end
  end

  return arr.reverse.join
end

(1..15).each do |e|
  # factorial(e)
  # fact(e)
  # puts "Fact of #{e}: #{factorial(e)} "
  puts "Fact of #{e}: #{fact(e)} "
end
