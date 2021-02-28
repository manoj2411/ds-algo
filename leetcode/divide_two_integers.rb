# https://leetcode.com/problems/divide-two-integers/
#
# @param {Integer} dividend
# @param {Integer} divisor
# @return {Integer}
def divide(dividend, divisor)
    return 0 if dividend == 0

    is_neg = true if (dividend < 0 && divisor > 0) || (divisor < 0 && dividend > 0)

    dividend = dividend.abs
    divisor = divisor.abs

    res = 0

    while dividend >= divisor

        val = divisor
        mul = 1

        while true

            new_val = val + val

            if dividend >= new_val
                val = new_val
                mul += mul
            else
                break
            end
        end

        res += mul
        dividend -= val

    end

    res = is_neg ? -res : res

    max = (2**31) - 1
    res > max ? max : res

end

puts divide(10, 3) # 3

puts divide(7, -3) # -2

puts divide(-10, -3) # 3
