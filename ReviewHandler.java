package project1;

import java.io.File;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class ReviewHandler extends AbstractReviewHandler{
    

    
    public void loadReviews(String filePath, int realClass) {
        File pathFile = new File(filePath);

    }

    public MovieReview readReview(String reviewFilePath, int realClass) throws IOException {
        System.out.println("readReview");
        MovieReview tester = new MovieReview();
        return tester;
    }

    public ReviewScore classifyReview(MovieReview review) {
        System.out.println("classifyReview");
        ReviewScore tester = new ReviewScore();
        return tester;
    }

    public void deleteReview(int id){
        System.out.println("deleteReview");
    }

    public void saveDB() throws IOException {
        System.out.println("saveDB");
    }

    public void loadDB() throws IOException {
        File data = new File("./dataBase.txt");
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

        



    }

    public MovieReview searchById(int id){
        System.out.println("searchById");
        MovieReview tester = new MovieReview();
        return tester;
    }

    public List<MovieReview> searchBySubString(String substring){
        System.out.println("searchBySubString");
    }














}



