Given the very sudden resurgence of Pokemon Go this summer, it seems logical to address one of the more common complaints about the game: the battle system (well, and quite a lot more, but let's start somewhere, shall we?).  This is a very basic battle system that could be used in an RPG like Pokemon: you have characters, these characters have different moves with different powers, and the affinities of the characters will affect how much damage they take.  The Pokemon names and abilities can be generalized to work for *any* RPG that follows this kind of damage system. Ordered and unordered linear data structures were used to build this battle system.

Methods implemented:

World.loadMons(String fname)
This method loads all of the characters in the specified file into the list of available characters. File format is:

name1
type1
max_hp
move_name power
move_name power
-
name2
type2
max_hp
move_name power
move_name power
move_name power
-

MoveModifier.loadMoves(String fname)
This method reads the move types from the specified file and stores them in the moveTypes HashMap.

MoveModifier.loadAdvantages(String fname)
This method is similar to the loadMoves method, but has an additional step: there are two HashMaps: strengths and weaknesses. I will make the assumption that if typeA is strong against typeB, then typeB is weak against typeA.

MoveModifier.getModifier(String move, String againstType)
This method determineS the bonus multiplier for damage based on the type. First, it determines the type of the move by looking it up in the moveTypes HashMap. It then determines whether or not the type is strong against againstType by seeing if it is the value for the key in the strenghts HashMap. This method returns 1.0 if the move is not strong or weak against the opposing type, 1.5 if it is strong against it, and 0.5 if it is weak against it.

Pokemon.addMove(String move, int val)
This method puts the move into the moves HashMap; the key is the String and the value is the int.

Trainer.catchPokemon(Pokemon p)
This method adds a copy of the specified pokemon to the available Pokemon (stored in billsPC). Additionally, it attempts to store the pokemon in the pokedex (called dex) if it is not already there. Additionally, the method prints to the screen saying the trainer caught the Pokemon, and if the pokemon has not been caught before, prints that the Pokemon’s data will be added to the Pokedex. The method returns whether the pokemon has been caught before or not. 

Some functionality in Trainer(String name)

Some functionality in TrainerBattle.Battle(Trainer player, Trainer opponent)



Sample Output
: Note: The player is Ash

Winning:

run:
Ash caught Charmander
Charmander's information will be stored in the pokedex
Gary caught Bulbasaur
Bulbasaur's information will be stored in the pokedex
Who would you like to send out?
0: Charmander: 40/40
0
****
[Ash] Charmander: 40/40
[Gary] Bulbasaur: 30/30
Which move would you like to use?
0: ember
1: scratch
0
Charmander used ember
It's super effective!
Bulbasaur used razor_leaf
It's not very effective.
****
[Ash] Charmander: 37/40
[Gary] Bulbasaur: 22/30
Which move would you like to use?
0: ember
1: scratch
1
Charmander used scratch
Bulbasaur used vine_whip
It's not very effective.
****
[Ash] Charmander: 35/40
[Gary] Bulbasaur: 20/30
Which move would you like to use?
0: ember
1: scratch
0
Charmander used ember
It's super effective!
Bulbasaur used razor_leaf
It's not very effective.
****
[Ash] Charmander: 32/40
[Gary] Bulbasaur: 12/30
Which move would you like to use?
0: ember
1: scratch
0
Charmander used ember
It's super effective!
Bulbasaur used razor_leaf
It's not very effective.
****
[Ash] Charmander: 29/40
[Gary] Bulbasaur: 4/30
Which move would you like to use?
0: ember
1: scratch
0
Charmander used ember
It's super effective!
Bulbasaur fainted
Ash wins!
BUILD SUCCESSFUL (total time: 23 seconds)
Losing:

run:
Ash caught Squirtle
Squirtle's information will be stored in the pokedex
Gary caught Bulbasaur
Bulbasaur's information will be stored in the pokedex
Who would you like to send out?
0: Squirtle: 35/35
0
****
[Ash] Squirtle: 35/35
[Gary] Bulbasaur: 30/30
Which move would you like to use?
0: tackle
1: water_gun
2: bubble
2
Squirtle used bubble
It's not very effective.
Bulbasaur used vine_whip
It's super effective!
****
[Ash] Squirtle: 29/35
[Gary] Bulbasaur: 29/30
Which move would you like to use?
0: tackle
1: water_gun
2: bubble
1
Squirtle used water_gun
It's not very effective.
Bulbasaur used tackle
****
[Ash] Squirtle: 27/35
[Gary] Bulbasaur: 26/30
Which move would you like to use?
0: tackle
1: water_gun
2: bubble
0
Squirtle used tackle
Bulbasaur used razor_leaf
It's super effective!
****
[Ash] Squirtle: 18/35
[Gary] Bulbasaur: 24/30
Which move would you like to use?
0: tackle
1: water_gun
2: bubble
0
Squirtle used tackle
Bulbasaur used tackle
****
[Ash] Squirtle: 16/35
[Gary] Bulbasaur: 22/30
Which move would you like to use?
0: tackle
1: water_gun
2: bubble
0
Squirtle used tackle
Bulbasaur used tackle
****
[Ash] Squirtle: 14/35
[Gary] Bulbasaur: 20/30
Which move would you like to use?
0: tackle
1: water_gun
2: bubble

0
Squirtle used tackle
Bulbasaur used tackle
****
[Ash] Squirtle: 12/35
[Gary] Bulbasaur: 18/30
Which move would you like to use?
0: tackle
1: water_gun
2: bubble
0
Squirtle used tackle
Bulbasaur used razor_leaf
It's super effective!
****
[Ash] Squirtle: 3/35
[Gary] Bulbasaur: 16/30
Which move would you like to use?
0: tackle
1: water_gun
2: bubble
0
Squirtle used tackle
Bulbasaur used razor_leaf
It's super effective!
Squirtle fainted
Gary wins!
BUILD SUCCESSFUL (total time: 23 seconds)