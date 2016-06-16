
class Player
  def play_turn(warrior)
    if warrior.feel.wall?
      warrior.pivot!
    else
      if warrior.feel(:backward).empty? && @direcao == nil
        warrior.walk! :backward
      else
        if warrior.feel(:backward).captive?
          warrior.rescue! :backward
          @direcao = 1
        else
          if warrior.feel.empty?
            @direcao = 2
            if warrior.health == 20 || warrior.health < @health 
              warrior.walk!
            elsif warrior.health < 20 && warrior.health <= @health && @direcao > 0
              warrior.walk! :backward
              @direcao = 0
            elsif warrior.health < 20
              warrior.rest!
            end
          else
            if warrior.feel.captive?
              warrior.rescue!
            else
              warrior.attack!
            end
          end
        end
        @health = warrior.health
      end
    end
  end
end
  