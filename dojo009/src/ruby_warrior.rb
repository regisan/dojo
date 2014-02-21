class Player
  def play_turn(warrior)
    
    if @todasvidas == true
      if (warrior.health == 20)
        @todasvidas = false
      else
        warrior.rest!
      end
    elsif warrior.feel.wall?
      warrior.pivot! 
    else
#      if warrior.look[0].enemy? || warrior.look[1].enemy? || warrior.look[2].enemy?
      if warrior.feel.enemy?
        warrior.attack!
      elsif warrior.look[2].enemy?
        warrior.shoot!
      elsif warrior.feel.captive?
        warrior.rescue!
      elsif warrior.feel(:backward).captive?
        warrior.rescue! :backward
      elsif @health != nil && @health > warrior.health
        if warrior.health < 10
          warrior.walk!  :backward
          @todasvidas = true
        else
          warrior.walk!
        end
      elsif warrior.health < 20
        warrior.rest!
      elsif warrior.feel(:backward).wall?
        @frente = true
        warrior.walk!
      elsif @frente == false
        warrior.walk! :backward 
      else
        warrior.walk!
      end
    end
    
    @health = warrior.health
  end
end
