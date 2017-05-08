/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41363.rushhour.model;

import static g41363.rushhour.view.Display.displayBoard;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class Sauvegarde {
    public static void sv (Board board,ArrayList<Car> listCar,String str){
        File file = new File("Test fileWriter.txt");
        try(FileWriter fw=new FileWriter(file);FileReader fr=new FileReader(file)){
            str+=board.toString()+"\n";
            fw.write(str);
            for(Car car: listCar)
                str+=car.toStringT()+"\n";
                fw.write(str);
                System.out.println(str);
            fw.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    // oké lit bien le fichier et affiche le car créer de la bonne façon
    public static ArrayList<Car> iniListCar(String str,int i,String fichier){
        ArrayList<Car> listCar=new ArrayList();
        try(BufferedReader br=new BufferedReader(new FileReader(new File(fichier+".txt")))){
            str=br.readLine();
            while((str=br.readLine())!=null){
                if(i>=0){
                    Car cr=new Car(str);
                    listCar.add(cr);
                    System.out.println("-> "+cr.toStringT()); // A supprimer  pour la V final
                }
                i++;   
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return listCar;
    }
    
    //crée le car parfaitement
    public static String iniBoard(String str,String fichier){
        try(BufferedReader br=new BufferedReader(new FileReader(new File(fichier+".txt")))){
            str=br.readLine();
        }catch(IOException e){
                e.printStackTrace();
        }
        return str;
        //br.put(car);
        //displayBoard(br,car);
    }
}
