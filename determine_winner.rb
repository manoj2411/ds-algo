def find_winner(initial_scores, decr_factors, flash_subs, cisco_subs)
  flash_score = 0
  cisco_score = 0
  flash_time = 0
  cisco_time = 0

  for i in 0..3
    flash_curr_score = initial_scores[i] - (decr_factors[i] * flash_subs[i])
    # flash_score += flash_curr_score > 0 ? flash_curr_score : 0
    flash_score += flash_curr_score

    cisco_curr_score = initial_scores[i] - (decr_factors[i] * cisco_subs[i])
    # cisco_score += cisco_curr_score > 0 ? cisco_curr_score : 0
    cisco_score += cisco_curr_score

    flash_time = flash_subs[i] if flash_time < flash_subs[i]
    cisco_time = cisco_subs[i] if cisco_time < cisco_subs[i]
  end
  #
  if flash_score == cisco_score
    if flash_time == cisco_time
      return 'Tie'
    else
      return flash_time < cisco_time ? 'Flash' : 'Cisco'
    end
  else
    return flash_score > cisco_score ? 'Flash' : 'Cisco'
  end
end


test_cases = gets.chomp.to_i

test_cases.times do
  initial_scores = gets.chomp.split(' ').map(&:to_i)
  decr_factors = gets.chomp.split(' ').map(&:to_i)
  flash_subs = gets.chomp.split(' ').map(&:to_i)
  cisco_subs = gets.chomp.split(' ').map(&:to_i)

  puts find_winner(initial_scores, decr_factors, flash_subs, cisco_subs)
end






