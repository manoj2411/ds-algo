arr = []

c = 0
10.times do |i|
  # puts "T#{i}"
  arr <<
    Thread.new do
      c += 1
      puts "t#{i} - #{c}"
      sleep 0.1
      c
    end
end

puts arr.each(&:join).map(&:value).to_s
