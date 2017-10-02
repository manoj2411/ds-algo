module Boxes
  def self.minimal_number_of_boxes(products, availableLargeBoxes, availableSmallBoxes)
    large_boxes = 0
    small_boxes = products % 5

    if availableLargeBoxes > 0 and products >= 5
      if availableLargeBoxes >= (products / 5)
        large_boxes = products / 5
      else
        large_boxes = availableLargeBoxes
        small_boxes += ((products / 5) - availableLargeBoxes) * 5
      end
    end
    small_boxes += ((products / 5) - large_boxes) * 5
    if availableSmallBoxes >= small_boxes
      small_boxes + large_boxes
    else
      -1
    end
  end
end

## For testing purposes (do not submit uncommented)
puts Boxes.minimal_number_of_boxes(12, 2, 1)
# This should be 4








































# class NamesCount

#   def initialize
#     @number_of_entries = 0
#     @names_counts = Hash.new(0)
#   end

#   def add_name(name)
#     @names_counts[name] += 1
#     @number_of_entries += 1
#   end

#   def name_proportion(name)
#     return @names_counts[name] / @number_of_entries.to_f
#   end

# end

# ## For testing purposes (do not submit uncommented)
# nc = NamesCount.new
# nc.add_name('James')
# nc.add_name('John')
# nc.add_name('Mary')
# nc.add_name('Mary')

# puts nc.name_proportion('John')
# puts nc.name_proportion('Mary')
