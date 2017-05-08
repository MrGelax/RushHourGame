/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41363.rushhour.view;

import g41363.rushhour.model.Direction;
import g41363.rushhour.model.Orientation;
import g41363.rushhour.model.RushHourException;
import g41363.rushhour.model.RushHourGame;
import static g41363.rushhour.view.Display.*;

import java.util.Scanner;
/**
 * This class creat and manage a Objet of type RushHourView
 * @author G41363
 */
public class RushHourView {
    private static RushHourGame game;
    /**
     * initializes a RushHourGame
     * @param game RushHourGame
     */
    public RushHourView(RushHourGame game){
        this.game=game;
    }
    /**
     * Asks the player a Direction 
     * @param id Id of the car than the player want move
     * @return a Direction chosen by the player
     */
    private static Direction direction(char id){
        Scanner sc=new Scanner(System.in);
        char direction;
        Direction direct=null;
        Orientation ori = game.getBoard().getCar(id).getOrientation();
        boolean valid=false;
        do{
            System.out.println(Color.toCyan("entré le numéro de la direction choisie:"));
            System.out.print("1:Up\n"+"2:Down\n"+"3:Left\n"+"4:Right\n");
            String str=sc.nextLine();
            direction=str.charAt(0);
            if(direction=='1'||direction=='2'||direction=='3'||direction=='4'){
                switch (direction){
                        case '1':direct=Direction.UP;break;
                        case '2':direct=Direction.DOWN;break;
                        case '3':direct=Direction.LEFT;break;
                        case '4':direct=Direction.RIGHT;break;
                }
            }
            if ((ori==Orientation.HORIZONTAL&&
                (direct==Direction.RIGHT||direct==Direction.LEFT))||
                (ori==Orientation.VERTICAL&&
                (direct==Direction.UP||direct==Direction.DOWN))) {
                valid = game.getBoard().canMove(game.getBoard().getCar(id), direct);
            }
            if (!valid) {
                System.out.println("Your car can't move");
            }
        }while(!valid);
        return direct;
    }
    /**
     * This method launch the game.
     * Asks a Id of car and a Direction while the game is not win
     * @throws RushHourException RushHourException if the car is null and the id is empty
     */
    public static void play()throws RushHourException{
        Scanner sc=new Scanner(System.in);
        boolean over=false;
        do{
            System.out.print(Color.toCyan("entre a id: "));
            String str=sc.nextLine();
            char id=str.charAt(0);
            Direction direction=direction(id);
            game.move(id, direction);
            over=game.isOver();
            displayBoard(game.getBoard(),game.getRedCar());
        }while(!over);
    }
}