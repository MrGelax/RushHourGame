/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41363.rushhour.model;
/**
 * This class creat and manage a Objet of type Position
 * @author G41363
 */
public class Position {
    private int row;
    private int column;
    /**
     * Construct one object Position with one Row and one column given in Param
     * @param row Row where the object is 
     * @param column Column where the object is
     */
    public Position(int row,int column){
        if((row<0||row>5)&&(column<0||column>5)){
            throw new IllegalArgumentException("Position non valid");
        }
        this.column=column;
        this.row=row;
    }
    /**
     * Getter of the column from the position
     * @return a int represent a column of the position
     */
    public int getColumn(){return this.column;}
    /**
     * Getter of the column from the position
     * @return a int represent a row of the position
     */
    public int getRow(){return this.row;}
    
    
    public void setRow(int row){this.row=row;}
    
    public void setColumn(int column){this.column=column;}
    
    /**
     * Return the position in under form (Row,Column)
     * @return Return a Position in String form
     */
    @Override
    public String toString() {
        return "("+this.row+","+this.column+')';
    }
    /**
     * return a new position according to the direction use in param
     * @param direction is the direction in that the car want move
     * @return return a new position
     */
    public Position getPosition(Direction direction){;
        switch(direction){
            case UP: this.row--;break;
            case DOWN:this.row++;break;
            case LEFT: this.column--;break;
            case RIGHT:this.column++;break;
        }
        Position position=new Position(this.row,this.column);
        return position;
    }
    /**
     * check if the current position equals the position given in Param
     * @param o One position given in Param
     * @return return if the pos equals the current position 
     */
    @Override
    public boolean equals(Object o){
        boolean equals=false;
        if (o!=null) {
            equals=((this.column==((Position)o).getColumn())&&
                    (this.row==((Position)o).getRow()));
        }
        return equals;
    }
}