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
import java.util.ArrayList;
import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author squishy
 */
public class TrainerTest {

    public TrainerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCatchPokemon() throws FileNotFoundException {
        World.allMons().clear();
        World.loadMons("pokemon.txt");
        Pokemon p = World.allMons().get(0);
        Trainer instance = new Trainer("bob");
        boolean result = instance.catchPokemon(p);
        assertEquals(true, result);
        result = instance.catchPokemon(p);
        assertEquals(false, result);
        result = instance.catchPokemon(World.allMons().get(1));
        assertEquals(true, result);
    }

}
