/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamethelife;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class GameTheLifeTest extends TestCase{
      
      /**
     * Test of CreateBoard method, of class GameTheLife.
     */
    @Test
    public void testValidateDimension() {
        assertTrue(GameTheLife.ValidateDimension());
    }
    @Test
    public void testDefinedDeat() {
        int row = 3;
        int colum = 3;
        assertEquals(GameTheLife.DefinedDeadLive(row, colum),0);
    }
    @Test
    public void testDefinedLive() {
        int row = 2;
        int colum = 3;
        assertEquals(GameTheLife.DefinedDeadLive(row, colum),1);
    }
    @Test
    public void testLesThanTwo(){
        int row = 2;
        int colum = 3;
        assertEquals(GameTheLife.GameRules(row, colum),0);
    }
    /**
     * Test of main method, of class GameTheLife.
     */
    
}
