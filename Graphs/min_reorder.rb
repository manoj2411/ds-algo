# @param {Integer} n
# @param {Integer[][]} connections
# @return {Integer}
def min_reorder(n, connections)
    adjacency = {}
    paths = {}
    connections.each do |v1, v2|
        adjacency[v1] = [] unless adjacency.key?(v1)
        adjacency[v2] = [] unless adjacency.key?(v2)
        adjacency[v1] << v2
        adjacency[v2] << v1
        paths[[v1,v2]] = true
    end

    visited = {}
    que = Queue.new
    que.enq(0)
    no_of_changes = 0
    while not que.empty?
      curr = que.deq

      adjacency[curr].each do |v|
        if visited[v]
          next
        elsif paths[[curr, v]]
          no_of_changes += 1
        end
        que.enq(v)
      end

      visited[curr] = true
    end

    no_of_changes
end


for connections in [
  [[0,1],[1,3],[2,3],[4,0],[4,5]], # 3
  [[1,0],[1,2],[3,2],[3,4]], # 2
  [[1,0],[2,0]], # 0
]
  puts min_reorder(0, connections)
end
