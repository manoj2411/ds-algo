# @param {String} s
# @return {Integer}
def num_decodings(s)
    cache = Array.new(101)
    helper(s, 0, cache)
end

def helper(s, i, cache)
    return 1 if i == s.length
    return 0 if s[i] == '0'
    return 1 if i + 1 == s.length
    return cache[i] if cache[i]

    one = helper(s, i + 1, cache)

    two = ('1'..'26').include?(s[i, 2]) ? helper(s, i + 2, cache) : 0

    cache[i] = one + two
end


for s in ['12', '226', '0'] # res 2, 3, 0
	puts "msg: #{s}"
	puts "number of ways to decode it: #{num_decodings s}"
	puts
end