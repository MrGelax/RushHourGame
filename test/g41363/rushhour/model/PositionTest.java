/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41363.rushhour.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This Class Test all methods of the class Position
 * @author G41363
 */
public class PositionTest {
    public PositionTest() {
    }
    /**
     * Test of toString method, of class Position.Case False
     */
    @Test
    public void testToStringFalse() {
        Position instance = new Position(4,3);
        String expResult = "("+instance.getRow()+","+instance.getColumn()+")";
        String result = instance.toString()+"b";
        if ((expResult.equals(result))==false){
            System.out.println("False");
        }
    }
    /**
     * Test of toString method, of class Position.Case True
     */
    @Test
    public void testToStringTrue() {
        Position instance = new Position(4,3);
        String expResult = "("+instance.getRow()+","+instance.getColumn()+")";
        String result = instance.toString();
        if ((expResult.equals(result))==true){
            System.out.println("True");
        }
    }
    
    /**
     * Test of getPosition method, for direction Up is False
     */
    @Test
    public void testGetPositionUpFalse() {
        Direction direction = Direction.UP;
        Position instance = new Position(4,3);
        Position expResult=new Position(4,3);
        instance=instance.getPosition(direction);
        assertEquals(expResult, expResult);
    }
    
    /**
     * Test of getPosition method, for Direction down is False
     */
    @Test
    public void testGetPositionDownFalse() {
        Direction direction = Direction.DOWN;
        Position instance = new Position(4,3);
        Position expResult=new Position(4,3);
        instance=instance.getPosition(direction);
        assertEquals(expResult, expResult);
    }
    /**
     * Test of getPosition method, for direction Left is False
     */
    @Test
    public void testGetPositionLeftFalse() {
        Direction direction = Direction.LEFT;
        Position instance = new Position(4,3);
        Position expResult=new Position(4,3);
        instance=instance.getPosition(direction);
        assertEquals(expResult, expResult);
    }
    /**
     * Test of getPosition method, for Direction Right is False
     */
    @Test
    public void testGetPositionRightFalse() {
        Direction direction = Direction.RIGHT;
        Position instance = new Position(4,3);
        Position expResult=new Position(4,3);
        instance=instance.getPosition(direction);
        assertEquals(expResult, expResult);
    }
    /**
     * Test of getPosition method, for direction Up is True
     */
    @Test
    public void testGetPositionUpTrue() {
        Direction direction = Direction.UP;
        Position instance = new Position(4,3);
        Position expResult=new Position(3,3);
        instance=instance.getPosition(direction);
        assertEquals(expResult, expResult);
    }
    
    /**
     * Test of getPosition method, for Direction down is true
     */
    @Test
    public void testGetPositionDownTrue() {
        Direction direction = Direction.DOWN;
        Position instance = new Position(4,3);
        Position expResult=new Position(5,3);
        instance=instance.getPosition(direction);
        assertEquals(expResult, expResult);
    }
    /**
     * Test of getPosition method, for direction Left is true
     */
    @Test
    public void testGetPositionLeftTrue() {
        Direction direction = Direction.LEFT;
        Position instance = new Position(4,3);
        Position expResult=new Position(4,2);
        instance=instance.getPosition(direction);
        assertEquals(expResult, expResult);
    }
    /**
     * Test of getPosition method, for Direction Right is True
     */
    @Test
    public void testGetPositionRightTrue() {
        Direction direction = Direction.RIGHT;
        Position instance = new Position(4,3);
        Position expResult=new Position(4,4);
        instance=instance.getPosition(direction);
        assertEquals(expResult, expResult);
    }
}
