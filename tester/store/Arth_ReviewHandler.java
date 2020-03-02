package project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

public class ReviewHandler extends AbstractReviewHandler{
    @Override
    public void loadReviews(String filePath, int realClass) {
        File file = new File(filePath);
        boolean isFile = file.isFile();
        boolean isDirectory = file.isDirectory();
        int ID = 0;
        String text = "";
        String key = "Negative";int key2 = 2; // Fake vaules for review score

        if(isFile == true) { //File found and one review is loaded
            text = file.toString();
            ID = 1;
            MovieReview mr = new MovieReview(ID,filePath,text,ReviewScore.fromString(key),ReviewScore.fromInteger(key2));
        }
        else if (isDirectory == true) { // Folder was found and all reviews inside are added to the database
            //private Map<Integer, MovieReview> database;
            File folder = new File(filePath);
            File[] listOfFiles = folder.listFiles();
            for (File newFile : listOfFiles) {
                if(newFile.isFile()) {
                    text = newFile.toString();
                    ID++;
                    MovieReview mr = new MovieReview(ID,filePath,text,ReviewScore.fromString(key),ReviewScore.fromInteger(key2)); //Note** I dont know if we need to change the file path string for each file? 
                    inputIntoDatabase(ID, mr);
                }
            }

        }
        else 
            System.out.println("The fuck is this?!");
    }
    @Override
    public MovieReview readReview(String reviewFilePath, int realClass) throws IOException {
            System.out.println("Hello from read review");
            int a = 1;String b = "", c = "";String key = "Negative";int key2 = 2;
            MovieReview mr = new MovieReview(a,b,c,ReviewScore.fromString(key),ReviewScore.fromInteger(key2));
            return mr;
    }
    @Override
    public ReviewScore classifyReview(MovieReview review) {
        System.out.println("Hello from classify review");
        String key = "Negative"; return ReviewScore.fromString(key);
    }
    @Override
    public void deleteReview(int id){
        System.out.println("hello from delete review");
    }
    @Override
    public void saveDB() throws IOException {
        System.out.println("Save DB");
    }
    @Override
    public void loadDB() throws IOException{
        System.out.println("Load DB");
    }
    @Override
    public MovieReview searchById(int id) {
        System.out.println("Search by id");
            int a = 1;String b = "";String c = "";String key = "Negative";int key2 = 2;
            MovieReview mr = new MovieReview(a,b,c,ReviewScore.fromString(key),ReviewScore.fromInteger(key2));
            return mr;
    }
    @Override
    public List<MovieReview> searchBySubstring(String substring) {
        System.out.println("search by substring");
        return new ArrayList<MovieReview>();
    }
}   