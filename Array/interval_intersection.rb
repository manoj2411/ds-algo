# 986. Interval List Intersections
def interval_intersection(a, b)
    i1 = i2 = 0
    result = []

    while i1 < a.length && i2 < b.length
        s1, e1 = a[i1]
        s2, e2 = b[i2]

        if s1 > e2
            i2 += 1
            next
        elsif s2 > e1
            i1 += 1
            next
        end

        result << [
            [s1,s2].max,
            [e1,e2].min
        ]

        if e1 > e2
            i2 += 1
        else
            i1 += 1
        end
    end
    result
end

a = [[0,2],[5,10],[13,23],[24,25]]
b = [[1,5],[8,12],[15,24],[25,26]]
puts interval_intersection(a, b).to_s # [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
