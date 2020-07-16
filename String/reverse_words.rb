# Reverse word by word
#   reversed string should not contain leading or trailing spaces
#   reduce multiple spaces between two words to a single space in the reversed string

# @param {String} s
# @return {String}
def reverse_words(s)
    words = []
    word = ""
    s.each_char do |char|
        if char == ' '
            words << word unless word.empty?
            word = ''
        else
            word += char
        end
    end
    words << word unless word.empty?

    return '' if words.empty?

    result = words.pop
    while not words.empty?
        result += " " + words.pop
    end
    result
end

[
  'I love tea',
  'getting good at coding needs a lot of practice',
  "    ",
  "  a  ",
  "  hello world!  ",
].each do |line|

  puts "String: \"#{line}\""
  puts "=> \"#{reverse_words(line)}\""
  puts
end

