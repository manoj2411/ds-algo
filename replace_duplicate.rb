# Input = [1,1,1,3,1,2,1,1,4,1]
# Output = [1, 5, 6, 3, 7, 2, 8, 9, 4, 10]

list = [1,1,1,3,1,2,1,1,4,1]

hash = Hash.new(0)

list.each do |element|
  hash[element] += 1
end

i = counter = 1

while i < list.size
  if hash[list[i]] > 1
    until hash[counter].zero? do
      counter += 1
    end
    list[i] = counter
    counter += 1
  end
  i += 1
end

puts 'Result: ' + list.to_s
