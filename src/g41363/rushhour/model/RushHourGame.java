/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41363.rushhour.model;

import static g41363.rushhour.model.Direction.*;
import java.util.List;

/**
 * This class creat and manage a Objet of type RushHourGame
 * @author G41363
 */
public class RushHourGame {
    private Board board;
    private Car redCar;
    
    public Car getRedCar(){return this.redCar;}
    /**
     * Construct a RushHour Game
     * @param height Height of the board
     * @param width width of the board
     * @param exit Position who the exit is
     * @param listCar List of a different car in the board
     * @param redCar Red car of the board
     * @throws RushHourException 
     */
    public RushHourGame(int height,int width,Position exit,
            List<Car>listCar,Car redCar)throws RushHourException{
        if (height<=0)
            throw new RushHourException("the height can't be more small than 0");
        if (width<=0)
            throw new RushHourException("the width can't be more small than 0");
        this.board=new Board(height,width,exit);
        for (Car car:listCar)
            this.board.put(car);
        this.redCar=redCar;
        this.board.put(redCar);
    }
    /**
     * Getter of RushHourGame
     * @return a board
     */
    public Board getBoard(){return this.board;}
    /**
     * Move the car than the player are selected
     * @param id It's a id of the car
     * @param direction  It's the direction to the player will move the car
     */
    public void move(char id,Direction direction)throws RushHourException{
        String str=""+id;
        if (str.length()==0) {
            throw new RushHourException("You must selected a Id");
        }
        if (direction==null) {
            throw new RushHourException("You must selected a Direction");
        }
        Car car=this.board.getCar(id);        
        if (this.board.canMove(car, direction)) {
            board.remove(car);
            car.move(direction);
            board.put(car);
        }
    }
    
    /**
     * check if the game is finished 
     * @return a boolean
     */
    public boolean isOver(){
        boolean over=false;
        List<Position> redCarPosition = redCar.getPositions();
        for (Position position : redCarPosition) {
            if (position.equals(board.getExit())) {
                over=true;
            }
        }
        return over;
    }
}