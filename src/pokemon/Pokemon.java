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
import java.util.Objects;

public class Pokemon {

    private String name;
    private String type;
    private HashMap<String, Integer> moves;
    private int maxHP;
    private int currHP;

    public Pokemon() {
        name = "";
        type = "";
        moves = new HashMap<>();
    }

    public Pokemon(String n, String t, int max) {
        name = n;
        type = t;
        maxHP = max;
        currHP = max;
        moves = new HashMap<>();
    }

    public Pokemon(Pokemon other) {
        name = other.name;
        type = other.type;
        moves = new HashMap<>(other.moves);
        maxHP = other.maxHP;
        currHP = other.currHP;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMaxHP(int hp) {
        this.maxHP = hp;
        this.currHP = hp;
    }

    public void addMove(String move, int val) {

        moves.put(move, val);
    }

    public String type() {
        return type;
    }

    public String name() {
        return name;
    }

    public int currentHP() {
        return this.currHP;
    }

    public int maximumHP() {
        return this.maxHP;
    }

    public ArrayList<String> moveList() {
        return new ArrayList<>(moves.keySet());
    }

    public int movePower(String moveName) {
        return moves.get(moveName);
    }

    public void takeDamage(int amt) {
        currHP -= amt;
    }

    public void healDamage(int amt) {
        currHP += amt;
    }

    public void healAll() {
        currHP = maxHP;
    }

    @Override
    public String toString() {
        return name + ": " + currHP + "/" + maxHP;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pokemon other = (Pokemon) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
}
