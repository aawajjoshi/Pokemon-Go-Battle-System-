# Project 1: Project 1: Ordered and Unordered Linear Data Structures

## 25 points

Given the very sudden resurgence of Pokemon Go this summer, it seems logical to address one of the more common complaints about the game: the battle system (well, and quite a lot more, but let's start somewhere, shall we?).  This project will have you building a very basic battle system that could be used in an RPG like Pokemon: you have characters, these characters have different moves with different powers, and the affinities of the characters will affect how much damage they take.  That the characters themselves have Pokemon names and abilities is sheerly coincidence, I assure you (you could generalize the names and have this work for *any* RPG that follows this kind of damage system).  You will be using both ordered and unordered linear data structures to solve this problem.  This assignment will walk you through building this simplified gaming framework.

For all data structures in this project, you are to use those provided by the JCF; specifically:
* `java.util.HashSet`
* `java.util.HashMap`
* `java.util.ArrayList`
* `java.util.LinkedList`
* etc

You might not use all of these in your solution.

Required Methods
================

You are required to implement the following methods:

-   `World.loadMons(String fname)`

-   `MoveModifier.loadMoves(String fname)`

-   `MoveModifier.loadAdvantages(String fname)`

-   `MoveModifier.getModifier(String move, String againstType)`

-   `Pokemon.addMove(String move, int val)`

-   `Trainer.catchPokemon(Pokemon p)`

-   Some functionality in `Trainer(String name)`

-   Some functionality in
    `TrainerBattle.Battle(Trainer player, Trainer opponent)`

As you do not have all of the required knowledge to complete all of
these, this project will break it down in an order that will allow you
to complete portions that correspond to the covered material thus far.

World.loadMons(String fname)
----------------------------

This method should load all of the characters in the specified file into
the list of available characters. A sample file is provided (in
`pokemon.txt`), but the file format is:

```
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
```

There can be an arbitrary number of moves specified; the important
aspect is that there is a hyphen between each character. This method
should perform the following tasks:
```
create new file reader
while there is still content to read:
    read in the name
    read in the type
    read in the max hp
    create a new character with the name, type, and max hp (called p)
    input = next thing to read
    while (!input.equals("="))
        read in power (power = nextInt())
        p.addMove(input,power)
        input = next string
    add p to the availMons ArrayList
```

After writing this method, you should be able to pass the
`testLoadMons()` test; the `testLoadMonsWithMoves()` test will fail
until you implement the `Pokemon.addMove` method appropriately.

Trainer(String name)
--------------------

In the Trainer constructor, you must initialize the `dex` and `billsPC`
instance variables as a new `HashSet` and `HashMap`, respectively.

Trainer.catchPokemon(Pokemon p)
-------------------------------

This method should add a copy of the specified pokemon to the available
Pokemon (stored in `billsPC`). Additionally, it should attempt to store
the pokemon in the pokedex (called `dex`) if it is not already there.
The method should additionally print to the screen that the trainer
caught the Pokemon, and if the pokemon has not been caught before, print
that the Pokemon’s data will be added to the Pokedex. The method should
return whether the pokemon has been caught before or not. In short:

```
Pokemon toadd = new Pokemon(p) // IMPORTANT
add toadd to billsPC
print that the Pokemon was caught
if the dex does not contain toadd:
    add toadd to dex
    print that the information will be added to the pokedex
    return true
return false
```

After writing this method, you should be able to pass the
`testCatchPokemon()` test.

Pokemon.addMove(String move, int val)
-------------------------------------

This method should put the move into the `moves` HashMap; the key is the
String and the value is the int.

After writing this method, you should be able to pass the
`testLoadMonsWithMoves()` test.

MoveModifier.loadMoves(String fname)
------------------------------------

This method should read the move types in from the specified file and
store them in the `moveTypes` HashMap. Moves are stored individual lines
in the file, in the form `key value`. Simply:

        create new file reader
        while there is more content:
            put the key value pair in moveTypes


After implementing this method, you should be able to pass the
`testLoadMoves()` test.

MoveModifier.loadAdvantages(String fname)
-----------------------------------------

This method is similar to the `loadMoves` method, but has an additional
step: there are two HashMaps: `strengths` and `weaknesses`. We will make
the assumption that if typeA is strong against typeB, then typeB is weak
against typeA. The file contains lines with `typeA typeB` on a single
line. Thus, you must:

```
create new file reader
while there is more to read:
    read in typeA
    read in typeB
    put typeA, typeB into strengths (typeA is the key, typeB is the value)
    put typeB, typeA into weaknesses (typeB is the key, typeA is the value)
```

You should now be able to pass the `testLoadAdvantages` test.

MoveModifier.getModifier(String move, String againstType)
---------------------------------------------------------

This method should determine the bonus multiplier for damage based on
the type. It should first determine the type of the move by looking it
up in the `moveTypes` HashMap. It should then determine whether or not
the type is strong against `againstType` by seeing if it is the value
for the key in the `strenghts` HashMap. This method should return 1.0 if
the move is not strong or weak against the opposing type, 1.5 if it is
strong against it, and 0.5 if it is weak against it.

        moveType = moveTypes.get(move)
        if moveType is a key in strengths and strengths.get(moveType).equals(againstType)
            return 1.5
        if moveType is a key in weaknesses and weaknesses.get(moveType) is againstType
            return 0.5
        return 1.0


This should enable you to pass the final test: `testGetModifier()`

TrainerBattle.battle(Trainer player, Trainer other)
---------------------------------------------------

There are comments in the `TrainerBattle.battle` method that will guide
you to complete the incredibly rich and interactive PokeBattle system.
The parts that are missing are:

-   Displaying the list of Available Pokemon

-   Get the move the user wants to use

-   Determine the modifier for the move the user wants to use

-   Determine the move the opponent will used

-   Determine the modifier for the move the opponent will use

There are no tests for the `TrainerBattle.battle` method; however the main method (driver) code will not function until you have completed this functionality.  You *must* complete this functionality to receive full points for the project.

Playing Around
==============

If you run the project (not just test the project), you will be
executing the main method in `Driver`. This allows you to battle your
rival in a fight for glory! Play around a bit and try some different
things. Please do not modify the `pokemon.txt`, `moves.txt`, or
`strengths.txt` files; if you want to add more pokemon, moves, or
strengths, create new files (as these are the files used for the tests).

While not required, if you want to play around with this project, try to
make a more accurate TrainerBattle: perhaps allow trainers to have more
than one Pokemon. Play! Explore! Maybe build a 2 person Trainer Battle
simulator that allows you to play with your friends (on the same
computer, of course).

One of the cool things about this project is that it is incredibly
flexible. If you wanted, you could add other types (though each type
would only have one strength or weakness), other moves, or even create
new characters! You wouldn’t be able to do this without using the data
structures we did and hardcoding in all of the constraints/types. Aren’t
data structures fun?

Grading
=======

There are 6 tests; each unit test is worth 3 points (for a total of 18
points). Of the remaining 7 points, 4 are allocated to completing the
`battle` method correctly, and 3 are allocated to having your code meet
formatting and coding standards, for a total of 25 points.

Sample Output
=============

: Note: The player is Ash

**Winning:**
```
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
```
**Losing:**
```
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
```
