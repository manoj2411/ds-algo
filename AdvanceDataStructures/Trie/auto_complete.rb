TrieNode = Struct.new(:children, :end_of_word) do
  def initialize(children = {}, end_of_word = false)
    super(children, end_of_word)
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
      if curr.children[chr] == nil
        curr.children[chr] = TrieNode.new
      end
      curr = curr.children[chr]
    end
    curr.end_of_word = true
  end

  def auto_complete(str)
    if str.empty?
      return ['No result']
    end
    curr = root
    str.length.times do |i|
      chr = str[i]
      if curr.children[chr] == nil
        return ['No result']
      end
      curr = curr.children[chr]
    end

    result = []
    fetch_matched(curr, str, result)
    result
  end

  def fetch_matched(curr, str, res)
    if curr == nil
      return
    end

    if curr.end_of_word == true
      res.push str
    end

    curr.children.each_pair do |chr, tnode|
      fetch_matched(tnode, str + chr, res)
    end
  end

end

trie = Trie.new

trie.insert('red')
trie.insert('rat')
trie.insert('ram')
trie.insert('rama')

p trie.auto_complete('ram')
