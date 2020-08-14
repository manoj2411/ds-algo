# https://leetcode.com/problems/iterator-for-combination/
#
class CombinationIterator

    def initialize(characters, combination_length)
        @characters = characters
        @curr = (0...combination_length).to_a

    end

    def next()
        res = @curr.map{|i| @characters[i] }
        generate_next
        res.join
    end

    def has_next()
        !@curr.empty?
    end

    private
        def generate_next
            max = @characters.length - 1
            i = @curr.length - 1
            space = 1
            while i >= 0
                # asking, do I have space to increase?
                if @curr[i] <= (max - space)
                    # yes I do have space here, so lets increase
                    @curr[i] += 1
                    break
                end
                space += 1
                i -= 1
            end

            # it means I dont have space to crease, we are done
            if i == -1
                @curr = []
                return
            end

            for i in (i + 1)...@curr.length
                @curr[i] = @curr[i - 1] + 1
            end

        end

end

# Your CombinationIterator object will be instantiated and called as such:
# obj = CombinationIterator.new(characters, combination_length)
# param_1 = obj.next()
# param_2 = obj.has_next()
