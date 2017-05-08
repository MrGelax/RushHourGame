/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41363.rushhour.view;

import g41363.rushhour.model.Car;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Pedro
 */
public class AffichageFX extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage){
        stage.setTitle("Rush Hour Game");
        // remplacer par HBOX BorderPane root =new BorderPane();
        stage.getIcons().add(new Image(("file:sante.jpg"))); //pour mettre changer l'icon de la fenêtre 
        stage.setResizable(false);
        VBox root=new VBox(10);
        ArrayList<Car> listCar=new ArrayList();
        List<Button> bt=creaButon(listCar);
        
        Scene scn=new Scene(root);
        stage.setScene(scn);
        stage.show();   
    }
    public GridPane creaGridPane(ArrayList<Button> but){
        GridPane gp=new GridPane();
        
        
        return gp;
    }
    public List<Button> creaButon(ArrayList<Car> listCar){
        List<Button> listBut=new ArrayList();
        int i=0;
        for (Car car:listCar) {
            listBut.add(new Button(""+car.getId()));
        }
        return listBut;
    }
}
