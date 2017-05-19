/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rushhour;
//import static g41363.rushhour.model.Board.getHeightText;
//import static g41363.rushhour.model.Board.getWidthText;
import g41363.rushhour.model.Board;
import g41363.rushhour.model.Position;
import g41363.rushhour.model.RushHourGame;
import g41363.rushhour.model.Car;
import g41363.rushhour.model.Orientation;
import g41363.rushhour.model.RushHourException;
import static g41363.rushhour.model.Sauvegarde.iniBoard;
import static g41363.rushhour.model.Sauvegarde.iniListCar;
import static g41363.rushhour.model.Sauvegarde.sv;
import static g41363.rushhour.view.Display.displayBoard;
import g41363.rushhour.view.RushHourView;
import static g41363.rushhour.view.RushHourView.play;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Is a main methods of the Game.She create a list containing the cars,
 * initializes one RushHourGame and one RushHourView and launch the game.
 * @author G41363
 */
public class RushHour {
    /**
     * Is a main methods of the Game.She create a list containing the cars,
     * initializes one RushHourGame and one RushHourView and launch the game.
     * @throws RushHourException 
     */
    public static void main(String[] args)throws RushHourException, IOException{
        System.out.println("Veuillez choisir un Niveau de 1 à 6\n1 étant le plus"
                + " facil et 6 le plus difficil.");
        Scanner sc=new Scanner(System.in);
        String str="Niveau"+sc.nextLine();
        ArrayList<Car> listCar = iniListCar("",0,str);
        String br=iniBoard("",str);
        RushHourGame game=new RushHourGame(Integer.parseInt(""+br.charAt(0)),
                Integer.parseInt(""+br.charAt(1)),
                new Position(Integer.parseInt(""+br.charAt(3)),
                        Integer.parseInt(""+br.charAt(2))),listCar,listCar.get(0));
        RushHourView view=new RushHourView(game);
        for (Car car:listCar) {
            game.getBoard().put(car);
        }
        displayBoard(game.getBoard(),listCar.get(0));
        play();
        
        
        /* petit probleme compo niveau
        Position exit=new Position(2,5);
        ArrayList<Car> listCar = new ArrayList();
        listCar.add(new Car('1',2,Orientation.HORIZONTAL,new Position(2,2)));
        listCar.add(new Car('2',3,Orientation.VERTICAL,new Position(3,3)));
        listCar.add(new Car('3',3,Orientation.VERTICAL,new Position(4,1)));
        listCar.add(new Car('4',3,Orientation.VERTICAL,new Position(5,4)));
        listCar.add(new Car('5',2,Orientation.HORIZONTAL,new Position(1,1)));
        RushHourGame game=new RushHourGame(6,6,exit,listCar,listCar.get(0));
        
        RushHourView view=new RushHourView(game);
        for (Car car:listCar) {
            game.getBoard().put(car);
        }
        
        displayBoard(game.getBoard(),listCar.get(0));
        play();
        */
        
        
        
        /*
        listCar.add(new Car('1',2,Orientation.HORIZONTAL,posiRedCar));
        listCar.add(new Car('6',3,Orientation.VERTICAL,posiBlackCar));
        listCar.add(new Car('3',3,Orientation.VERTICAL,posiYellowCar));
        listCar.add(new Car('2',3,Orientation.VERTICAL,posiBlueCar));
        listCar.add(new Car('4',2,Orientation.HORIZONTAL,posiGreenCar));
        listCar.add(new Car('5',2,Orientation.VERTICAL,posiPinkCar));
        RushHourGame game=new RushHourGame(6,6,exit,listCar,listCar.get(0));
        */
        //RushHourGame game=new RushHourGame(getHeightText(),getWidthText(),exit,listCar,listCar.get(0));
        
        /*
        RushHourView view=new RushHourView(game);
        for (Car car:listCar) {
            game.getBoard().put(car);
        }
        displayBoard(game.getBoard(),listCar.get(0));
        play();
        */
        ///iniBoard("");
        //sv(game.getBoard(),listCar);
    }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
}