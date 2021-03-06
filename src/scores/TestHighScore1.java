package scores;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
*
*
*
*/
public class TestHighScore1 {

    private static String nickname = null;

    // Prompt the user for a Nickname
    public static void main (String [] args){
      // Ask for player's name
      System.out.print("What's your nickname ? ");
      Scanner in = new Scanner(System.in);
      nickname = in.nextLine();
      in.close();

      // Simulate score
      Integer score = chooseScore();
      // Display score
      System.out.println("Good job "+nickname+", you've done "+score+" !");
      HighScore2 h = new HighScore2();
      ArrayList<String> scores = h.getScores();
      System.out.println(scores);
    }


    // Automatically choose a random score
    private static int chooseScore() {
      ArrayList<String> t = new ArrayList<String>();

      // Opens the score file
      FileInputStream fstream = null;

      try {
        fstream = new FileInputStream(new File("assets/scoreSample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String cur;
        while ((cur = br.readLine()) != null){
          t.add(cur);
        }
        br.close();

      // Exception: File not found
      } catch (FileNotFoundException e){
        System.out.println("BUSTED ! File not found...");
        e.printStackTrace();
      // Exception: IO
      } catch (IOException e) {
        System.out.println("Uhh. An error occured reading the file...");
        e.printStackTrace();
      }

      // Return a random index of the Arraylist
      return Integer.parseInt(t.get((int)(Math.random()*t.size())));
    }
 }
