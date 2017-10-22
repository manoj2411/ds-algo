require 'byebug'

class Graph

  def initialize()
    @vertices = Hash.new([])
  end

  def add(vertex, adjesent_nodes = [])
    @vertices[vertex] += adjesent_nodes
  end

  def find_all_adjecent_nodes(vertex)
    @vertices.fetch(vertex)
  end

  def vertices_connected?(node1, node2)
    @vertices.fetch(node1).include? node2
  end

  def add_edge(node1, node2)
    @vertices[node1].push node2
    @vertices[node2].push node1
  end

end

graph = Graph.new
graph.add(0, [1,4])
graph.add(1, [0,2, 4])
graph.add(2, [1,3])
graph.add(3, [2,4])
graph.add(4, [0, 1,3])

# graph.vertices_connected(0, 2)
# graph.vertices_connected(0, 4)
debugger

true






# ================ Heacker earth related changes ================ #

# graph = Graph.new
# vertices_count, edges_count =  gets.chomp.split(' ').map(&:to_i)

# 1.upto(vertices_count) do |v|
#   graph.add(v)
# end

# edges_count.times do
#   node1, node2 = gets.chomp.split(' ').map(&:to_i)
#   graph.add_edge(node1, node2)
# end


# check_count = gets.chomp.to_i

# 1.upto(check_count) do |v|
#   node1, node2 = gets.chomp.split(' ').map(&:to_i)
#   if graph.vertices_connected?(node1, node2)
#     puts "YES"
#   else
#     puts "NO"
#   end
# end

# #  =========
# #  = Input =
# #  =========
# 4 5
# 1 2  //showing edge from node 1 to node 2
# 2 4  //showing edge from node 2 to node 4
# 3 1  //showing edge from node 3 to node 1
# 3 4  //showing edge from node 3 to node 4
# 4 2
# 2 // no of queries
# 1 2
# 1 4
