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
    int HS[] = {0, 0, 0};



    public String getStates(int score, long time, String GameMode) throws FileNotFoundException, IOException {
        if (time > 0) {
            return state;

        } else {

            int i = 0;
            File file = new File("hs.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                HS[i] = Integer.parseInt(sc.nextLine());
               
                i++;
            }
            if (GameMode.equals("easy")) {
                if (score > HS[0]) {
                    
                    HS[0] = score;
                    state = "HighScore";
                } else {
                    state = "GameOver";
                }
            } else if (GameMode.equals("normal")) {
                if (score > HS[1]) {
                  
                    HS[1] = score;
                    state = "HighScore";
                } else {
                    state = "GameOver";
                }
            } else {
                if (score > HS[2]) {
                    
                    HS[2] = score;
                    state = "HighScore";
                } else {
                    state = "GameOver";
                }
            }
            return state;

        }

    }

    public void updateScore() throws IOException {
        try {
            try ( FileWriter f = new FileWriter("hs.txt")) {

                for (int i = 0; i < 3; i++) {

                    f.write(HS[i] + "\n");
                }

            }

        } catch (IOException e) {
            System.out.println("An error has occured");
            e.printStackTrace();
        }
      

    }

}

// System.out.println("Hello World!");

