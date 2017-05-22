/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41363.rushhour.model;

import static g41363.rushhour.model.Direction.*;
import static g41363.rushhour.model.Orientation.*;
import java.util.*;
import javafx.scene.image.Image;
/**
 * This class creat and manage a Objet of type Car
 * @author Pedro
 */
public class Car {
    private char id;
    private int size;
    private Orientation orientation;
    private Position currentPosition; 
    private Image img;
    /**
     * Cronstruct a car with a id, size,orientation and a current Position
     * @param id it's the id of the car
     * @param size it's the size of the car
     * @param orientation it's the orientation of the car.Horizontal or Vertical
     * @param currentPosition it's the a current of the car
     */
    public Car(char id,int size,Orientation orientation,
            Position currentPosition){
        if (size<=0) {
            throw new IllegalArgumentException("The size is not valid"); 
        }
        this.id=id;
        this.size=size;
        this.currentPosition=currentPosition;
        this.orientation=orientation;
    }
    
    public Car(String str){
        Random r=new Random();
        this.id=str.charAt(0);
        this.size=Integer.parseInt(""+str.charAt(1));
        if(str.charAt(2)=='H')
            this.orientation=Orientation.HORIZONTAL;
        else
            this.orientation=Orientation.VERTICAL;
        this.currentPosition=new Position(Integer.parseInt(""+str.charAt(3)),
                Integer.parseInt(""+str.charAt(4)));
        //if(this.size==2) ajouter pour la vFinal
            this.img=new Image("file:img\\Voiture"+(r.nextInt(3-1+1)+1)+"b.jpg");
        /*else ajouter pour la v Final
            if(this.size==3)
                this.img=new Image("file:img\\Voiture"+(r.nextInt(5-4+1)+4)+".jpg");
        */  
    }
    
    public Image getImg(){return this.img;}
    
    
    /**
     * Getter of the size of the car
     * @return return a int
     */
    public int getSize(){return this.size;}
    /**
     * Getter of the id of the car
     * @return return a char
     */
    public char getId(){return this.id;}

    
    public void setSize(int size){this.size=size;}
    
    public void setId(char id){this.id=id;}
    
    public void setOrientation(Orientation ori){this.orientation=ori;}
    
    public void setCurrentPosition(Position posi){this.currentPosition=posi;}
    
    /**
     * Getter of the current position of the car
     * @return a Position
     */
    public Position getCurrentPosition(){return this.currentPosition;}
    /**
     * Getter of the orientation of the car
     * @return a Orientation
     */
    public Orientation getOrientation(){return this.orientation;}
    /**
     * return in sentences,the characteristic of a car
     * @return return a string depict the car 
     */
    @Override
    public String toString() {
        return "the car "+this.id+"has as size "+this.size+
                "and is oriented "+this.orientation+
                " and have a currentPosition in "+this.currentPosition;
    }
    public String toStringT(){
        return ""+this.id+this.size+this.orientation.toString().charAt(0)+
                this.currentPosition.getRow()+this.currentPosition.getColumn();
    }
    /**
     * check if the player can move one car in a direction
     * @param direction it's a direction than the player want move the car
     */
    public void move(Direction direction){
        if((this.orientation==Orientation.VERTICAL&&
                (direction==Direction.RIGHT||direction==Direction.LEFT))||
                (this.orientation==Orientation.HORIZONTAL&&
                (direction==Direction.UP||direction==Direction.DOWN))){
            throw new IllegalArgumentException("Move this car is impossible");
        }else{
            this.currentPosition.getPosition(direction);
        }
    }
    /**
     * realize one loop for initialized the list give in param
     * @param row The row where the car is
     * @param column The column where the car is
     * @param listPos List of positions belong to car
     * @return return a list composed of the position to the car 
     */
    public List<Position> getPositionFor(int row,int column,
            List<Position> listPos){
        for(int i=0;i<size;i++){
            listPos.add(new Position(row,column));
            if(orientation == Orientation.HORIZONTAL)
                column++;
            else
                row++;
        }
        return listPos;
    }
    /**
     * creat and initialize one list composed buf the positions of the car
     * @param car
     * @return return a list composed 
     */ 
    public List<Position> getPositions(){
        List<Position> listPosition = new ArrayList();
        int row=currentPosition.getRow(),column=currentPosition.getColumn();
        listPosition=getPositionFor(row, column, listPosition);
        return listPosition;
    }
    /**
     * Check if the car can move vertically
     * @param direction direction than a player will move the car
     * @param grid tab which contains a Cars
     * @param valid it's a boolean variable
     * @param height it a height of the board
     * @return return true or false
     */
    public boolean moveVerti(Direction direction,Car[][]grid,int height){//à tester
        boolean valid = false;
        switch(direction){
            case UP:valid=this.currentPosition.getRow()-1>=0&&
                    grid[this.currentPosition.getRow()-1]
                    [this.currentPosition.getColumn()]==null;break;
            case DOWN:valid=this.currentPosition.getRow()+this.getSize()<height&&
                    grid[this.currentPosition.getRow()+this.getSize()]
                    [this.currentPosition.getColumn()]==null;break;
        }
        return valid;
    }
    /**
     * Check if the car can move horizontally
     * @param direction direction than a player will move the car
     * @param grid tab which contains a Cars
     * @param valid it's a boolean variable
     * @return return true or false
     */
    public boolean moveHori(Direction direction,Car[][]grid){//fonctionne parfaitement
        boolean valid=false;
        switch(direction){
            case LEFT:valid=this.currentPosition.getColumn()-1>=0&&
                    grid[this.currentPosition.getRow()]
                    [this.currentPosition.getColumn()-1]==null;break;
            case RIGHT:valid=this.currentPosition.getColumn()+this.getSize()<grid[0].length&&
                    grid[this.currentPosition.getRow()]
                    [this.currentPosition.getColumn()+this.getSize()]==null;break;
        }
        return valid;
    }
    /**
     * Compare two object of type Car
     * @param o Objetc to compare
     * @return return if the Object o is equals to the car
     */
    @Override
    public boolean equals(Object o){
        boolean equals=false;
        if (o!=null) {
            equals=(this.id==((Car)o).id)&&
                    this.currentPosition.equals(((Car)o).currentPosition)
                    &&this.orientation==((Car)o).orientation&&this.size==((Car)o).size;
        }
        return equals;
    }
}