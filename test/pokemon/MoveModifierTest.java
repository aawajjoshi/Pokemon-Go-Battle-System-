/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.io.FileNotFoundException;
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
public class MoveModifierTest {
    
    public MoveModifierTest() {
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

    /**
     * Test of loadMoves method, of class MoveModifier.
     */
    @Test
    public void testLoadMoves() throws Exception {
        String fname = "moves.txt";
        MoveModifier.loadMoves(fname);
        assertEquals(6, MoveModifier.moves().size());
        assertEquals("fire", MoveModifier.moves().get("ember"));
        assertEquals("water", MoveModifier.moves().get("bubble"));
        assertEquals("water", MoveModifier.moves().get("water_gun"));
        assertEquals("grass", MoveModifier.moves().get("razor_leaf"));
        assertEquals("grass", MoveModifier.moves().get("vine_whip"));
        assertEquals("fire", MoveModifier.moves().get("flamethrower"));
    }

    /**
     * Test of loadAdvantages method, of class MoveModifier.
     */
    @Test
    public void testLoadAdvantages() throws Exception {
        MoveModifier.strengths().clear();
        MoveModifier.weaknesses().clear();
        String fname = "strengths.txt";
        MoveModifier.loadAdvantages(fname);
        assertEquals(3, MoveModifier.strengths().size());
        assertEquals(3, MoveModifier.weaknesses().size());
        assertEquals("fire", MoveModifier.strengths().get("water"));
        assertEquals("water", MoveModifier.strengths().get("grass"));
        assertEquals("grass", MoveModifier.strengths().get("fire"));
        
        assertEquals("fire", MoveModifier.weaknesses().get("grass"));
        assertEquals("water", MoveModifier.weaknesses().get("fire"));
        assertEquals("grass", MoveModifier.weaknesses().get("water"));
    }

    /**
     * Test of getModifier method, of class MoveModifier.
     */
    @Test
    public void testGetModifier() throws FileNotFoundException {
        MoveModifier.strengths().clear();
        MoveModifier.weaknesses().clear();
        MoveModifier.moves().clear();
        MoveModifier.loadAdvantages("strengths.txt");
        MoveModifier.loadMoves("moves.txt");
        assertEquals(1.0, MoveModifier.getModifier("ember", "fire"), 0.0);
        assertEquals(1.5, MoveModifier.getModifier("water_gun", "fire"), 0.0);
        assertEquals(0.5, MoveModifier.getModifier("vine_whip", "fire"), 0.0);
    }
    
}
