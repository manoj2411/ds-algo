#   https://leetcode.com/problems/next-greater-element-iii/
#

# @param {Integer} n
# @return {Integer}
def next_greater_element(n)

    digits = Array.new(10, 0)
    remaining = n
    flag = true

    while remaining > 10
        last = remaining % 10
        remaining /= 10
        digits[last] += 1

        if remaining % 10 < last # if (last - 1)th digit < last digit
            last = remaining % 10
            remaining /= 10

            digits[last] += 1
            remaining = (remaining * 10) + next_greater_digit(digits, last)

            flag = false
            break
        end
    end

    return -1 if flag

    for i in 0..9
        digits[i].times do
            remaining = (remaining * 10) + i
        end
    end

    remaining <= (2 ** 31) - 1 ? remaining : -1
end

def next_greater_digit(digits, min)
    d = min + 1
    while d < 10
        if digits[d] > 0
            digits[d] -= 1
            return d
        end
        d += 1
    end
end

# sample tests
for n in [12,21,12443322,1999999999,7,99963]
    puts "next greater element for #{n} : #{next_greater_element(n)}"
end
