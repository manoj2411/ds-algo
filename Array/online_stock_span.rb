# Online Stock Span
class StockSpanner
    def initialize
      @items = []
      @spans = []
    end

    def next(price)
      @items << price
      @spans << find_span
      @spans.last
    end

    private

      def find_span
        span = 1
        curr = @items.count - 1
        i = curr - 1

        while i >= 0 && @items[i] <= @items[curr]
          span += @spans[i]
          i -= @spans[i]
        end
        span
      end
end


ss = StockSpanner.new
puts ss.next(100) #      1,
puts ss.next(80) #      1,
puts ss.next(60) #      1,
puts ss.next(70) #      2,
puts ss.next(60) #      1,
puts ss.next(75) #      4,
puts ss.next(85) #      6
