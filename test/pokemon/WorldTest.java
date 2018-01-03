/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

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
public class WorldTest {
    
    public WorldTest() {
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
     * Test of loadMons method, of class World.
     */
    @Test
    public void testLoadMons() throws Exception {
        World.allMons().clear();
        String fname = "pokemon.txt";
        World.loadMons(fname);
        assertEquals(World.allMons().size(), 3);
        Pokemon p = World.allMons().get(0);
        assertEquals("Bulbasaur", p.name());
        assertEquals("grass", p.type());
        assertEquals(30, p.maximumHP());
        p = World.allMons().get(1);
        assertEquals("Squirtle", p.name());
        assertEquals("water", p.type());
        assertEquals(35, p.maximumHP());
        
        p = World.allMons().get(2);
        assertEquals("Charmander", p.name());
        assertEquals("fire", p.type());
        assertEquals(40, p.maximumHP());
    }    
    
    @Test
    public void testLoadMonsWithMoves() throws Exception {
        String fname = "pokemon.txt";
        World.allMons().clear();
        World.loadMons(fname);
        assertEquals(World.allMons().size(), 3);
        Pokemon p = World.allMons().get(0);
        assertEquals("Bulbasaur", p.name());
        assertEquals("grass", p.type());
        assertEquals(30, p.maximumHP());
        assertEquals(3, p.moveList().size());
        assertEquals(2, p.movePower("tackle"));
        assertEquals(6, p.movePower("razor_leaf"));
        assertEquals(4, p.movePower("vine_whip"));
        p = World.allMons().get(1);
        assertEquals("Squirtle", p.name());
        assertEquals("water", p.type());
        assertEquals(35, p.maximumHP());
        assertEquals(3, p.moveList().size());
        assertEquals(2, p.movePower("tackle"));
        assertEquals(3, p.movePower("bubble"));
        assertEquals(7, p.movePower("water_gun"));
        
        p = World.allMons().get(2);
        assertEquals("Charmander", p.name());
        assertEquals("fire", p.type());
        assertEquals(40, p.maximumHP());
        assertEquals(2, p.moveList().size());
        assertEquals(2, p.movePower("scratch"));
        assertEquals(5, p.movePower("ember"));
    }  
}
