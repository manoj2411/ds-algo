require 'byebug'

class DisjointSet
  attr_accessor :list, :parents, :rank

  def initialize(_list)
     @list = _list
     @parents = _list.clone
     @rank = Array.new _list.length, 0
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
      parents[i] = find(parents[i])
    end
  end

  def union(i, j)
    representative_i = find(i)
    representative_j = find(j)
    if representative_j == representative_i
      return
    end

    if rank[representative_i] < rank[representative_j]
      self.parents[representative_i] = representative_j
    elsif rank[representative_j] < rank[representative_i]
      self.parents[representative_j] = representative_i
    else
      self.parents[representative_i] = representative_j
      self.rank[representative_j] = rank[representative_j] + 1
    end
  end

  def connected?(i,j)
    find(i) == find(j)
  end

  #  ===================
  #  = Private methods =
  #  ===================
  # private

  #   def build_conections(_conections)
  #     _conections.each do |conection|

  #     end
  #   end

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
# debugger
# true
