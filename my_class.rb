class Thing
  @@ccc = 'a'

  def initialize
    @abc = 'abcdsdfsdf'
  end

  def create_mmm
    self.class.class_eval do
      define_singleton_method :mmm do
        'mmm'
      end
    end
  end

  def abc
    puts @abc
  end

end

# Thing.new.create_mmm
(t1 = Thing.new).create_mmm
puts Thing.mmm
# t1.class.class_exec { puts @@ccc }
# puts t1.mmm
# a = %q{}
# Thing.instance_exec do
#   def self.hello
#     "Hello there!  "
#   end
# end

# puts Thing.instance_exec { 'ccc = ' + (@@ccc = '1234') }

# puts Thing.hello()
# Thing.module_eval("invalid code", "dummy", 123)




















# module Abcd

#   def create_method
#     puts self.name
#   end
# end

# class MyClass
#   # extend Abcd
#   # create_method


#   class_eval do
#     # [:abcd].each do |method_name|
#       define_method 'method_name12' do
#         method_name.to_s
#       end
#     # end
#   end

# end



# puts '@@@@@ instance level: ' + MyClass.new.method_name12
# puts
# puts '@@@@@ class level: ' + MyClass.method_name12
# #
