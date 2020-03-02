def group_anagrams(strs)
  hask_map = {}

  for str in strs
    sorted_str = str.split('').sort.join
    hask_map[sorted_str] = [] if hask_map[sorted_str].nil?
    hask_map[sorted_str] << str
  end
  hask_map.values
end

for input in  [["eat", "tea", "tan", "ate", "nat", "bat"]]
  group_anagrams(input).each{|l| puts l.to_s}
end
# Output:
# [
#   ["ate","eat","tea"],
#   ["nat","tan"],
#   ["bat"]
# ]
