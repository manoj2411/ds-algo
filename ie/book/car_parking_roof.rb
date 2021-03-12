def carParkingRoof(cars, k)
    cars.sort!

    left = 0
    right = k - 1

    res = Float::INFINITY

    while right < cars.length
        roof_len = cars[right] - cars[left] + 1
        res = roof_len if res > roof_len

        left += 1
        right += 1
    end

    res
end


c = [6,2,12,7]
k = 3
# 6
puts carParkingRoof(c, k)


c = [2,10,8,17]
k = 3
# 9
puts carParkingRoof(c, k)

c = [1,2,3,10]
k = 4
# 10
puts carParkingRoof(c, k)


k = 10
puts carParkingRoof(c, k)