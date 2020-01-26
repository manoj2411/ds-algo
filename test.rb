=begin


=end





# def orderedJunctionBoxes(numberOfBoxes, boxList)
#     # WRITE YOUR CODE HERE
#     old_boxes = []
#     new_boxes = []
#     boxList.each do |box|
#         splitted = box.split(' ')
#         id = splitted.first
#         version = splitted[1..-1]
#         is_int = Integer(version.join) rescue nil
#         if is_int
#             new_boxes << box
#         else
#             old_boxes << [id, version.join(' ')]
#         end
#     end

#     # puts "old: #{old_boxes}"
#     # puts "new_boxes: #{new_boxes}"

#     result = old_boxes
#         .sort {|a, b| [a[1], a[0]] <=> [b[1],b[0]]}
#         .map {|splitted| splitted.join(' ')}
#     result + new_boxes
# end










#!/usr/bin/ruby
# require 'socket'

# server = TCPServer.open(2017)
# loop {
#     client = server.accept
#     client.puts "Hello. This is socket programming"
#     client.close
# }


# require 'byebug'
# require 'date'

# def solution(s)
#   # write your code in Ruby 2.2
#   cities = {}

#   rows = s.split("\n").map { |row|
#     name, city, time = row.split(", ")
#     cities[city] = [] if cities[city].nil?
#     cities[city] << [name, city, DateTime.parse(time)]
#     [name, city, DateTime.parse(time)]
#   }

#   cities.each_pair do |city, data|
#     cities[city] = data.sort_by {|row| row[2] }
#   end

#   rows.map do |row|
#     city = row[1]
#     data = cities[city]
#     pos = data.index(row)
#     extension = row[0].split(".")[1]
#     "#{city}#{(pos + 1).to_s.rjust(data.length.to_s.length, "0")}.#{extension}"
#   end

# end



# input = "photo.jpg, Warsaw, 2013-09-05 14:08:15\njohn.png, London, 2015-06-20 15:13:22\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\nEiffel.jpg, Paris, 2015-07-23 08:03:02\npisatower.jpg, Paris, 2015-07-22 23:59:59\nBOB.jpg, London, 2015-08-05 00:02:03\nnotredame.png, Paris, 2015-09-01 12:00:00\nme.jpg, Warsaw, 2013-09-06 15:40:22\na.png, Warsaw, 2016-02-13 13:33:50\nb.jpg, Warsaw, 2016-01-02 15:12:22\nc.jpg, Warsaw, 2016-01-02 14:34:30\nd.jpg, Warsaw, 2016-01-02 15:15:01\ne.png, Warsaw, 2016-01-02 09:49:09\nf.png, Warsaw, 2016-01-02 10:55:32\ng.jpg, Warsaw, 2016-02-29 22:13:11"

# puts solution(input).to_s





# M cities task
#
# def solution(t)
#   # write your code in Ruby 2.2
#   length = t.length

#   # Building graph from data
#   adjacency = {}
#   capital = -1
#   t.each_with_index do |element, _index|
#     adjacency[element] = [] unless adjacency[element]
#     adjacency[_index] = [] unless adjacency[_index]

#     if element == _index
#       capital = element
#       next
#     end

#     adjacency[element] << _index
#     adjacency[_index] <<  element
#   end

#   # start from capital,
#   # find next not visited elements and push them to array
#   # pop them 1 by 1, take

#   visited = Array.new(length, false)
#   que = [capital]
#   visited[capital] = true
#   result = Array.new(length - 1)


#   for dist in 1..(length - 1)
#     next_que = []
#     while !que.empty?
#       city = que.shift
#       visited[city] = true

#       adjacency[city].each do |next_city|
#         next if visited[next_city]
#         next_que << next_city
#       end
#     end
#     result[dist - 1] = next_que.length
#     que = next_que
#   end

#   result
# end

# puts solution([1,1,0]).to_s








# def removeObstacle(numRows, numColumns, lot)
#     # WRITE YOUR CODE HERE
#     helper(numRows, numColumns, lot, 0, 0, 0) || -1
# end

# def valid?(row, col, numRows, numColumns, lot)
#   row >= 0 && row < numRows &&
#   col >= 0 && col < numColumns &&
#   lot[row][col] > 0
# end


# def helper(numRows, numColumns, lot, row, col, distance)

#   return distance if lot[row][col] == 9

#   lot[row][col] = -1 # mark visited

#   res = []

#   # right
#   if valid?(row, col + 1, numRows, numColumns, lot)
#      res << helper(numRows, numColumns, lot, row, col + 1, distance + 1)
#      puts "right: #{res.last}"
#   end

#   # down
#   if valid?(row + 1, col, numRows, numColumns, lot)
#     res << helper(numRows, numColumns, lot, row + 1, col, distance + 1)
#     puts "down: #{res.last}"
#   end

#   # left
#   if valid?(row, col - 1, numRows, numColumns, lot)
#     res << helper(numRows, numColumns, lot, row, col - 1, distance + 1)
#     puts "left: #{res.last}"
#   end

