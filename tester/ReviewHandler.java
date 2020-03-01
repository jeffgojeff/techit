package project1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
//import java.util.regex;

import project1.MovieReview;





public class ReviewHandler extends AbstractReviewHandler{
    
    //had to add this to make a "dataBase" inside
    //     ReviewHandler.
    Map<Integer, MovieReview> data = getDatabase();


    @Override
    public void loadDB() throws IOException{
        int id = 0;
        String testFile2 = "./testFile.txt";
        File testFile = new File("./testFile.txt");

        String temp = "";

        try{
            File var1 = new File("./dataBase.txt");
            if(var1.createNewFile()){
                System.out.println("File created: " + var1.getName());
            }
            else{
                System.out.println("File already exists");
            }
        }
        catch (IOException e) {
            System.out.println("error");
        }

        try{
            Scanner scan = new Scanner(testFile);
            System.out.println("top: " );

            while(scan.hasNextLine()){
                temp = scan.nextLine();
                temp = temp.replaceAll("\\p{Punct}", "");
                temp = temp.toLowerCase();
                MovieReview var1 = new MovieReview(id, testFile2, temp);
                //Map<Integer, MovieReview> data = getDatabase();
                data.put(id, var1);
                System.out.println("");
                System.out.println("testing object: " + var1.getText());
                System.out.println(id);
                id++;
            }
            System.out.println("bottom:" );
        }
        catch (FileNotFoundException e) {
            System.out.println("nope");
        }

       //@Override
       //public Map<Integer, MovieReview> database;

        //System.out.println(id);            
        //System.out.println("database: " + database.text);

    }

    public void tester(){
        MovieReview var1 = data.get(0);
        System.out.println("here: " + var1.getText());
        //System.out.println("database: " + database.text);
    }
    

}