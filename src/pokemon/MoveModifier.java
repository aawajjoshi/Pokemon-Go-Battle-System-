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
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 *
 * @author squishy
 */
public class MoveModifier {

    private static HashMap<String, String> moveTypes = new HashMap<>();
    private static HashMap<String, String> weaknesses = new HashMap<>();
    private static HashMap<String, String> strengths = new HashMap<>();

    public static void loadMoves(String fname) throws FileNotFoundException {
        FileReader fileReader = new FileReader(fname);
        Scanner moves = new Scanner(fileReader);
        while (moves.hasNext()) {
            moveTypes.put(moves.next(), moves.next());
        }
    }

    public static HashMap<String, String> moves() {
        return moveTypes;
    }

    public static HashMap<String, String> strengths() {
        return strengths;
    }

    public static HashMap<String, String> weaknesses() {
        return weaknesses;
    }

    public static void loadAdvantages(String fname) throws FileNotFoundException {
        String line = null;
        FileReader fileReader = new FileReader(fname);
        Scanner anotherlist = new Scanner(fileReader);
        while (anotherlist.hasNext()) {
            String typeA = anotherlist.next();
            String typeB = anotherlist.next();
            strengths.put(typeA, typeB);
            weaknesses.put(typeB, typeA);
        }

    }

    public static double getModifier(String move, String againstType) {
        String type = moveTypes.get(move);
        if (strengths.containsKey(type) && strengths.get(type).equals(againstType)) {
            return 1.5;
        } else if (weaknesses.containsKey(type) && weaknesses.get(type).equals(againstType)) {
            return 0.5;
        } else {
            return 1.0;
        }
    }
}
