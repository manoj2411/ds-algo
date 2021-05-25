##  https://leetcode.com/problems/to-lower-case/

# @param {String} s
# @return {String}
def to_lower_case(s)
    lowcase = ""
    s.each_char do |ch|
        if ch.ord >= 65 && ch.ord <= 90
            lowcase << (ch.ord + 32).chr
        else
            lowcase << ch
        end
    end

    lowcase
end


for s in [ "Hello", "here", "HERO", "H! e R 0&*()"]
	puts "#{s}: #{to_lower_case s}"
end
