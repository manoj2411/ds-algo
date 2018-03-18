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

(1..15).each do |e|
  puts "Fact of #{e}: #{factorial(e)} "
end
