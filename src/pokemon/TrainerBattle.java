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

import java.util.Random;
import java.util.Scanner;
import static pokemon.MoveModifier.getModifier;

/**
 *
 * @author squishy
 */
public class TrainerBattle {

    private static Random rando = new Random();

    public static void battle(Trainer player, Trainer opponent) {
        Scanner cin = new Scanner(System.in);
        Pokemon opponentMon = opponent.randoMon();
        String move = "";
        double mod = 0.0;
        System.out.println("Who would you like to send out?");

        for (int i = 0; i < player.billsPC.size(); i++) {
            System.out.println(i + ". ");
            System.out.println(player.billsPC.get(i));
        }

        Pokemon playerMon = player.availablePokemon().get(cin.nextInt());

        while (opponentMon.currentHP() > 0 && playerMon.currentHP() > 0) {
            System.out.println("****");
            System.out.println("[" + player.name() + "] " + playerMon);
            System.out.println("[" + opponent.name() + "] " + opponentMon);

            System.out.println("Which move would you like to use?");
            printMoves(playerMon);

            move = playerMon.moveList().get(cin.nextInt());

            mod = getModifier(move, opponentMon.type());

            atkMesg(playerMon, move, mod);

            opponentMon.takeDamage(calcDamage(playerMon, move, mod));

            if (opponentMon.currentHP() <= 0) {
                System.out.println(opponentMon.name() + " fainted");
            } else {
                int randomMove = rando.nextInt(opponentMon.moveList().size());

                move = opponentMon.moveList().get(randomMove);

                atkMesg(opponentMon, move, mod);
                playerMon.takeDamage(calcDamage(opponentMon, move, mod));
                if (playerMon.currentHP() <= 0) {
                    System.out.println(playerMon.name() + " fainted");
                }
            }

        }
        if (playerMon.currentHP() > 0) {
            System.out.println(player.name() + " wins!");
        } else {
            System.out.println(opponent.name() + " wins!");
        }
    }

    public static int calcDamage(Pokemon p, String move, double mod) {
        return (int) ((p.movePower(move) + 0.5) * mod);
    }

    public static void printMoves(Pokemon p) {

        for (int i = 0; i < p.moveList().size(); i++) {
            System.out.println(i + ". " + p.moveList().get(i));
        }
    }

    public static void atkMesg(Pokemon p, String move, double mod) {
        System.out.println(p.name() + " used " + move);
        if (mod == 0.5) {
            System.out.println("It's not very effective.");
        }
        if (mod == 1.5) {
            System.out.println("It's super effective!");
        }
    }
}
