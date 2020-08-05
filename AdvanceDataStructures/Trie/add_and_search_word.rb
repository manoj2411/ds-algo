# 211. Add and Search Word - Data structure design
#
class WordDictionary
    def initialize()
        @root = {}
    end

    def add_word(word)
        curr = @root
        word.each_char do |char|
            if curr[char] == nil
                curr[char] = {}
            end
            curr = curr[char]
        end
        curr['eow'] = true
    end

    def search(word)
        curr_nodes = [@root]

        word.each_char do |char|
            next_level = []

            curr_nodes.each do |node|
                if char == '.'
                    node.each_pair do |key, value|
                        next_level << value if key != 'eow'
                    end
                end
                next_level << node[char] if node[char]
            end

            return false if next_level.empty?

            curr_nodes = next_level
        end

        # puts curr_nodes.to_s
        curr_nodes.any? { |n| n['eow'] == true }
    end


end

obj = WordDictionary.new()
obj.add_word("a")
obj.add_word("a")
# obj.pp
puts obj.search('.') # true
puts obj.search('a') # true
puts obj.search('aa') # false
puts obj.search('a') # true
puts obj.search('.a') # false
puts obj.search('.a') # false
puts obj.search('a.') # false

puts
obj.add_word('bad')
obj.add_word('dad')
obj.add_word('mad')
obj.add_word('bat')
puts obj.search('pad') # false
puts obj.search('bad') # true
puts obj.search('.ad') # true
puts obj.search('b..') # true

# obj.pp


