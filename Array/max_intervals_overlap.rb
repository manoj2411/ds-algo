def print_max_interval_overlap(entries, exits)
  entries, exits = entries.sort, exits.sort
  count = max_count = i = j = 0
  max_at = nil
  length = entries.length
  while i < length && j < length
    if entries[i] <= exits[j]
      count += 1
      if count > max_count
        max_count = count
        max_at = entries[i]
      end
      i += 1
    else
      count -= 1
      j += 1
    end
  end

  puts "Maximum guests were #{max_count} at #{max_at}"
end

entries = [1,2,10,5,5]
exits = [4,5,12,9,12]

entries = [13,28,29,14,40,17,3 ]
exits = [107,95,111,105,70,127,74 ]
print_max_interval_overlap(entries, exits)
