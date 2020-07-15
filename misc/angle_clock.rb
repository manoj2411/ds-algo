# Given two numbers, hour and minutes.
# Return the smaller angle (in degrees) formed between the hour and the minute hand
def angle_clock(hour, minutes)
    hour_angle = ((hour * 30) + (minutes * 0.5)) % 360
    mins_angle = minutes * 6
    result = (hour_angle - mins_angle).abs
    result > 180 ? 360 - result : result
end


for hour, min in [
    [12,30], # 165
    [3,30], # 75
    [3,15], # 7.5
    [4,50], # 155
    [12, 0], # 0
    [1, 57], # 76.5
]
    puts angle_clock(hour, min)
end
