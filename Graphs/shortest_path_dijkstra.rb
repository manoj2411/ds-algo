Edge = Struct.new(:u,:v,:weight)
Node = Struct.new(:val, :parent, :weight)

# Module Forwardable is a part of Std-lib and it provides you delegation of specified
# methods to a designated object
# http://ruby-doc.org/stdlib-2.0.0/libdoc/forwardable/rdoc/Forwardable.html
require 'forwardable'
require "byebug"

# Minimum priority queue implementation
# Parent must be <= its children, means root node is always minimum.
# - deletion will be from root of the node i.e. 0th element
# - insertion is at the end of the list i.e. last element and we call healify to
#   adjust the parent nodes.
class MinPQueue

  def initialize
    @list = [nil]
  end

  def length
    list.length - 1
  end

  def add_item(item)
    list.push item
    heapify(length)
  end

  def dequeue
    raise 'Queue Empty' if length < 1
    return(list.delete_at(1)) if length ==  1

    root_element = list[1]
    last_element = list.delete_at(length)
    list[1] = last_element
    reheapify(1)
    return root_element
  end

  def to_s
    list.inspect
  end

  private
    attr_accessor :list

    def heapify(indx)
      return if indx <= 1 # i.e. 1 which is nill or 2 which is first element, then do nothing and return
      parent_index_of_element = indx / 2

      if list[parent_index_of_element].weight > list[indx].weight
        tmp = list[parent_index_of_element]
        list[parent_index_of_element] = list[indx]
        list[indx] = tmp
        heapify(parent_index_of_element)
      end
    end

    def reheapify(indx)
      child_indexs_start = (length / 2) + 1
      if indx >= child_indexs_start
        return
      else
        child1 = indx * 2
        child2 = (indx * 2) + 1

        if !list[child1].nil? && list[indx].weight > list[child1].weight
          tmp = list[indx]
          list[indx] = list[child1]
          list[child1] = tmp
          reheapify(child1)
        end

        if !list[child2].nil? && list[indx].weight > list[child2].weight
          tmp = list[indx]
          list[indx] = list[child2]
          list[child2] = tmp
          reheapify(child2)
        end
      end
    end
end

class Graph
  attr_accessor :vertices
  def initialize(vertices, edges)
    self.vertices = vertices
    @mapping = Hash.new()
    process_edges(edges)
  end

  def process_edges(edges)
    edges.each do |edge|
      mapping[edge.u] ||= []
      mapping[edge.v] ||= []
      mapping[edge.u].push edge
      mapping[edge.v].push edge
    end
  end

  def adjecents(vertex)
    mapping[vertex]
  end

  private
    attr_accessor :mapping
end

class ShortestPathCalculator
  attr_accessor :parent, :distance, :visited, :graph

  def initialize(graph, start)
    @parent          = graph.vertices.clone
    @distance        = Array.new graph.vertices.length, 999999
    @visited         = Array.new
    @pqueue          = MinPQueue.new
    @start           = start
    @graph = graph
    @distance[start] = 0
  end

  # 1. Take starting node Push it to priority queue
  # 2. loop until visited.length < graph.vertices.length
  # 3. pop item from priority queue,
  #   - If its not in visited then check if
  #     if distance[v] + weight < distance[u] then adjust distance[u],
  #       push u to visited and update its parent.
  def dijkstras
    starting_node = Node.new @start, @start, 0
    pqueue.add_item starting_node

    while visited.length < parent.length
      item = pqueue.dequeue

      if !visited.include?(item.val)
        if distance[item.parent] + item.weight <= distance[item.val]
          self.visited.push(item.val)
          distance[item.val] = distance[item.parent] + item.weight
          parent[item.val] = item.parent
          graph.adjecents(item.val).each do |edge|
            val    = edge.u == item.val ? edge.v : edge.u
            parent = item.val
            weight = edge.weight
            # setting these variables for clarity purpose.
            pqueue.add_item Node.new(val, parent, weight) unless visited.include?(val)
          end
        end
      end
    end
    debugger
    true
  end

  private
    attr_accessor :edges, :pqueue
end

vertices = [0,1,2,3,4]
edges = [Edge.new(0,1,1),
Edge.new(0,2,7),
Edge.new(1,2,2),
Edge.new(3,2,6),
Edge.new(3,4,4),
Edge.new(2,4,3),
Edge.new(1,3,2)]
graph = Graph.new(vertices, edges)
start_node = 0
path_cal = ShortestPathCalculator.new(graph, start_node)
path_cal.dijkstras
# debugger
# true

# pq = MinPQueue.new
# pq.add_item Edge.new(0,1,1)
# pq.add_item Edge.new(0,2,7)
# pq.add_item Edge.new(1,2,2)
# pq.add_item Edge.new(3,2,6)
# pq.add_item Edge.new(3,4,4)
# pq.add_item Edge.new(2,4,3)
# pq.add_item Edge.new(1,3,2)
# puts pq.to_s
# puts "-- dequeue: #{pq.dequeue}"
# puts "-- dequeue: #{pq.dequeue}"
# puts "-- dequeue: #{pq.dequeue}"
# debugger
# true

