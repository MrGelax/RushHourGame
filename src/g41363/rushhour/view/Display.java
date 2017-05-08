/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41363.rushhour.view;

import g41363.rushhour.model.*;
import static g41363.rushhour.model.Orientation.HORIZONTAL;
import static g41363.rushhour.model.Orientation.VERTICAL;
/**
 * This class display the table set containing cars and the exit of game
 * @author Pedro
 */
public class Display {
    /**
     * Displays the table set containing cars and the exit of game
     * @param board The board of game
     */
    public static void displayBoard(Board board,Car redCar){
        System.out.print(" ------"+"\n");
        int k=0;
        for (int i=0;i<6;i++) {
            System.out.print("|");
            for (int j=0;j<6;j++) {
                if (board.getGrid()[i][j]!=null){
                    char id=board.getGrid()[i][j].getId();
                    String str=Character.toString(id);
                    displayColor(board,redCar,str,i,j);
                }else{
                    System.out.print(" ");
                }
            }
            if (board.getExit().getRow()==i) {
                System.out.print(Color.toGreen("X")+"\n");
            }else{
                System.out.print("|"+"\n");
            }
        }
        System.out.println(" ------");
    }
    public static void displayColor(Board board,Car redCar,String str,int i,int j){
        if (board.getGrid()[i][j]==board.getGrid()
                            [redCar.getCurrentPosition().getRow()]
                            [redCar.getCurrentPosition().getColumn()]) {
                        System.out.print(Color.toRed(str));       
                    }else{
                        System.out.print(Color.toBlue(str));
                    }
    }
}