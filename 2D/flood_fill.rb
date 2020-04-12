class Screen
  attr_accessor :matrix

  def _print
    matrix.each do |rows|
      rows.each.each do |col|
        print "#{col} "
      end
      puts
    end
  end

  def rows
    matrix.length
  end

  def cols
    matrix.first.length
  end


  def flood_fill(x,y,color)
    fill(x,y,color, matrix[x][y])
  end

  private
    def fill(x, y, color, curr_color)
      if x >= rows || y >= cols || x < 0 || y < 0
        return
      end
      if matrix[x][y] == curr_color
        matrix[x][y] = color
        fill(x + 1,y,color, curr_color)
        fill(x - 1,y,color, curr_color)
        fill(x,y + 1,color, curr_color)
        fill(x,y - 1,color, curr_color)
      end
    end
end


screen = Screen.new
screen.matrix = [
  [1, 1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 0, 0],
  [1, 0, 0, 1, 1, 0, 1, 1],
  [1, 2, 2, 2, 2, 0, 1, 0],
  [1, 1, 1, 2, 2, 0, 1, 0],
  [1, 1, 1, 2, 2, 2, 2, 0],
  [1, 1, 1, 1, 1, 2, 1, 1],
  [1, 1, 1, 1, 1, 2, 2, 1],
]

screen._print()
screen.flood_fill(4,0,5)
puts
screen._print()
# puts screen.rows
# puts screen.cols
puts

=begin
        Alternate implementation, iterative
=end

# Flood fill
def flood_fill(m, x, y, k)
    return if m.empty?
    rows = m.length
    cols = m.first.length
    color = m[x][y]

    visited = Array.new(rows) { Array.new(cols, false) }
    que = Queue.new

    que.enq([x,y])
    visited[x][y] = true

    while not que.empty?
        i, j = que.deq
        m[i][j] = k

        next_positions = []
        next_positions << [i + 1, j] if i + 1 < rows
        next_positions << [i - 1, j] if i - 1 >= 0
        next_positions << [i, j - 1] if j - 1 >= 0
        next_positions << [i, j + 1] if j + 1 < cols

        next_positions.each do |ni, nj|
            if m[ni][nj] == color && !visited[ni][nj]
                que.enq([ni, nj])
                visited[ni][nj] = true
            end
        end
    end
end


m = [
    [1, 1, 1, 1, 1, 1, 1, 1],
    [1, 1, 1, 1, 1, 1, 0, 0],
    [1, 0, 0, 1, 1, 0, 1, 1],
    [1, 2, 2, 2, 2, 0, 1, 0],
    [1, 1, 1, 2, 2, 0, 1, 0],
    [1, 1, 1, 2, 2, 2, 2, 0],
    [1, 1, 1, 1, 1, 2, 1, 1],
    [1, 1, 1, 1, 1, 2, 2, 1],
]
x, y, k = 4, 4, 3
# puts m.map(&:to_s)
# puts "flood filling ... #{x}, #{y} with #{k}"
# flood_fill(m, x, y, k)
# puts m.map(&:to_s)


m = [
    [0,1,1],
    [0,1,1],
    [1,1,0],
    [1,2,3],
]
x, y, k = 0,1,5
# puts m.map(&:to_s)
# puts "flood filling ... #{x}, #{y} with #{k}"
# flood_fill(m, x, y, k)
# puts m.map(&:to_s)


m = [
    [1,1],
    [1,1],
]
x, y, k = 0,1,8
# puts m.map(&:to_s)
# puts "flood filling ... #{x}, #{y} with #{k}"
# flood_fill(m, x, y, k)
# puts m.map(&:to_s)


m = [
    [1,2,3,4],
    [1,2,3,4],
    [1,2,3,4],
    [1,3,2,4]
]
x, y, k = 0,2,9
puts m.map(&:to_s)
puts "flood filling ... #{x}, #{y} with #{k}"
flood_fill(m, x, y, k)
puts m.map(&:to_s)
