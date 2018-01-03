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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author squishy
 */
public class World {

    private static ArrayList<Pokemon> availMons = new ArrayList<>();
    private static Random rando = new Random();

    public static void loadMons(String fname) throws FileNotFoundException {
        File file = new File("Pokemon.txt");
        Scanner inputFile = new Scanner(file);

        while (inputFile.hasNext()) {
            String name = inputFile.next();
            String type = inputFile.next();
            int maxhp = inputFile.nextInt();

            Pokemon p = new Pokemon(name, type, maxhp);

            String input = inputFile.next();

            while (!"-".equals(input)) {
                int power = inputFile.nextInt();
                p.addMove(input, power);
                input = inputFile.next();
            }

            availMons.add(p);

        }
    }

    public static Pokemon getRandomMon() {
        return availMons.get(rando.nextInt(availMons.size()));
    }

    public static ArrayList<Pokemon> allMons() {
        return availMons;
    }
}
