arr = [
        [1,2,3,4,4,10],
        [6,7,8,9,1,20],
        [3,4,5,6,7,30],
        [1,2,3,4,5,40],
        [9,9,1,1,2,50],
        [0,7,2,4,2,60],
      ]
row_min = col_min = 0
row_max = col_max = arr.size - 1




while row_min < row_max
  puts ' '
  puts ' '
  puts ' '
  (col_min..(col_max - 1)).each do |i|
    print arr[row_min][i].to_s + '  '
  end

  puts ' '
  (row_min..(row_max - 1)).each do |i|
    print arr[i][col_max].to_s + '  '
  end

  puts ' '

  col_max.downto(col_min + 1) do |i|
    print arr[row_max][i].to_s + '  '
  end

  puts ' '
  row_max.downto(row_min + 1) do |i|
    print arr[i][col_min].to_s + '  '
  end
  # break

  row_min += 1
  row_max -= 1
  col_max -= 1
  col_min += 1
end
