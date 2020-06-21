def get_folder_names(names)
    curr_system = {}

    names.map do |name|
        if curr_system[name] == nil
            curr_system[name] = 0
            name
        else
            count = curr_system[name] + 1
            while curr_system["#{name}(#{count})"]
                count += 1
            end

            final_name = "#{name}(#{count})"

            curr_system[name] = count
            curr_system[final_name] = 0
            final_name
        end
    end
end

puts get_folder_names(["pes","fifa","gta","pes(2019)"]).to_s
# => Output: ["pes","fifa","gta","pes(2019)"]

puts get_folder_names(["gta","gta(1)","gta","avalon"]).to_s
# => ["gta","gta(1)","gta(2)","avalon"]

puts get_folder_names(["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"]).to_s
# => ["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece(4)"]

puts get_folder_names(["wano","wano","wano","wano"]).to_s
# => ["wano","wano(1)","wano(2)","wano(3)"]

puts get_folder_names(["kaido","kaido(1)","kaido","kaido(1)"]).to_s
# => ["kaido","kaido(1)","kaido(2)","kaido(1)(1)"]

