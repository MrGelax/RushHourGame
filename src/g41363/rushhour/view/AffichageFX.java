/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41363.rushhour.view;

import g41363.rushhour.model.Car;
import g41363.rushhour.model.Direction;
import g41363.rushhour.model.Orientation;
import g41363.rushhour.model.Position;
import g41363.rushhour.model.RushHourException;
import g41363.rushhour.model.RushHourGame;
import static g41363.rushhour.model.Sauvegarde.iniBoard;
import static g41363.rushhour.model.Sauvegarde.iniListCar;
import static g41363.rushhour.view.Display.displayBoard;
import static g41363.rushhour.view.RushHourView.play;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Pedro
 */
public class AffichageFX extends Application{
    public static void main(String[] args)throws RushHourException,IOException {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws RushHourException{
        stage.setTitle("Rush Hour Game");
        // remplacer par HBOX BorderPane root =new BorderPane();
        stage.getIcons().add(new Image(("file:C:\\Users\\Pedro\\Desktop\\RushHour\\g41363\\img\\RHLogo.gif"))); //pour mettre changer l'icon de la fenêtre 
        stage.setResizable(true);
        VBox root=new VBox(10);
        //root.getChildren().add(new ImageView(new Image("file:img\\parking.gif")));
        HBox hb=new HBox(10);
        GridPane gp1=new GridPane();
        ArrayList<Car> listCar=new ArrayList();
        
        //Lancement jeu
        String str="Niveau1";
        listCar = iniListCar("",0,str);
        String br=iniBoard("",str);
        RushHourGame game=new RushHourGame(Integer.parseInt(""+br.charAt(0)),
                Integer.parseInt(""+br.charAt(1)),
                new Position(Integer.parseInt(""+br.charAt(3)),
                        Integer.parseInt(""+br.charAt(2))),listCar,listCar.get(0));
        RushHourView view=new RushHourView(game);
        for (Car car:listCar) {
            game.getBoard().put(car);
        }
        
        //Hbox
        TextField tf=new TextField();
        Button bt=new Button("OK");
        hb.getChildren().addAll(tf,bt);
        /*bt.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ev){
                try {
                    RushHourView.playFX(tf,game);
                } catch (RushHourException ex) {
                }
            }
        });*/
        
        //root.getChildren().add(new ImageView(new Image("file:img\\parking.gif")));
        root.getChildren().addAll(creaGridPane(game),hb);
        Scene scn=new Scene(root);
        stage.setScene(scn);
        stage.show();   
    }
    
    public GridPane creaGridPane(RushHourGame game){
        GridPane gp1=new GridPane();
        for (int i = 0; i<game.getBoard().getGrid().length; i++) {
            for (int j=0;j<game.getBoard().getLargeur();j++) {
                //c'est bon comme façon de convertir img d'un car en image pouvant être vue dans le gp?
                ImageView img=new ImageView();
                if(game.getBoard().getGrid()[i][j]==null)
                    System.out.println("");
                else
                    img.setImage(game.getBoard().getGrid()[i][j].getImg());
                   // if(game.getBoard().getGrid()[i][j].getOrientation()==Orientation.VERTICAL)
                     //   img.setRotate(90);
                    if(game.getBoard().getGrid()[i][j]==null)
                        gp1.add(new ImageView(new Image("file:img\\vide.png")),i,j);
                    else
                        gp1.add(img,j,i);
            }
        }
        gp1.setGridLinesVisible(true);
        return gp1;
    }
}
