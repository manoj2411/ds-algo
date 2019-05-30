def parse_input(input)
	raise 'invalid input' if input.length == 0 || input.length % 2 == 1

	petrol = []
	distance = []
	for i in 0...input.length
		if i % 2 == 0
			petrol << input[i]
		else
			distance << input[i]
		end
	end
	return petrol, distance
end

def cicular_tour(input)
	petrol, distance = parse_input(input)
	start = 0
	curr = petrol[0] - distance[0]
	i = 1

	while i != start and start < petrol.length 
		if curr < 0
			return -1 if i < start 
			start = i
			curr = 0
		end
		curr += petrol[i] - distance[i]
		i = (i + 1) % petrol.length
	end

	i == start && curr >= 0 ? start : -1
end

for input in [[4,6,6,5,7,3,4,5], [6,5,7,3,3,10,4,5,7,1,2,5,8,1], [6, 4, 3, 6, 7, 3], [4,6,6,15,7,3,4,5]]
	puts "Input: #{input}"
	puts "Result: #{cicular_tour input}"
end
