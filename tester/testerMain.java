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

            String filePath = "./Movie-reviews/neg";
            //String filePath = "./testerFile.txt";


            //rh.loadDB();
            //rh.tester();
            //rh.tester2();

            rh.loadReviews(filePath, 0);
            rh.tester();
            rh.tester2();

            /*
        } catch (IOException ex) {
            System.err.println("Error accessing the database file.");
            return;
        }
        */

    }
}