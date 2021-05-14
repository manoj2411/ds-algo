def ambiguous_coordinates(s)
	res = []
    len = s.length - 1

    for i in 2...len
        left = s[1...i]
        right = s[i...len]

        valid_x = build_valid_doubles(left)
        valid_y = build_valid_doubles(right)

        valid_x << left if left == left.to_i.to_s
        valid_y << right if right == right.to_i.to_s

        for x in valid_x
            for y in valid_y
                res << "(#{x}, #{y})"
            end
        end
    end

    res
end

def build_valid_doubles(str)
    len = str.length
    return [] if len <= 1

    doubles = []

    # "123" => "1.23", "12.3"
    for i in 1...len
        l = str[0...i]
        r = str[i...len]

        next if l.length > 1 && l.start_with?("0")
        next if r.end_with?("0")

        doubles << l + "." + r
    end

    doubles
end


for str in [
	"(123)",
	"(00011)",
	"(0123)",
	"(100)",
	"(0000001)"
]


	puts str
	puts ambiguous_coordinates(str).to_s
	puts
end
