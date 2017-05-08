/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41363.rushhour.model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This Class Test all methods of the class RushHourGame
 * @author G41363
 */
public class RushHourGameTest {
    
    /**
     * Test of getBoard method, of class RushHourGame.Case ok
     * @throws RushHourException if the height or width are smaller than 0
     */
    @Test
    public void testGetBoardOk()throws RushHourException{
        Position exit=new Position(2,6);
        Position posiRedCar= new Position(2,2);
        ArrayList<Car> listCar = new ArrayList<Car>();
        listCar.add(new Car('1',2,Orientation.HORIZONTAL,posiRedCar));
        RushHourGame instance=new RushHourGame(6,6,exit,listCar,listCar.get(0));
        Board expResult = instance.getBoard();
        Board result = instance.getBoard();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getBoard method, of class RushHourGame.Case Exception
     * @throws RushHourException if the height or width are smaller than 0
     */
    @Test(expected = RushHourException.class)
    public void testGetBoard() throws RushHourException {
        Position exit=new Position(2,6);
        Position posiRedCar= new Position(2,2);
        ArrayList<Car> listCar = new ArrayList<Car>();
        listCar.add(new Car('1',2,Orientation.HORIZONTAL,posiRedCar));
        RushHourGame instance=new RushHourGame(-1,6,exit,listCar,listCar.get(0));
        Board expResult = instance.getBoard();
        Board result = instance.getBoard();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isOver method, of class RushHourGame. Case ok
     * @throws RushHourException if the height or width are smaller than 0
     */
    @Test
    public void testIsOverOk() throws RushHourException {
        Position exit=new Position(2,6);
        Position posiRedCar= new Position(2,2);
        ArrayList<Car> listCar = new ArrayList<Car>();
        listCar.add(new Car('1',2,Orientation.HORIZONTAL,posiRedCar));
        RushHourGame instance=new RushHourGame(6,6,exit,listCar,listCar.get(0));
        boolean expResult = false;
        boolean result = instance.isOver();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of move method, of class RushHourGame. Case Right with exception
     * @throws RushHourException if the direction is null
     */
    @Test(expected = RushHourException.class)
    public void testMoveRIGHT_DIRECTION() throws RushHourException  {
        char id='1';
        Direction direction =null;
        Position exit=new Position(2,6);
        Position posiRedCar= new Position(2,2);
        ArrayList<Car> listCar = new ArrayList<Car>();
        listCar.add(new Car('1',2,Orientation.HORIZONTAL,posiRedCar));
        RushHourGame instance=new RushHourGame(6,6,exit,listCar,listCar.get(0));
        instance.move(id, direction);
    }
    /**
     * Test of move method, of class RushHourGame. Case Up with exception
     * @throws RushHourException if the direction is null
     */
    @Test(expected = RushHourException.class)
    public void testMoveUp_DIRECTION()throws RushHourException{
        char id='1';
        Direction direction =null;
        Position exit=new Position(2,6);
        Position posiRedCar= new Position(2,2);
        ArrayList<Car> listCar = new ArrayList<Car>();
        listCar.add(new Car('1',2,Orientation.VERTICAL,posiRedCar));
        RushHourGame instance=new RushHourGame(6,6,exit,listCar,listCar.get(0));
        instance.move(id, direction);
    }
    /**
     * Test of move method, of class RushHourGame.Case Down with exception
     * @throws RushHourException if the direction is null
     */
    @Test(expected = RushHourException.class)
    public void testMoveDown_DIRECTION()throws RushHourException{
        char id='1';
        Direction direction =null;
        Position exit=new Position(2,6);
        Position posiRedCar= new Position(2,2);
        ArrayList<Car> listCar = new ArrayList<Car>();
        listCar.add(new Car('1',2,Orientation.VERTICAL,posiRedCar));
        RushHourGame instance=new RushHourGame(6,6,exit,listCar,listCar.get(0));
        instance.move(id, direction);
    }
    /**
     * Test of move method, of class RushHourGame. Case Left with exception
     * @throws RushHourException if the direction is null
     */
    @Test(expected = RushHourException.class)
    public void testMoveLeft_DIRECTION()throws RushHourException{
        char id='1';
        Direction direction =null;
        Position exit=new Position(2,6);
        Position posiRedCar= new Position(2,2);
        ArrayList<Car> listCar = new ArrayList<Car>();
        listCar.add(new Car('1',2,Orientation.HORIZONTAL,posiRedCar));
        RushHourGame instance=new RushHourGame(6,6,exit,listCar,listCar.get(0));
        instance.move(id, direction);
    }

    /**
     * Test of move method, of class RushHourGame. Case Right ok
     * @throws RushHourException if the car is null and the id is empty
     */
    public void testMoveRIGHTOk() throws RushHourException  {
        char id='1';
        Direction direction =Direction.RIGHT;
        Position exit=new Position(2,6);
        Position posiRedCar= new Position(2,2);
        ArrayList<Car> listCar = new ArrayList<Car>();
        listCar.add(new Car('1',2,Orientation.HORIZONTAL,posiRedCar));
        RushHourGame instance=new RushHourGame(6,6,exit,listCar,listCar.get(0));
        instance.move(id, direction);
    }
    
    /**
     * Test of move method, of class RushHourGame.Case Up ok
     * @throws RushHourException if the car is null and the id is empty
     */
    public void testMoveUpOk()throws RushHourException{
        char id='1';
        Direction direction =Direction.UP;
        Position exit=new Position(2,6);
        Position posiRedCar= new Position(2,2);
        ArrayList<Car> listCar = new ArrayList<Car>();
        listCar.add(new Car('1',2,Orientation.VERTICAL,posiRedCar));
        RushHourGame instance=new RushHourGame(6,6,exit,listCar,listCar.get(0));
        instance.move(id, direction);
    }
    
    /**
     * Test of move method, of class RushHourGame.Case Down ok
     * @throws RushHourException if the car is null and the id is empty
     */
    public void testMoveDownOk()throws RushHourException{
        char id='1';
        Direction direction =Direction.DOWN;
        Position exit=new Position(2,6);
        Position posiRedCar= new Position(2,2);
        ArrayList<Car> listCar = new ArrayList<Car>();
        listCar.add(new Car('1',2,Orientation.HORIZONTAL,posiRedCar));
        RushHourGame instance=new RushHourGame(6,6,exit,listCar,listCar.get(0));
        instance.move(id, direction);
    }
    
    /**
     * Test of move method, of class RushHourGame.Case Left ok
     * @throws RushHourException if the car is null and the id is empty
     */
    public void testMoveLeftOk()throws RushHourException{
        char id='1';
        Direction direction =Direction.LEFT;
        Position exit=new Position(2,6);
        Position posiRedCar= new Position(2,2);
        ArrayList<Car> listCar = new ArrayList<Car>();
        listCar.add(new Car('1',2,Orientation.HORIZONTAL,posiRedCar));
        RushHourGame instance=new RushHourGame(6,6,exit,listCar,listCar.get(0));
        instance.move(id, direction);
    }
}
