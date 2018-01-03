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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author squishy
 */
public class Trainer {

    private String name;
    private HashSet<Pokemon> dex;
    ArrayList<Pokemon> billsPC;

    private static Random rando = new Random();

    public Trainer(String name) {
        this.name = name;
        dex = new HashSet<Pokemon>();
        billsPC = new ArrayList<Pokemon>();
    }

    public boolean catchPokemon(Pokemon p) {
        Pokemon toadd = new Pokemon(p);
        billsPC.add(toadd);
        System.out.println(p + " was caught!");
        if (!dex.contains(toadd)) {
            dex.add(toadd);
            System.out.println(toadd + " was added to the Pokedex");
            return true;
        }

        return false;
    }

    public ArrayList<Pokemon> availablePokemon() {
        return billsPC;
    }

    public HashSet<Pokemon> pokedex() {
        return dex;
    }

    public Pokemon randoMon() {
        return billsPC.get(rando.nextInt(billsPC.size()));
    }

    public String name() {
        return name;
    }
}
