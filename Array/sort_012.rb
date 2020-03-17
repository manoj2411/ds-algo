def sort(arr)

 mid = start = 0
 _end = arr.length - 1

 while mid <= _end
   case arr[mid]
   when 1 then
     mid += 1
   when 0 then
     arr[start], arr[mid] = arr[mid], arr[start]
     start += 1
     mid += 1
   when 2 then
     arr[_end], arr[mid] = arr[mid], arr[_end]
     _end -= 1
   end
 end
 arr
end


arr = [2,2,0,1,1,0,1,1,0,1,2,1,0]
res = sort(arr)

puts res.to_s


