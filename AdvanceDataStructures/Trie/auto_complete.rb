TrieNode = Struct.new(:child_nodes, :end_of_word) do
  def initialize(child_nodes = {}, end_of_word = false)
    super(child_nodes, end_of_word)
  end
end

class Trie
  attr_accessor :root

  def initialize()
    @root = TrieNode.new
  end

  def insert(str)
    curr = root
    str.each_char do |chr|
        curr.child_nodes[chr] ||= TrieNode.new
        curr = curr.child_nodes[chr]
    end
    curr.end_of_word = true
  end

  def search_prefix(str)
    curr = root

    str.each_char do |chr|
      curr = curr.child_nodes[chr]
      return [] if curr == nil
    end

    all_words(curr, str)
  end

  def all_words(node, str)
    result = []
    que = Queue.new
    que.enq([node, str])

    while not que.empty?
      curr, s = que.deq

      result.push s if curr.end_of_word

      curr.child_nodes.each_pair do |chr, child_node|
        que.enq([child_node, s + chr])
      end
    end

    result
  end

end

trie = Trie.new

trie.insert('red')
trie.insert('rat')
trie.insert('ram')
trie.insert('rama')

p trie.search_prefix('ram')
p trie.search_prefix('r')
p trie.search_prefix('room')
p trie.search_prefix('')
p trie.search_prefix('bat')

