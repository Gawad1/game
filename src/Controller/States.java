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
    String state="Progress";
    public String getStates(int score,int time)throws FileNotFoundException, IOException{
    if(time>0)
        return state;
    else {
    int HS;
    File file = new File("/hs.txt");
    Scanner sc = new Scanner(file);
    HS=Integer.parseInt(sc.nextLine());
    if(score>HS){
       HS=score;
       state="HighScore";
    }
    else{
        state="GameOver";
    }
    FileWriter fr = new FileWriter("hello.txt");
    BufferedWriter br = new BufferedWriter(fr);
    br.write(HS);
    return state;
    }
}