#    # up
#    if valid?(row - 1, col, numRows, numColumns, lot) &&
#      res << helper(numRows, numColumns, lot, row - 1, col, distance + 1)
#      puts "up: #{res.last}"
#    end

#    res.compact.min
# end



# # matrix = [[1,0,0], [1,0,0], [1,9,1]]
# # matrix = [[1,0,0], [1,0,0], [0,9,1]]

# matrix = [[1, 1,1], [1,0,1], [0,9,1]]
# matrix = [[1,1,1,1], [0,1,1,1], [0,1,0,1],[1,1,9,1],[0,0,1,1]]

# matrix.each { |e| puts e.to_s}

# puts removeObstacle(5,4,matrix)


# Point = Struct.new(:x, :y, :distance)

# def valid?(lot, x, y, numRows, numCols)
#   x >= 0 && x < numRows && y >= 0 && y < numCols && lot[x][y] > 0
# end

# def traverse(lot, numRows, numCols)
#  q = Queue.new
#  q.enq( Point.new(0,0,0) )

#  while(!q.empty?)
#    node = q.deq
#    x, y = node.x, node.y
#    distance = node.distance
#    return distance if lot[x][y] == 9
#    lot[x][y] = -1

#    # up
#    if valid?(lot, x-1, y, numRows, numCols)
#      q.enq( Point.new(x-1, y, distance+1) )
#    end

#    # right
#    if valid?(lot, x, y+1, numRows, numCols)
#      q.enq( Point.new(x, y+1, distance+1) )
#    end

#    # down
#    if valid?(lot, x+1, y, numRows, numCols)
#      q.enq( Point.new(x+1, y, distance+1) )
#    end

#    # left
#    if valid?(lot, x, y-1, numRows, numCols)
#      q.enq( Point.new(x, y-1, distance+1) )
#    end

#  end
#  -1
# end

# numRows = 3
# numCols = 3
# lot = [[1,1,1], [1,0,1], [1,9,1]]
# puts traverse(lot, numRows, numCols)

# # matrix = [[1,0,0], [1,0,0], [1,9,1]]
# # matrix = [[1,0,0], [1,0,0], [0,9,1]]

# matrix = [[1,1,1], [0,0,0], [0,9,1]]
# # matrix = [[1,1,1,1], [0,1,1,1], [0,1,0,1],[1,1,9,1],[0,0,1,1]]

# puts "we"
# matrix.each { |e| puts e.to_s}

# puts traverse(matrix, 3,3)





# def minimumTime(numOfSubFiles, files)
#     # WRITE YOUR CODE HERE

#     # find 2 mins from array
#     # add them and puts back to arr
#     # calculate result
#     result = 0

#     (numOfSubFiles - 1).downto(1) do |right|
#       first = second = 10**6
#       first_i = second_i = 0

#       for i in 0..right

#         if files[i] < first
#           second = first
#           first = files[i]
#           second_i = first_i
#           first_i = i
#         elsif files[i] < second
#           second = files[i]
#           second_i = i
#         end
#       end

#       result += first + second

#       files[first_i] = first + second
#       files[second_i], files[right] = files[right], files[second_i]
#     end
#     result
# end


# # arr1 = [20,4,8,2]
# # arr1 = [4,8,6,12]

# arr1 = [1,2,5,10,35,89]
# arr1 = []
# puts minimumTime(arr1.length, arr1)


# # 54
# [1,2,5,10,35,89]
# # 224









# def solution(a)
#   travesed_till = 0
#   # bulbs_state = Array.new(a.length, false)

#   result = 0
#   # a.each do |item|
#   for i in 0...(a.length)
#     item = a[i].abs
#     # bulbs_state[item - 1] = true
#     a[item - 1] *= -1
#     # puts "#{i}: #{a.to_s}"

#     if item == travesed_till + 1
#       result += 1
#       # while bulbs_state[travesed_till]
#       while travesed_till <= i && a[travesed_till] < 0
#         travesed_till += 1
#       end
#     end

#   end
#   result
# end


# for arr in [[2,1,3,5,4],[2,3,4,1,5],[1,3,4,2,5]]
#   puts "Input: #{arr.to_s}"
#   puts "Result: #{solution arr}"
# end








#
# Complete the 'funWithAnagrams' function below.
#
# The function is expected to return a STRING_ARRAY.
# The function accepts STRING_ARRAY s as parameter.
#

# def funWithAnagrams(s)
# # Write your code here
#   result_hash = {}

#   s.each do |word|
#     sorted = word.chars.sort.join
#     next if result_hash[sorted]
#     result_hash[sorted] = word
#   end
#   result_hash.values
# end




# puts funWithAnagrams(%w{code aaagmnrs anagrams doce}).to_s
# puts funWithAnagrams(%w{poke pkoe okpe ekop}).to_s









  # def binary_search(array, value, from, to)
  #   mid = (from + to) / 2

  #   if value < array[mid]
  #       return binary_search array, value, from, mid - 1
  #   elsif value > array[mid]
  #       return binary_search array, value, mid + 1, to
  #   else
  #       return mid
  #   end
  # end


























