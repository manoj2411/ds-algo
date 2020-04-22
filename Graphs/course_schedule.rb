# Course Schedule
#
# @param {Integer} num_courses
# @param {Integer[][]} prerequisites
# @return {Boolean}
def can_finish(num_courses, prerequisites)
    mapping = Hash.new
    prerequisites.each do |k, l|
        mapping[k] = [] unless mapping.key?(k)
        mapping[k] << l
    end

    while not mapping.empty?
        i = mapping.first[0]
        return false if has_cycle?(i, mapping, {})
    end

    true
end

def has_cycle?(i, mapping, in_stack)
    return true if in_stack[i]

    in_stack[i] = true

    mapping[i].each do |v|
        if mapping.key?(v) && has_cycle?(v, mapping, in_stack)
            return true
        end
    end

    in_stack.delete(i)
    mapping.delete(i)
    false
end


for n, prerequisites in [
    [2, [[1,0]]], # true
    [2, [[1,0], [0,1]]], # false
    [12, [[1,0], [0,6],[1,2],[2,3],[3,0]]], # true
]
    puts can_finish(n, prerequisites)
end
