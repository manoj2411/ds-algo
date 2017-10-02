module ModuleWithPersonalisedMethods
  def self.included(klass)
    @methods_definer.call(klass)
  end

  @methods_definer = lambda do |klass|
                       klass_name = klass.name.downcase

                       klass.class_exec do
                         define_method "#{klass_name}_m1" do |arg1 = nil|
                           arg1 || "#{klass}_m1"
                         end

                         define_method "#{klass_name}_m2" do |arg1 = nil|
                           arg1 || "#{klass}_m2"
                         end

                         define_method "#{klass_name}_m3" do |arg1 = nil|
                           arg1 || "#{klass}_m3"
                         end
                       end
                    end
end





class A
  include ModuleWithPersonalisedMethods
end

class B
  include ModuleWithPersonalisedMethods
end

p A.new.methods.select{|e| e.to_s.start_with? "a_"}
# => [:a_m1, :a_m2, :a_m3]
p B.new.methods.select{|e| e.to_s.start_with? "b_"}
# => [:b_m1, :b_m2, :b_m3]
