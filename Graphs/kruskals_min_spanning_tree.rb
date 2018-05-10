require "byebug"
#  ===============================
#  = Disjoint set data structure =
#  ===============================
Edge = Struct.new(:v1, :v2, :weight)
@edges = []
@visited_tree_vertices = []
@parent = (0..4).to_a
@vertices = (0..4).to_a

def add_edge(v1, v2, weight)
  @edges.push Edge.new(v1, v2, weight)
end

def sort_edges
  @edges.sort_by! { |e| e.weight}
end

def find(i)
  if @parent[i] == i
    return i
  else
    @parent[i] = find(@parent[i])
  end
end

def union(i, j, rep_i, rep_j)
  if rep_i < rep_j
    @parent[rep_j] = rep_i
  else
    @parent[rep_i] = rep_j
  end
end

def create_spanning_tree
  visited_tree_vertices_length = 0
  weight_count = 0
  selected_edges = []
  @edges.each do |edge|
    # break if visited_tree_vertices_length >= (@vertices.length - 1)
    rep_i, rep_j = find(edge.v1), find(edge.v2)
    next if rep_i == rep_j
    union(edge.v1, edge.v2, rep_i, rep_j)
    visited_tree_vertices_length += 1
    weight_count += edge.weight
    selected_edges.push edge
  end
  puts "selected_edges: #{selected_edges}"
  puts "Weight: #{weight_count}"
end

add_edge(0,2,7)
add_edge(0,1,1)
add_edge(1,2,5)
add_edge(1,3,4)
add_edge(1,4,3)
add_edge(2,4,6)
add_edge(3,4,2)
sort_edges
create_spanning_tree

