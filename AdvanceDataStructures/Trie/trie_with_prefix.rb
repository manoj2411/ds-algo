class Trie
    EOW = "eow".freeze

    def initialize()
        @store = {}
    end

    def insert(word)
        curr = @store
        for i in 0...(word.length)
            chr = word[i]
            curr[chr] = curr[chr] || {}
            curr = curr[chr]
        end
        curr[EOW] = true
    end

    def search(word, check_eow = true)
        curr = @store
        for i in 0...(word.length)
            return false if !curr.key?(word[i])
            curr = curr[word[i]]
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
