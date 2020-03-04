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
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * CS3354 Spring 2020 Review Handler Class specification
    @author Arthur Hatgis
    @author Jeffrey Slocum 
 */
public class ReviewHandler extends AbstractReviewHandler{
    /**
     * Given the file path, it checks if it leads to a folder or a single review.
     * If the given path is a .txt file, then a single review is loaded. 
     * Otherwise, if the path is a folder, all reviews in it are loaded.
     * This method calls the method classifyReview to classify each review.
     * @param filePath The path to the file (or folder) containing the review.
     * @param realClass The real class of the review (0 = Negative, 1 = Positive
     * 2 = Unknown).
     */
    @Override
    public void loadReviews(final String filePath, final int realClass) {

        final File file = new File(filePath); // sets file to a variable

        // File found and one review is loaded
        if (file.isFile()) {
            // catch the ioexception if thrown from readReview here
            try {
                // readReview returns a movieReivew object
                final MovieReview var1 = readReview(filePath, realClass);
                // store than in the dataBase
                getDatabase().put(getReviewIdCounter(), var1);
                // increment id before proceeding
                setReviewIdCounter(getReviewIdCounter() + 1);
            } catch (final IOException e) {
                return;
            }
        }

        // Folder was found and all reviews inside are added to the database
        else if (file.isDirectory()) {

            final String[] reviewFiles = file.list(); // creates a string array of file pathways

            for (int i = 0; i < reviewFiles.length; i++) {
                try {
                    final MovieReview var1 = readReview((filePath + reviewFiles[i]), realClass);
                    // store than in the dataBase
                    getDatabase().put(getReviewIdCounter(), var1);
                    // increment id before proceeding
                    setReviewIdCounter(getReviewIdCounter() + 1);
                } catch (final IOException e) {
                    return;
                }
            }
        }
    }

    /**
     * Reads a single review file and returns it as a MovieReview object.
     * 
     * @param reviewFilePath A path to a .txt file containing a review.
     * @param realClass      The real class entered by the user.
     * @return a MovieReview object.
     * @throws IOException if specified file cannot be opened.
     */
    @Override
    public MovieReview readReview(final String reviewFilePath, final int realClass) throws IOException {

        final File var2 = new File(reviewFilePath); // sets file to a variable

        if (var2.exists()) {
            final Scanner scan = new Scanner(var2);
            String temp = "";

            // reading and organzing the text to be read by the program
            while (scan.hasNextLine()) {
                temp = scan.nextLine();
                temp = temp.replaceAll("\\p{Punct}", "");
                temp = temp.toLowerCase();
                final MovieReview var1 = new MovieReview(getReviewIdCounter(), reviewFilePath, temp,
                        ReviewScore.fromInteger(realClass), ReviewScore.fromString("Unknown"));
                classifyReview(var1);
                return var1; // returns a class object to be loaded into database
            }
        }
        return null;
    }

    /**
     * Classifies a review as negative, or positive by using the text of the review.
     * It updates the predictedPolarity value of the review object and it also
     * returns the predicted polarity. Note: the classification is achieved by
     * counting positive and negative words in the review text.
     * 
     * @param review A review object.
     * @return 0 = negative, 1 = positive.
     */
    @Override
    public ReviewScore classifyReview(final MovieReview review) {

        int pos = 0;
        int neg = 0;

        final String[] arr1 = review.getText().split(" "); // create a array of words from the text

        // searching to matching positve / negtaive words
        for (int i = 0; i < arr1.length; i++) {
            if (getPosWords().contains(arr1[i]))
                pos++;
            if (getNegWords().contains(arr1[i]))
                neg++;
        }

        // Depending on the count of words match, it will predict if the review was
        // negative or postive
        if (pos == neg)
            review.setPredictedScore(ReviewScore.fromInteger(2));
        else if (pos > neg)
            review.setPredictedScore(ReviewScore.fromInteger(1));
        else if (neg > pos)
            review.setPredictedScore(ReviewScore.fromInteger(0));

        return null;
    }

    /**
     * Deletes a review from the database, given its id.
     * 
     * @param id The id value of the review.
     */
    @Override
    public void deleteReview(final int id) {
        getDatabase().remove(id);
    }

    /**
     * Saves the database in the working directory as a text file (database.txt)
     * 
     * @throws java.io.IOException
     */
    @Override
    public void saveDB() throws IOException {

        final PrintWriter out = new PrintWriter(DATA_FILE_NAME);
        for (final MovieReview mr : getDatabase().values()) {
            out.println(mr.getFilePath());
            out.println(mr.getPredictedScore());
            out.println(mr.getRealScore());
        }

        close(out);

    }

    /**
     * Loads review database from a file into the HashMap.
     * 
     * @throws java.io.IOException
     */
    @Override
    public void loadDB() throws IOException {

        try {
            final File var2 = new File(DATA_FILE_NAME);
            if (var2.exists()) {
                final Scanner scan = new Scanner(var2);
                String temp = "";
                String real = "";
                String pred = "";
                int realInt = 2;

                // reading and organzing the text to be read by the program
                while (scan.hasNextLine()) {
                    
                    temp = scan.nextLine().toLowerCase();
                    real = scan.nextLine();
                    pred = scan.nextLine();
                    
                    if(real == "negative")
                        realInt = 0;
                    if(real == "positive")
                        realInt = 1;

                    MovieReview var1 = readReview(temp, realInt);
                    var1.setPredictedScore(ReviewScore.fromString(pred));

                    getDatabase().put(getReviewIdCounter(), var1);
                    setReviewIdCounter(getReviewIdCounter() + 1);
                }
            }
        }

        catch (final FileNotFoundException e) {
            return;
        }
    }

    /**
     * Searches the review database by id.
     * 
     * @param id The id to search for.
     * @return The review that matches the given id or null if the id does not exist
     *         in the database.
     */
    @Override
    public MovieReview searchById(final int id) {
        return getDatabase().get(id);
    }

    /**
     * Searches the review database for reviews matching a given substring.
     * @param substring The substring to search for.
     * @return A list of review objects matching the search criterion.
     */
    @Override
    public List<MovieReview> searchBySubstring(final String substring) {

        final List list = new ArrayList<MovieReview>();

        for(int i=0; i < getDatabase().size(); i++){
                list.add(getDatabase().get(i));
            }

        return list;     
    }
}