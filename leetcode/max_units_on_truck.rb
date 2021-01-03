# 	https://leetcode.com/problems/maximum-units-on-a-truck/

# @param {Integer[][]} box_types
# @param {Integer} truck_size
# @return {Integer}
def maximum_units(box_types, truck_size)
    box_types.sort_by! {|e| -e[1] }

    max_units = 0

    box_types.each do |num, units|
        if truck_size > num
            max_units += num * units
            truck_size -= num
        else
            max_units += truck_size * units
            break
        end
    end

    max_units
end


boxTypes = [[1,3],[2,2],[3,1]]
truckSize = 4
puts maximum_units(boxTypes, truckSize) # 8

boxTypes = [[5,10],[2,5],[4,7],[3,9]]
truckSize = 10
puts maximum_units(boxTypes, truckSize) # 91