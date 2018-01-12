require 'pry'

def print_anagrams_together(arr)

  groups = []
  lists = Hash.new([])
  count = 0
  arr.each do |str|
    selected = groups
    curr_count = nil
    str.each_char do |chr|
      selected = selected.select do |hsh|
        # length check can be moved up
        (curr_count = hsh[chr]) && lists[curr_count].first.length == str.length
      end
      break if selected.empty?
    end
    if selected.empty?
      lists[count] = [str]
      hs = {}
      str.each_char {|chr| hs[chr] = count}
      groups.push(hs)
      count += 1
    else
      lists[curr_count].push(str)
    end
  end

  puts
  lists.each_pair{|k, v| print "#{v.join(' ')} "}
end

arr = %w{cat dog tac god act}
print_anagrams_together(arr)
