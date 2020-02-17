# Backspace String Compare : Given two strings S and T, return if they are equal when
#  both are typed into empty text editors. # means a backspace character.

def backspace_compare(s, t)
    process_s = process_backspace s
    process_t = process_backspace t
    process_t == process_s
end

def process_backspace(str)
  processed_str = []
  str.each_char do |chr|
    if chr == '#'
      processed_str.pop unless processed_str.empty?
    else
      processed_str.push chr
    end
  end
  processed_str
end


for s, t in [
  ["ab#c", "ad#c"], # true
  [ "ab##", "c#d#"], # true
  ["a##c", "#a#c"], # true
  ["a#c", "b"], # false
  ['y#fo##f', 'y#f#o##f'], # false
]

  puts "Input: #{s} & #{t}"
  puts "Res: #{backspace_compare s, t}"
  puts
end
