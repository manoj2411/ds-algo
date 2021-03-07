# @param {String[]} words
# @return {Integer}
def minimum_length_encoding(words)

    words.sort_by! { |s| -s.length }
    # puts words.to_s
    ref_str = ""

    words.each do |word|

        encoded_word = word + '#'

        if ref_str.index(encoded_word) == nil
            ref_str << encoded_word
        end

    end

    ref_str.length
end


puts minimum_length_encoding ["time", "me", "bell"]                 # 10
puts minimum_length_encoding ["time", "me", "bell", "yotime"]       # 12
puts minimum_length_encoding ["time", "me", "bell", "yotime", "yo"] # 15
