def h_index(citations)
  return 0 if citations.empty?
  len = citations.length
  l = 0
  r = len - 1

  while l < r
    i = l + ( (r - l) / 2 )
    citations[i] >= (len - i) ? r = i : l = i + 1
  end
  citations[l] == 0 ? 0 : len - l
end


for arr in [
  [0,1,3,5,6],    # 3
  [3,4,5,8,10],   # 4
  [3,3,5,8,25],   # 3
  [1,2,4,6,7],    # 3
  [0,0,0,0],      # 0
  [0,0,0,1,1],    # 1
  [0,1,1,1],      # 1
  [],             # 0
  [0],            # 0
  [1],            # 1
]

  puts h_index(arr)

end









