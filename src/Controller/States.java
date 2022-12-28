package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class States {

    public String state = "Progress";
    int HS=0;
    public String getStates(int score, long time) throws FileNotFoundException, IOException {
        if (time > 0) {
            return state;
        } 
        else 
        {
            
            
            File file=new File("/hs.txt");
             Scanner sc = new Scanner(file);
            HS = Integer.parseInt(sc.nextLine());
             if (score > HS) {
                HS = score;
                state = "HighScore";
            } else {
                state = "GameOver";
            }
             FileWriter fr = new FileWriter("hs.txt");
          // BufferedWriter br = new BufferedWriter(fr);
            fr.write(HS);
            return state;
        }    
        
             
        }
    }

            // System.out.println("Hello World!");
  
    
           
        
    

