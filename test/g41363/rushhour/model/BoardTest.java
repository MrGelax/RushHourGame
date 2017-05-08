/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41363.rushhour.model;

import static g41363.rushhour.model.Direction.*;
import static g41363.rushhour.model.Orientation.*;
import static g41363.rushhour.view.Display.displayBoard;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro
 */
public class BoardTest {
    
    public BoardTest() {
    }

    /**
     * Test of getExit method, of class Board.Case True
     */
    @Test
    public void testGetExitOk() {
        Board instance = new Board();
        Position expResult=new Position(2,5);
        Position result = instance.getExit();
        result.equals(result);
        
    }

    /**
     * Test of getExit method, of class Board.Case False
     */
    @Test
    public void testGetExitNotOk() {
        Board instance = new Board();
        Position expResult=new Position(2,4);
        Position result=instance.getExit();
        result.equals(expResult);
    }
    /**
     * Test of getGrid method, of class Board.Case true
     */
    @Test
    public void testGetGridOk() {
        Board instance = new Board();
        Car[][] expResult = null;
        Car[][] result=instance.getGrid();
        result.equals(expResult);
    }
    
    /**
     * Test of getGrid method, of class Board.Case False
     */
    @Test
    public void testGetGridNotOk() {
        Position pos=new Position(2,3);
        Board board=new Board(6,6,pos);
        Car[][] expResult = null;
        Car[][] result=board.getGrid();
        result.equals(expResult);
    }
    
    /**
     * Test of getHauteur method, of class Board.Case True
     */
    @Test
    public void testGetHauteurOk() {
        Board instance=new Board();
        Integer expResult=6;
        Integer result=instance.getHauteur();
        result.equals(expResult);
    }
    
    /**
     * Test of getHauteur method, of class Board.Case False
     */
    @Test
    public void testGetHauteurNotOk() {
        Board instance=new Board();
        Integer expResult=5;
        Integer result=instance.getHauteur();
        result.equals(expResult);
    }
        /**
     * Test of getHauteur method, of class Board.Case True
     */
    @Test
    public void testGetLargeurOk() {
        Board instance=new Board();
        Integer expResult=6;
        Integer result=instance.getLargeur();
        result.equals(expResult);
    }
    
    /**
     * Test of getHauteur method, of class Board.Case False
     */
    @Test
    public void testGetLargeurNotOk() {
        Board instance=new Board();
        Integer expResult=5;
        Integer result=instance.getLargeur();
        result.equals(expResult);
    }
    /**
     * Test of getCarAT method, of class Board.Case True
     */
    @Test
    public void testGetCarATOk() {
        Position pos=new Position(1,1);
        Board instance=new Board();
        Car expResult =new Car('x',2,Orientation.HORIZONTAL,pos);
        instance.put(expResult);
        Car result = instance.getCarAT(pos);
        expResult.equals(result);
    }
    /**
     * Test of getCarAT method, of class Board.Case False
     */
    @Test
    public void testGetCarATNotOk() {
        Position pos=new Position(1,1);
        Position posiCar2=new Position(2,1);
        Board instance=new Board();
        Car expResult =new Car('x',2,Orientation.HORIZONTAL,pos);
        instance.put(expResult);
        Car result=new Car('x',2,Orientation.HORIZONTAL,posiCar2);
        expResult.equals(result);
    }
    /**
     * Test of initializeTabDefault method, of class Board.
     */
    @Test
    public void testInitializeTabDefault() {
        int height = 0;
        int width = 0;
        Car x = null;
        int j = 0;
        Board instance = new Board();
        instance.initializeTabDefault(height,width,j);
    }

    /**
     * Test of initializeTab method, of class Board.
     */
    @Test
    public void testInitializeTab() {
        int height = 0;
        int width = 0;
        Car x = null;
        Position exit = null;
        int j = 0;
        Board instance = new Board();
        
    }

    /**
     * Test of canPut method, of class Board. Case True
     */
    @Test
    public void testCanPutOk() {
        Position pos=new Position(1,1);
        Car car=new Car('Z',2,HORIZONTAL,pos);
        Board instance = new Board();
        boolean expResult=true;
        boolean result=instance.canPut(car);
        assertEquals(expResult, result);
    }

    /**
     * Test of canPut method, of class Board. Case False
     */
    @Test
    public void testCanPutNotOk() {
        Position pos=new Position(1,1);
        Car car=new Car('Z',2,HORIZONTAL,pos);
        Position pos2=new Position(1,1);
        Car car2=new Car('X',3,HORIZONTAL,pos2);
        Board instance = new Board();
        instance.put(car);
        boolean expResult=false;
        boolean result=instance.canPut(car2);
        assertEquals(expResult, result);
    }
    /**
     * Test of put method, of class Board.Case true
     */
    @Test
    public void testPutOk() {
        Position pos=new Position(1,1);
        Car car=new Car('Z',2,HORIZONTAL,pos);
        Board instance = new Board();
        instance.put(car);
    }
    /**
     * Test of put method, of class Board.Case true
     */
    @Test
    public void testPutNotOk() {
        Position posiCarX=new Position(1,1);
        Position posiCarY=new Position(1,1);
        Car carX=new Car('X',2,HORIZONTAL,posiCarX);
        Car carY=new Car('Y',2,HORIZONTAL,posiCarY);
        Board instance = new Board();
        instance.put(carX);
        instance.put(carY);
    }

    /**
     * Test of remove method, of class Board.
     */
    @Test
    public void testRemoveOk() {
        Position posiCar=new Position(1,1);
        Car car=new Car('X',2,HORIZONTAL,posiCar);
        Board instance=new Board();
        instance.put(car);
        Car expResult=null;
        instance.remove(car);
        Car result=instance.getCarAT(posiCar);
        assertEquals(result,expResult);
    }
    /**
     * Test of getCar method, of class Board.
     */
    @Test
    public void testGetCarNotOk() {
        char id ='x';
        Board instance = new Board();
        Position posiCar=new Position (2,3);
        Car expResult=new Car('x',2,Orientation.HORIZONTAL,posiCar);
        instance.put(expResult);
        Car result=instance.getCar(id);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getCar method, of class Board.
     */
    @Test
    public void testGetNotOk() {
        char id ='x';
        Board instance = new Board();
        Position posiCar=new Position (2,3);
        Car expResult=new Car('x',2,Orientation.HORIZONTAL,posiCar);
        instance.put(expResult);
        Car result=instance.getCar(id);
        assertEquals(expResult, result);
    }
    

    /**
     * Test of canMove method, of class Board.
     */
    @Test
    public void testCanMoveOk() {
        Position posiCar=new Position(2,3);
        Car car=new Car('Z',2,HORIZONTAL,posiCar);
        Position posiCar2=new Position(0,0);
        Car car2=new Car('X',2,VERTICAL,posiCar2);
        Direction direction =LEFT;
        Board instance = new Board();
        instance.put(car);
        instance.put(car2);
        boolean expResult = true;
        boolean result = instance.canMove(car, direction);
        assertEquals(expResult, result);
    }
    /**
     * Test of canMove method, of class Board.
     */
    @Test
    public void testCanMoveNotOk() {
        Position posiCar=new Position(2,3);
        Car car=new Car('Z',2,HORIZONTAL,posiCar);
        Position posiCar2=new Position(0,0);
        Car car2=new Car('X',2,VERTICAL,posiCar2);
        Direction direction =LEFT;
        Board instance = new Board();
        instance.put(car);
        instance.put(car2);
        boolean expResult = true;
        boolean result = instance.canMove(car, direction);
        assertEquals(expResult, result);
    }
}
