require "pry"

class TrieNode
  attr_accessor :is_end_of_word, :children

  def initialize
    @is_end_of_word = false
    @children = {}
  end
end

class Trie
  attr_accessor :head

  def initialize
    @head = TrieNode.new
  end

  def insert(str)
    curr_node = head
    str.each_char do |char|
      if curr_node.children[char] == nil
        curr_node.children[char] = TrieNode.new
      end
      curr_node = curr_node.children[char]
    end
    curr_node.is_end_of_word = true
  end

  def search(str)
    curr_node = head
    str.each_char do |chr|
      if curr_node.children[chr] == nil
        print "\"#{str}\" does not exists: "
        return false
      end
      curr_node = curr_node.children[chr]
    end
    if curr_node.is_end_of_word == true
      print "\"#{str}\" exists: "
      return true
    end
    print "\"#{str}\" does not exists: "
    return false
  end

end

trie = Trie.new

["the", "a", "there","answer", "any", "by","bye", "their" ].each do |str|
  trie.insert(str)
end
binding.pry
true

puts trie.search('an')
puts trie.search('any')
puts trie.search('anyone')
puts trie.search('the')
puts trie.search('these')

