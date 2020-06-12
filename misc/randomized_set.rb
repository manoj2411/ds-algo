class RandomizedSet
    def initialize()
        @arr = []
        @map = {}
    end

    def insert(val)
        return false if @map.key?(val)
        @map[val] = @arr.length
        @arr << val
        true
    end

    def remove(val)
        if @map.key?(val)
            i = @map.delete(val)
            if i == @arr.length - 1
                @arr.pop
            else
                @arr[i] = @arr[@arr.length - 1]
                @map[@arr.pop] = i
            end
            true
        else
            false
        end
    end

    def get_random()
        @arr.sample
    end

end

# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet.new()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.get_random()
