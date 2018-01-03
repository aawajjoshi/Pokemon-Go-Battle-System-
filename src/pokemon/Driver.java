/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Class: 44-242 Data Structures
 * Author: Aawaj Raj Joshi
 * Description: Project 1
 * Due: 10/13/2017
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any other student.
 * I have not given my code to any other student and will not share this code
 * with anyone under any circumstances.
 */
package pokemon;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author squishy
 */
public class Driver {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        World.loadMons("Pokemon.txt");
        MoveModifier.loadAdvantages("strengths.txt");
        MoveModifier.loadMoves("moves.txt");
        Trainer me = new Trainer("Nate");
        Trainer opponent = new Trainer("Gary");
        me.catchPokemon(World.getRandomMon());
        opponent.catchPokemon(World.getRandomMon());
        TrainerBattle.battle(me, opponent);
    }
}
