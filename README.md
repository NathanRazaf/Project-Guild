# Project-Guild

This Java project represents a guild management ran through the command line:
  1st argument is to input the initial amount of gold and armours in the guild in this order
    (for example: if we run "guild:100,10" then the guild will initially have 100 gold an 10 armours)
    
  Then the other arguments run different methods, depending on which command name is inputted:
    for case "buy-hero", the program will take 5 arguments: the name of the hero we will buy,
    his category (common=0,uncommon=1,rare=2,epic=3,legendary=4), his cost in money,
    his cost in armour and his health points, in this exact order.
    (if we run "buy-hero:Nathan,3,100,10,500", we'll get an Epic hero named Nathan which has 500
    health points and costs 100 gold and 10 armours. Obviously, the amout of gold and armours in our
    guild should be enough to buy this hero, or else an error message will be displayed.)
    
    for case "buy-armor", the program will take 2 arguments: the number of armors we want to buy and
    the cost of one armour, in this order.
    (if we run "buy-armor:10,5", we'll buy 10 armours that cost 5 gold each. And as usual, the money
    in our guild should be enough to buy them, or else an error message will be displayed.)
    
    for case "do-quest", the program will take 4 arguments: the category of the quest
    (common=0 and so on, like in "buy-hero"), his cost in health points, the reward in money
    and the reward in armours. When we run it, the program will take a hero in our guild inventory which has
    the same category as the quest and send him to do it. 
    If we don't have a hero in the same category, the program will try to send a hero from a higher category.
    If we still don't have a hero in a higher category, the program will send a hero from a lower category, but the least low possible.
    In either case, the cost of the quest in health points will change based on the category variation. 
    Thus, healthPointsCost = healthPointsCost - (heroCategory - questCategory) * 1.5.
    
    finally, for case "train-hero", the program will just take 1 argument: the name of the hero we want to upgrade.
    When we want to train a hero, the program will first look in our inventory if this hero exists. If not, an error message 
    will appear.
    Then if it finds one, it will see if the hero is already Legendary. If he is, the program can't upgrade it and it will display
    that the hero is already at max level.
    Finally, if the upgrade is possible, the program will check if we have enough gold and armour to upgrade the hero.
    The upgrade cost in gold is equal to 20 * ln(heroActualCategory+10).
    The upgrade cost in armour is equal to the math ceiling of ln(heroActualCategory+10).
    If we don't have enough of either, the program will display an error message.
    
The outputs will be:
- The amount of gold and armours left in the guild bank
- The heroes that we have in the guild, with their level and their current HP
- The error messages that we got along the way

Thanks for reading and enjoy the code!
    
    