# test_cases = gets.chomp.to_i

# test_cases.times do
#   people_count = gets.chomp.to_i
#   answers = gets.chomp.split(' ')
#   arr = []
#   i = 0
#   while(i < answers.length)
#     _answers = []
#     (i..(i + answers[i].to_i - 1)).to_a.each do |k|
#       _answers << answers[k].to_i
#     end
#     arr << _answers.uniq.inject(:+)
#     i += answers[i].to_i
#   end
#   if(arr.inject(:+) == people_count)
#     puts arr.count
#   else
#     puts "Invalid Data"
#   end
# end



































# require "byebug"

# class Graph

#   def initialize()
#     @vertices = Hash.new([])
#   end

#   def add(vertex, adjesent_nodes = [])
#     @vertices[vertex] += adjesent_nodes
#   end

#   def find_all_adjecent_nodes(vertex)
#     @vertices.fetch(vertex)
#   end

#   def add_edge(node1, node2)
#     @vertices[node1].push node2
#     @vertices[node2].push node1
#   end
# end

# class Queue
#   attr_reader :list

#   def initialize()
#     @list = []
#   end

#   def enqueue(element)
#     @list.push element
#   end

#   def dequeue
#     @list.delete_at(0)
#   end

#   def empty?
#     list.empty?
#   end
# end


# class Bfs
#   attr_reader :graph, :level

#   def initialize(graph, start, level)
#     @graph = graph
#     @queue = Queue.new
#     @visited = Hash.new
#     @start = start
#     @level = level
#   end

#   def call
#     level_count = 0
#     push_to_visited(start, 1)
#     queue.enqueue(start)

#     until queue.empty?
#       v = queue.dequeue
#       graph.find_all_adjecent_nodes(v).each do |adj_node|
#         if node_not_visited?(adj_node)
#           if visited[v] + 1 == level
#             level_count += 1
#           end
#           push_to_visited(adj_node, visited[v] + 1)
#           queue.enqueue(adj_node)
#         end
#       end
#     end
#     puts(level == 1 ? 1 : level_count)
#   end

#   private
#     attr_reader :queue, :visited, :start

#     def push_to_visited(element, level)
#       visited[element] = level
#     end

#     def node_not_visited?(element)
#       not visited.key?(element)
#     end
# end

# graph = Graph.new

# vertices_count = gets.chomp.to_i

# 1.upto(vertices_count) do |v|
#   graph.add(v)
# end

# (vertices_count - 1).times do |i|
#   puts "Iteration: #{i}"
#   node1, node2 = gets.chomp.split(' ').map(&:to_i)
#   graph.add_edge(node1, node2)
# end

# level = gets.chomp.to_i

# Bfs.new(graph, 1, level).call


































# class Graph

#   def initialize()
#     @vertices = Hash.new([])
#   end

#   def add(vertex, adjesent_nodes = [])
#     @vertices[vertex] += adjesent_nodes
#   end

#   def find_all_adjecent_nodes(vertex)
#     @vertices.fetch(vertex)
#   end

#   def add_edge(node1, node2)
#     @vertices[node1].push node2
#     @vertices[node2].push node1
#   end
# end

# class Queue
#   attr_reader :list

#   def initialize()
#     @list = []
#   end

#   def enqueue(element)
#     @list.push element
#   end

#   def dequeue
#     @list.delete_at(0)
#   end

#   def empty?
#     list.empty?
#   end
# end


# class Bfs
#   attr_reader :graph, :level

#   def initialize(graph, start, level)
#     @graph = graph
#     @queue = Queue.new
#     @visited = Hash.new
#     @start = start
#     @level = level
#   end

#   def call
#     level_count = 0
#     push_to_visited(start, 1)
#     queue.enqueue(start)

#     until queue.empty?
#       v = queue.dequeue
#       graph.find_all_adjecent_nodes(v).each do |adj_node|
#         if node_not_visited?(adj_node)
#           if visited[v] + 1 == level
#             level_count += 1
#           end
#           push_to_visited(adj_node, visited[v] + 1)
#           queue.enqueue(adj_node)
#         end
#       end
#     end
#     puts level == 1 ? 1 : level_count
#   end

#   private
#     attr_reader :queue, :visited, :start

#     def push_to_visited(element, level)
#       visited[element] = level
#     end

#     def node_not_visited?(element)
#       not visited.key?(element)
#     end
# end





# graph = Graph.new
# # graph.add(0, [1,2])
# # graph.add(1, [0,3])
# # graph.add(2, [0,3,4])
# # graph.add(3, [1,2,5])
# # graph.add(4, [2])
# # graph.add(5, [3])
# # bfs = Bfs.new(graph, 0, 2)
# # bfs.call
# # bfs
# # debugger
# # true
# vertices_count  gets.chomp.to_i

# 1.upto(vertices_count) do |v|
#   graph.add(v)
# end

# vertices_count.times do
#   node1, node2 = gets.chomp.split(' ').map(&:to_i)
#   graph.add_edge(node1, node2)
# end

# level = gets.chomp.to_i
# Bfs.new(graph, 0, level).call

