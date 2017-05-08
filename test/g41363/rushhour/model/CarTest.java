/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41363.rushhour.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * This Class Test all methods of the class Car.
 * @author G41363
 */
public class CarTest {
    /**
    * Test of GetId method,of class Car. Case True
    */
    @Test
    public void testGetIdT(){
        Position pos=new Position(1,1);
        Car instance = new Car('1',1,Orientation.HORIZONTAL,pos);
        char expResult = '1';
        char result = instance.getId();
        assertEquals(expResult, result);
    }
    /**
    * Test of GetId method,of class Car.Case False
    */
    @Test
    public void testGetIdF(){
        Position pos=new Position(1,1);
        Car instance = new Car('1',1,Orientation.HORIZONTAL,pos);
        char expResult = '1';
        char result = instance.getId();
        assertEquals(result,expResult);
    }
    /**
    * Test of Move method,of class Car.Case True
    */
    @Test
    public void testMoveT(){
        Position pos=new Position(3,3);
        Position pos2=new Position(2,3);
        Direction direction = Direction.LEFT;
        Car instance =new Car('1',1,Orientation.HORIZONTAL,pos);
        instance.move(direction);
        instance.getCurrentPosition().equals(pos2);
    }
    /**
    * Test of Move method,of class Car.Case False
    */
    @Test
    public void testMoveF(){//test ok
        Position pos=new Position(1,1);
        Position expResult=new Position(2,1);
        Direction direction = Direction.DOWN;
        Car instance =new Car('1',2,Orientation.VERTICAL,pos);
        instance.move(direction);
        assertEquals(instance.getCurrentPosition(),expResult);
    }
    /**
     * Test of Move method,of class Car.Case HorizontalRight true
     */
    @Test
    public void testMoveHORIZONTALRIGHT_T() {
        Position pos=new Position(3,3);
        Direction direction = Direction.RIGHT;
        Car instance =new Car('1',1,Orientation.HORIZONTAL,pos);
        instance.move(direction);
        int result=instance.getPositions().get(0).getColumn()+1;
        int expResult=5;
        assertEquals(expResult,result);
    }
    /**
     * 
     */
    @Test
    public void testMoveHORIZONTALLEFT_T() {
        Position pos=new Position(3,3);
        Direction direction = Direction.LEFT;
        Car instance =new Car('1',1,Orientation.HORIZONTAL,pos);
        instance.move(direction);
        Integer result=instance.getPositions().get(0).getColumn()-1;
        Integer expResult=1;
        assertEquals(expResult,result);
    }
    /**
     * 
     */
    @Test
    public void testMoveVERTICALDOWN_T() {
        Position pos=new Position(3,3);
        Direction direction = Direction.DOWN;
        Car instance =new Car('1',1,Orientation.VERTICAL,pos);
        instance.move(direction);
        Integer result=instance.getPositions().get(0).getColumn();
        Integer expResult=3;
        assertEquals(expResult,result);
    }
    /**
    * Test of GetPosition method,of class Car.Case True
    */
    @Test
    public void testGetPositionsTrue(){
        Position pos=new Position(1,1);
        Car car = new Car('1',2,Orientation.HORIZONTAL,pos);
        List<Position> expResult=new ArrayList<Position>();
        expResult.add(pos);
        List<Position> result = car.getPositions();
        result.get(0).equals(expResult.get(0));
    }
    /**
    * Test of GetPosition method,of class Car.Case False
    */
    @Test
    public void testGetPositionsFalse(){
        Position pos=new Position(1,1);
        Position pos2=new Position(1,2);
        Car car = new Car('1',2,Orientation.HORIZONTAL,pos);
        List<Position> expResult=new ArrayList<Position>();
        expResult.add(pos2);
        List<Position> result = car.getPositions();
        result.get(0).equals(expResult.get(0));
    }
    
    
    @Test
    public void CarTestOK() {
    
    }
    /**
     * Test if the Illegale ArgumentException is run.Case Down
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMoveHORIZONTALDOWN() {
        Position pos=new Position(3,3);
        Direction direction = Direction.DOWN;
        Car instance =new Car('1',1,Orientation.HORIZONTAL,pos);
        instance.move(direction);
    }
    /**
     * Test if the Illegale ArgumentException is run.Case Up
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMoveHORIZONTALUP() {
        Position pos=new Position(3,3);
        Direction direction = Direction.UP;
        Car instance =new Car('1',1,Orientation.HORIZONTAL,pos);
        instance.move(direction);
    }
    /**
     * Test if the Illegale ArgumentException is run.Case Left
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMoveVERTICALLEFT() {
        Position pos=new Position(3,3);
        Direction direction = Direction.LEFT;
        Car instance =new Car('1',1,Orientation.VERTICAL,pos);
        instance.move(direction);
    }
    /**
     * Test if the Illegale ArgumentException is run.Case Right
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMoveVERTICALRIGHT() {
        Position pos=new Position(3,3);
        Direction direction = Direction.RIGHT;
        Car instance =new Car('1',1,Orientation.VERTICAL,pos);
        instance.move(direction);
    }
}