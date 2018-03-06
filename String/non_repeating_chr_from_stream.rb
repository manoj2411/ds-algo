def print_first_non_repeating_chr_from_stream(str)
    #stores uniq characters as they come in stram
    que = []

    # hash for above que values to have a constant time lookup to check if a char
    # exists in the que or not
    que_map = {}

    # hash to store the repeating chars
    repeating_chars = {}

    str.each_char do |chr|
        # if the chr is present in que_map means it has occurred previously and its
        # becomes repeating now, so delete it from que_map and que and add it to repeating hash
        if que_map[chr] != nil
            #
            que.delete(chr)
            que_map.delete(chr)
            repeating_chars[chr] = true
        elsif repeating_chars[chr] == nil
            que << chr
            que_map[chr] = true
        end

        print "#{que.first ? que.first : -1 } "

    end
end

['aabc', 'aac', 'geeksforgeeksandgeeksquizfor'].each do |str|
    puts "Str: #{str}"
    print "Stream processing: "
    print_first_non_repeating_chr_from_stream(str)
    puts
end
