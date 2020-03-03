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





public class testerMain{   
    public static void main(String [] args){

        ReviewHandler rh = new ReviewHandler();

        //try {
            // Load database if it exists.

            String filePath = "./Movie-reviews/pos/";
            //String filePath = "./testerFile.txt";

            String posFilePath = "./positive-words.txt";
            String negFilePath = "./negative-words.txt";


            //rh.loadDB();
            //rh.tester();
            //rh.tester2();

            int userVar = 0;

            
            //rh.loadReviews(filePath, userVar);
            //rh.showReview();
            try{
                MovieReview var1 = rh.readReview("./Movie-reviews/pos/2_9.txt", 0);
                rh.loadPosNegWords(posFilePath, negFilePath);
                rh.classifyReview(var1);

            }
            catch(IOException e){
                System.out.println("caught");
            }
            
            







            rh.finished();

            /*
        } catch (IOException ex) {
            System.err.println("Error accessing the database file.");
            return;
        }
        */

    }
}