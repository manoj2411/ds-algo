require "pry"

class TrieNode
  ALPHABET_SIZE = 26
  attr_accessor :is_end_of_word, :children

  def initialize
    @is_end_of_word = false
    @children = Array.new(ALPHABET_SIZE, false)
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
      indx = char.ord - 'a'.ord
      if curr_node.children[indx] == false
        curr_node.children[indx] = TrieNode.new
      end
      curr_node = curr_node.children[indx]
    end
    curr_node.is_end_of_word = true
  end

  def search(str)
    curr_node = head
    str.each_char do |chr|
      indx = chr.ord - 'a'.ord
      if curr_node.children[indx] == false
        print "\"#{str}\" does not exists: "
        return false
      end
      curr_node = curr_node.children[indx]
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

puts trie.search('an')
puts trie.search('any')
puts trie.search('anyone')
puts trie.search('the')
puts trie.search('these')

# binding.pry
# true
