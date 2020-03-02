import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//import MovieReview.java;


public class tester {
    public static void main(String [] args) throws FileNotFoundException{
        int id = 0;
        File testFile = new File("./testFile.txt");

        String temp = "";

        /*
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

        */
        try{
            Scanner scan = new Scanner(testFile);
            System.out.println("top: " );
            while(scan.hasNextLine()){
                temp = scan.nextLine();
                System.out.println(temp);
                System.out.println(id);
                id++;
            }
            System.out.println("bottom:" );
        }
        catch (FileNotFoundException e) {
            System.out.println("nope");
        }

        System.out.println(id);
            
        

    }
}