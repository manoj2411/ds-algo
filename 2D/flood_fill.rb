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
