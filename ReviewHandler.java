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
    
    Map<Integer, MovieReview> data = getDatabase();

    //ReviewScore dummyValue = new ReviewScore(0);


    public void loadReviews(String filePath, int realClass) {
        File pathFile = new File(filePath);

    }

    
    public MovieReview readReview(String reviewFilePath, int realClass) throws IOException {
        System.out.println("readReview");
        MovieReview tester = new MovieReview(0, " ", " ", dummyValue, dummyValue );
        return realClass;
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


    //this should load all the values from dataBase.txt
    //into data <- which is our hashmap
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

        //verified with the files in tester that this works
        //with multiple lines in the database.txt file
        //and removes all punctuation and sets everything to 
        //lowerCase before storing in our data hashSet.
        try{
            Scanner scan = new Scanner(testFile);
            while(scan.hasNextLine()){
                temp = scan.nextLine();
                temp = temp.replaceAll("\\p{Punct}", "");
                temp = temp.toLowerCase();
                MovieReview var1 = new MovieReview(id, testFile2, temp);
                data.put(id, var1);
                id++;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("nope");
        }

        



    }

    public MovieReview searchById(int id){
        System.out.println("searchById");
        MovieReview tester = new MovieReview();
        return tester;
    }

    @Override
    public List<MovieReview> searchBySubString(String substring){
        System.out.println("searchBySubString");
    }

    public void tester(){
        MovieReview var1 = data.get(0);
        System.out.println("here: " + var1.getText());
    }














}



