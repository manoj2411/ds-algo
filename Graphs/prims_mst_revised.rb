# We have to maintain 2 sets
#   1 for vertices that are added to MST
#   1 for vertices that are not added in MST
#   We select a starting point and keep on processing the next least costliest
#   vertex(edge) from the remaining edges(vertices)
#

#
# We have to maintain a priority queue with vertex & cast to reach that vertex
# we pop the vertex-cost pair from priority queue,
#   - add its weight to the MST cost
#   - We also maintain and update a vertex-parent list to get form the edges
#   - remove the vertex from not added in MST set
#   - add the vertex to added in MST set
#
# We can use BinaryHeap to maintain priority
#   - Select a start vertex whoes parent will be nil and cost will be 0
#   - Add all other vertices to head with weight a very large number
#   - As we extract and process a vertext, we take all its edges or related vertices
#     and udpdate parent and their cost if it is less then the present cost
#   - Heap maintains the order and always take least coslty vertex at top and this
#     is what prim's algorithm require.

require 'pry'

class Graph
  Edge = Struct.new(:v1, :v2, :weight)

  attr_reader :mapping

  def initialize
    @mapping = {}
  end

  def add_edge(u,v,weight)
    mapping[u] ||= []
    mapping[v] ||= []

    mapping[u] << {vertex: v, weight: weight}
    mapping[v] << {vertex: u, weight: weight}
  end

  def related_vertices(vertex)
    mapping[vertex]
  end

  def vertices
    mapping.keys
  end
end

class MinHeap
  attr_reader :arr, :mapping

  def initialize
    @arr = []
    @mapping = {}
  end

  def empty?
    arr.length == 0
  end

  # O(1)
  def root
    if empty?
      raise 'Heap is empty!'
    end
    arr.first
  end

  # O(log n)
  def insert(pair)
    # {vertex: , weight: }
    i = arr.length
    arr[i] = pair
    parent_i = parent(i)
    mapping[pair[:vertex]] = i

    while i != 0 && arr[parent_i][:weight] > arr[i][:weight]
      arr[i], arr[parent_i] = arr[parent_i], arr[i]

      mapping[arr[i][:vertex]] = i
      mapping[arr[parent_i][:vertex]] = parent_i
      i = parent_i
      parent_i = parent(i)
    end
  end

  # O(1)
  def vertex_exists?(vertex)
    mapping.key?(vertex)
  end

  def weight_for(vertex)
    indx = mapping[vertex]
    return arr[indx][:weight]
  end

  # O(log n)
  def decrement(vertex, weight)
    i = mapping[vertex]
    arr[i][:weight] = weight

    parent_i = parent(i)

    while i != 0 && arr[i][:weight] < arr[parent_i][:weight]
      arr[i], arr[parent_i] = arr[parent_i], arr[i]

      mapping[arr[i][:vertex]] = i
      mapping[arr[parent_i][:vertex]] = parent_i

      i = parent_i
      parent_i = parent(i)
    end
  end

  # O(log n)
  def extract
    if empty?
      raise 'Empty heap!'
    end

    last = arr.length - 1
    arr[last], arr[0] = arr[0], arr[last]

    popped = arr.pop

    mapping.delete(popped[:vertex])

    if size > 0
      mapping[arr[0][:vertex]] = 0
      heapify(0)
    end
    return popped
  end

  def parent(i)
    (i - 1) / 2
  end

  def left(i)
    (i * 2) + 1
  end

  def right(i)
    (i * 2) + 2
  end

  def heapify(i)
    smaller = i
    left_child = left(i)
    right_child = right(i)

    if left_child < size && arr[left_child][:weight] < arr[smaller][:weight]
      smaller = left_child
    end

    if right_child < size && arr[right_child][:weight] < arr[smaller][:weight]
      smaller = right_child
    end

    if i != smaller
      arr[smaller], arr[i] = arr[i], arr[smaller]
      mapping[arr[smaller][:vertex]] = smaller
      mapping[arr[i][:vertex]] = i
      heapify(smaller)
    end
  end

  def size
    @arr.length
  end
end

class MinSpanningTree

  MAX = Float::INFINITY
  attr_reader :graph, :heap, :parents

  def initialize(graph)
    @parents = {}
    @graph = graph
    @heap = MinHeap.new
  end

  def run(start)
    # add all vertices to head
    add_vertices_to_heap(start)

    weight = 0

    while not heap.empty?
      extracted = heap.extract
      # puts "extracted: #{extracted}"
      weight += extracted[:weight]

      graph.related_vertices(extracted[:vertex]).each do |pair|
        # process is present in heap
        # binding.pry
        if heap.vertex_exists?(pair[:vertex]) &&  heap.weight_for(pair[:vertex]) > pair[:weight]
          heap.decrement(pair[:vertex], pair[:weight])
          parents[pair[:vertex]] = extracted[:vertex]
        end
      end
    end

    puts "Weight: #{weight}"
    puts "Edges: "
    parents.each{|k,v| print "#{k}-#{v} \t"}
    puts
    return weight
  end

  def add_vertices_to_heap(start)
    vertices = graph.vertices.clone
    start = vertices.delete(start)
    heap.insert({vertex: start, weight: 0})

    vertices.each do |vertex|
      heap.insert({vertex: vertex, weight: MAX})
    end

  end
end

# test graph & methods
graph = Graph.new
graph.add_edge('a', 'b', 10)
graph.add_edge('a', 'c', 20)
graph.add_edge('b', 'd', 5)
graph.add_edge('b', 'c', 30)
graph.add_edge('d', 'c', 15)
graph.add_edge('d', 'e', 8)
graph.add_edge('e', 'c', 6)


heap = MinHeap.new
heap.insert({vertex: 'a', weight: 100})
heap.insert({vertex: 'b', weight: 10})
heap.insert({vertex: 'c', weight: 200})
heap.insert({vertex: 'd', weight: 120})
heap.insert({vertex: 'e', weight: 5})

mst = MinSpanningTree.new(graph)
mst.run('a')
