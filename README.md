# A_brick_game_rewritten_from_the_tank_game
1.Design description:  
	I spent a lot of time doing this homework. This was a big challenge for me, because I have to read all the class file of the “Tank War” and make new game.  
	Frist step, I had to find the code that controls the user interface of this game. I found the class file named “WarField”. Then, I modified the codes in the constructor such as new object, the number of the Tanks(Bricks), etc.  
	Second step, I opened the class file named “Missiles”. I modified some initial values in the constructor. For example, I modified the initial position, the value of deltaX and deltaY.  
	Third step, we must remove or close some member functions or some codes in the member functions. For example, we have to close the function “moveAndFire” in the class “EnemyTank”, because we use “EnemyTank” as the “Brick”, bricks have no legs after all. We also have to close “fire” function, a brick or a board can’t fire.  
	Finally, I set the range of the ground, I used some if-else clause to form the range of the ground. If you don’t set it, your ball(Missiles) will go beyond the interface, and your board(OurTank) can also go beyond the interface.  
	Complete all the above steps, you can successfully create a Bricks game.  
2.Conclusion:  
	After completing this project, I feel so tired because of the files are so complicated, and I must read it. I really want to rest after completing it. Maybe I am not a great engineer.  
	The most annoying thing is all the objects in the game keep flushing, they make my eyes hurt. I have no ideas to solve it.  
