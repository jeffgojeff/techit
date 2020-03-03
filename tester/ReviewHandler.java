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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.lang.String;

public class ReviewHandler extends AbstractReviewHandler{
    
    




    
    @Override

    public void loadReviews(String filePath, int realClass) {
         
        File file = new File(filePath);
        System.out.println("starting: ");

        if(file.isFile()) { //File found and one review is loaded
            //catch the ioexception if thrown from readReview here
            try{
                //readReview returns a movieReivew object
                MovieReview var1 = readReview(filePath, realClass);
                //store than in the dataBase
                getDatabase().put(getReviewIdCounter(), var1);
                //increment id before proceeding
                setReviewIdCounter(getReviewIdCounter() + 1);
            }
            catch(IOException e){
                return;
            }
        }

        else if (file.isDirectory()) { // Folder was found and all reviews inside are added to the database
            
            System.out.println("isDir: ");
            String[] reviewFiles = file.list();

            for(int i=0; i < reviewFiles.length; i++){
                try{
                    System.out.println("path: " + reviewFiles[i]);
                    MovieReview var1 = readReview((filePath + reviewFiles[i]), realClass);
                    //store than in the dataBase
                    getDatabase().put(getReviewIdCounter(), var1);
                    //System.out.println("text: " + getDatabase().get(i).getText());
                    //System.out.println("ID: " + getDatabase().get(i).getId());
                    //System.out.println("");
                    //increment id before proceeding
                    setReviewIdCounter(getReviewIdCounter() + 1);
                }
                catch(IOException e){
                    return;
                }

            }
        }
    }


    @Override
    public MovieReview readReview(String reviewFilePath, int realClass) throws IOException {
               
        File var2 = new File(reviewFilePath);
        //System.out.println("testing: " + var2);

        if(var2.exists()){
            //System.out.println("testing inside: ");
            Scanner scan = new Scanner(var2);
            String temp = "";

            while(scan.hasNextLine()){
                temp = scan.nextLine();
                temp = temp.replaceAll("\\p{Punct}", "");
                temp = temp.toLowerCase();
                //System.out.println("readReview: " + temp);
                MovieReview var1 = new MovieReview(getReviewIdCounter(), reviewFilePath, temp, ReviewScore.fromString("Unknown"),ReviewScore.fromInteger(realClass));
                classifyReview(var1);
                return var1;
            }            
        }

        return null;
    }




    @Override
    public ReviewScore classifyReview(MovieReview review) {

        int pos = 0;
        int neg = 0;
        //int count = 0;

        //System.out.println("getPositive: " + getPosWords());

        //System.out.println("testing: " + review.getText());
        String[] arr1 = review.getText().split(" ");

         for(int i=0; i < arr1.length; i++) {
            if(getPosWords().contains(arr1[i])){
                pos++;
                //System.out.println("pos: " + pos);
            }

            if(getNegWords().contains(arr1[i])){
                neg++;
                //System.out.println("neg: " + neg);
            }
            //count++;
        }
        //System.out.println("count: " + count);


        if(pos == neg)
            review.setPredictedScore(ReviewScore.fromInteger(2));
        
        else if(pos > neg)
            review.setPredictedScore(ReviewScore.fromInteger(1));

        else if (neg < pos)
            review.setPredictedScore(ReviewScore.fromInteger(0));

        System.out.println("enum: " + review.getPredictedScore());
        
        return null;
    
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
        
        try{
            
            File var2 = new File(DATA_FILE_NAME);
            if(var2.exists()){
                Scanner scan = new Scanner(var2);
                //System.out.println("top: " );
                String temp = "";

                while(scan.hasNextLine()){
                    temp = scan.nextLine();
                    temp = temp.replaceAll("\\p{Punct}", "");
                    temp = temp.toLowerCase();
                    String key = "Negative";int key2 = 2;
                    MovieReview var1 = new MovieReview(getReviewIdCounter(), DATA_FILE_NAME, temp, ReviewScore.fromString(key),ReviewScore.fromInteger(key2));
                    getDatabase().put(getReviewIdCounter(), var1);
                    setReviewIdCounter(getReviewIdCounter() + 1);
                }
                //System.out.println("bottom:" );
            }
        }

        catch (FileNotFoundException e) {
            return;
        }
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





    // my functions

    public void finished(){
        System.out.println("program finished..");
    }






}




