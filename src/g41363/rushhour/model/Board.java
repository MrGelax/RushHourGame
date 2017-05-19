/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41363.rushhour.model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.image.Image;

/**
 * This class creat and manage a Objet of type Board
 * @author G41363
 */
public class Board {
    private Car[][]grid;
    private Position exit;//=new Position(2,5);
  //  private Image img;
    
    /**
     * Getter of the position of the exit
     * @return return the position of the exit
     */
    public Position getExit(){return this.exit;}
    /**
     * Getter of the grid containing cars
     * @return one grid containing cars
     */
    public Car[][] getGrid(){return this.grid;}
    /**
     * Geter of the height of board
     * @return the height of board
     */
    public int getHauteur(){                    
        return this.getGrid().length;
    }
    /**
     * Getter of the width of board 
     * @return the width of board 
     */
    public int getLargeur(){
        return this.getGrid()[0].length;
    }
    /**
     * Initialize by default the board
     * @param height Height of board
     * @param width Width of board
     * @param j 
     */
    final public void initializeTabDefault(int height,int width,int j){             
        for(int i=0;i<height;i++){
            for(j=0;j<width;j++){
                this.grid[i][j]=null;
            }
        }
    }
    /**
     * Construct a board by default
     */
    public Board(){
        this.grid = new Car[6][6];
        exit=new Position(2,5);
        int height=6;
        int width=6;
        int j=0;
        initializeTabDefault(height,width,j);
    }
    /**
     * Initialize a board  with a height, a width, 
     * @param height Height of board
     * @param width Width of board
     * @param j temporary variables
     */
    public void initializeTab(int height,int width,int j){
        for(int i=0;i<height;i++){
            for(j=0;j<width;j++){
                this.grid[i][j]=null;  
            }
        }
    }
    /**
     * Construct a board with a height, a width an a exit take in param
     * @param height Height of board
     * @param width Width of board
     * @param exit position where the exit is 
     */
    public Board(int height,int width,Position exit){
        this.grid = new Car[height][width];
        int j=0;
        validParam(height,width,exit);
        this.exit=new Position(exit.getRow(),exit.getColumn());
        initializeTab(width,height,j);
//        this.img=new Image("file:RushHour\\g41363\\img\\parking.jpg");
    }
    /**
     * Check if a height, a width and the position of exit it's valid
     * @param height Height of board
     * @param width Width of board
     * @param exit exit of board
     */
    private void validParam(int height,int width,Position exit){
        if(height<0||height>6||width<0||width>6||exit.getRow()==0||
                exit.getRow()==5){
            throw new IllegalArgumentException("Your parametre are not valid");
        }
    }
    /**
     * Look if the car can put in the board
     * @param car the car that the player will move
     * @return if the car can put in the board
     */
    public boolean canPut(Car car){ 
        boolean valid=true;     
        for(Position pos:car.getPositions()) {
            valid&=this.grid[pos.getRow()][pos.getColumn()]==null;
        }  
        return valid;
    }
    /**
     * put the car in the coard
     * @param car the car that the player will move
     */
    public void put(Car car){
        for(Position pos:car.getPositions()) {
            this.grid[pos.getRow()][pos.getColumn()]=car;
        }
    }
    /**
     * remove the car in the board and put to null the boxes occupied by the car
     * @param car the car that we want removed
     */
    public void remove(Car car){
        for(Position pos:car.getPositions()) {
            this.grid[pos.getRow()][pos.getColumn()]=null;
        }
    }
    
    /**
     * return the car that is to poisition spent in param
     * @param pos position of the we want take
     * @return the car that is to poisition spent in param or null if there are
     * no in the board
     */
    public Car getCarAT(Position pos) {
        Car carReturned = null;
        if(this.grid[pos.getRow()][pos.getColumn()]!= null) {
            carReturned = this.grid[pos.getRow()][pos.getColumn()];
        }
        return carReturned;
    }
    /**
     * research by his id a car.And return the car if it is found or return null 
     * @param id id of the car to find
     * @return return the car if it is found or return null if it is not found
     */
    public Car getCar(char id){
        Car carReturned=null;
        for (int i = 0; i <this.getHauteur(); i++) {
            for (int j = 0; j <this.getLargeur(); j++) {
                if(getGrid()[i][j]!=null&&getGrid()[i][j].getId()==id) {
                    carReturned=grid[i][j];
                }
            }
        }
        return carReturned;
    }
    /**
     * chech if the car can move in the board
     * @param car the car that we want move
     * @param direction the direction where we want move the car 
     * @return return true if the car can move, and false otherwise
     */
    public boolean canMove(Car car,Direction direction){
        boolean valid=false;
        if(direction != null){
            switch(direction){
                case RIGHT:case LEFT:valid=car.moveHori(direction,grid);
                break;
                case UP:case DOWN:valid=car.moveVerti(direction,grid,this.getHauteur());
                break;
            }
        }
        return valid;
    }
    /**
     * compar two object of type board
     * @param o Objetc to compare
     * @return return if the Object o is equals to the board
     */       
    @Override
    public boolean equals(Object o){
        return (this.getGrid()==((Board)o).getGrid());
    }
    public String toString(){
        return ""+this.getHauteur()+""+this.getLargeur()+""+this.exit.getColumn()+""+this.exit.getRow();
    }
    
    
    
    
    
    //-------------------------------------------------------------------------
    
    
    
    // lecture dans un fichier

    public static int getHeightText(){
        File file=new File("initialiserGame.txt");
        int height=0;
        try{
            String line;
            BufferedReader buff = new BufferedReader(new FileReader(file));
            line=buff.readLine();
            char sizeRow=line.charAt(0);
            height=Character.getNumericValue(sizeRow);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return height;
    }
    public static int getWidthText(){
        File file=new File("initialiserGame.txt");
        int width=0;
        try{
            String line;
            BufferedReader buff = new BufferedReader(new FileReader(file));
            line=buff.readLine();
            char sizeColumn=line.charAt(1);
            width=Character.getNumericValue(sizeColumn);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return width;
    }
    // changer get Row et column suivant afin qu'il aille à la ligne 2
    public static int getRowExitText(){
        File file=new File("initialiserGame.txt");
        int height=0;
        try{
            String line;
            BufferedReader buff = new BufferedReader(new FileReader(file));
            line=buff.readLine();
            char sizeRow=line.charAt(0);
            height=Character.getNumericValue(sizeRow);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return height;
    }
    public static int getColumnExitText(){
        File file=new File("initialiserGame.txt");
        int width=0;
        try{
            String line;
            BufferedReader buff = new BufferedReader(new FileReader(file));
            line=buff.readLine();
            char sizeColumn=line.charAt(1);
            width=Character.getNumericValue(sizeColumn);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return width;
    }

}
