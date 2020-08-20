class Trie
    EOW = "eow".freeze

    def initialize()
        @root = {}
    end

    def insert(word)
        curr = @root
        word.each_char do |chr|
            curr[chr] ||= {}
            curr = curr[chr]
        end
        curr[EOW] = true
    end

    def search(word, check_eow = true)
        curr = @root
        word.each_char do |c|
            curr = curr[c]
            return false if curr.nil?
        end
        check_eow ? curr.key?(EOW) : true
    end

    def starts_with(prefix)
        search(prefix, false)
    end
end


trie =  Trie.new();

trie.insert("apple");
puts trie.search("apple");   # returns true
puts trie.search("app");     # returns false
puts trie.starts_with("app"); # returns true
trie.insert("app");
puts trie.search("app");     # returns true
