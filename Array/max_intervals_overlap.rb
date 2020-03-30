def max_interval_overlap(entries, exits)
  length = entries.length
  entries, exits = entries.sort, exits.sort
  count = max_count = i = j = 0
  max_at = nil

  while i < length
    if exits[j] < entries[i]
      count -= 1
      j += 1
    else
      count += 1
      if count > max_count
        max_count = count
        max_at = entries[i]
      end
      i += 1
    end
  end

  [max_count, max_at]
end


for entries, exits in [
    [[], []], # 0, 0
    [[2], [5]], # 1, 2
    [[1,2,10,5,5],[4,5,12,9,12]], # 3, 5
    [[13,28,29,14,40,17,3],[107,95,111,105,70,127,74]], # 7, 40
]

    max_count, max_at = max_interval_overlap(entries, exits)
    puts "Maximum guests were #{max_count} at #{max_at}"
end



