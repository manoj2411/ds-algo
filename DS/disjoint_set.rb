require 'byebug'

class DisjointSet
  attr_accessor :list, :parents

  def initialize(_list)
     @list = _list
     @parents = _list.clone
  end

  def self.build(_list, _connections)
    object = new(_list)
    # object.build_conections(_connections)
    object
  end

  def find(i)
    if i == parents[i]
      parents[i]
    else
      puts "calling parents of #{i}"
      find(parents[i])
    end
  end

  def union(i, j)
    parent_i = find(i)
    parent_j = find(j)
    if parent_j != parent_i
      if j < i
        self.parents[i] = j
      else
        self.parents[j] = i
      end
    end
  end

  def connected?(i,j)
    find(i) == find(j)
  end

  #  ===================
  #  = Private methods =
  #  ===================
  private

    def build_conections(_conections)
      _conections.each do |conection|

      end
    end

end

# list = %w{a b c d e f g h i j}

# a <-> b
# b <-> d
# c <-> f
# c <-> i
# j <-> e
# g <-> j

# connections = [%w{a b},%w{b d},%w{c f},%w{c i},%w{j e},%w{g j}]
list = (0..9).to_a
connections = []
dj_set = DisjointSet.build(list, connections)
dj_set.union(2,1)
dj_set.union(4,3)
dj_set.union(8,4)
dj_set.union(9,3)
dj_set.union(6,5)
dj_set.union(2,5)
debugger
true
