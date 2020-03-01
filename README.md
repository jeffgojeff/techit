# Programming project 1: Movie Review Analysis
* Due date: Tuesday, March 3 2020, 11:59 pm

**Goal: The goal of this assignment is to help students familiarize themselves with the following Java programming concepts:**

1.	Input/Output to and from the terminal. 
2.	Storing data in a file and reading data from a file.
3.	Creating object-oriented classes and methods to handle data.
4.	Using data structures to store data in main memory (e.g. HashSet, ArrayList).
5.	Working with character strings.
6.	Using Javadoc comments and generating and html documentation of the program.
7.	Using Java Exceptions to improve the error handling capabilities of the program.

# Description:
For this assignment you will create a program to classify a set of movie reviews as positive or negative based on their sentiment. This process is known as Sentiment Analysis, and there are multiple approaches to analyze the data and estimate the sentiment. More information about sentiment analysis can be found on Wikipedia and other sources.
https://en.wikipedia.org/wiki/Sentiment_analysis 

In this assignment, you are to write a Java program that will classify a review as positive or negative by counting the number of positive and negative words that appear in that review.  

# Program flow

## Step 1: Start the program

Your program will have two inputs as command line arguments, which are the paths to two text files:  the list of positive words (positive-words.txt) and the list of negative words (negative-words.txt). The program loads the positive words and negative words and stores them in two separate lookup tables. The HashSet data structure can be used as a lookup table in Java as it provides a fast way to look if a word exists in it or not.

Run example (assumes data directory is under material.git checked out in the same directory as src.git):

```
javac -d classes ./NET_ID/project1/*.java

java -cp classes project1.MovieReviewApp ./material/data/positive-words.txt ./material/data/negative-words.txt
```
## Step 2: Load existing database of movie reviews

Every time your program loads, it should first check if there exists a database file (database.txt) in its working directory. If such a file exists, it should load its contents (movie reviews) into the main memory (a HashMap can be used).


## Step 3: Present the user with an interaction menu

0. Exit program.
1. Load new movie review collection (given a folder or a file path).
2. Delete movie review from database (given its id).
3. Search movie reviews in database by id or by matching a substring.

## Step 4: When the user selects “0”, save the database file and exit the program.

# Notes: 

* The above interaction menu should be coded in a loop, so that the user can choose among the different options multiple times, until they choose option “0”, in which case the program terminates.
* Every time your program loads, it should first check if there exists a database file in its working directory. If such a file exists, it should load its contents (movie reviews) into the main memory (a HashMap can be used). If the database file does not exist, an empty HashMap will be created. When the program exits (user selects action “0”), it should save the new database contents back to the database file, replacing the old one.
* When the user selects option “1”:
  * The program should also ask the user to provide the real class of the review collection (if known). The user can choose from the options: 0. Negative, 1. Positive, and 2. Unknown. 
  * Upon loading each review, your program should assign a unique ID to each review, which should not conflict with existing ones, and it should also assign the value of the real class (as provided by the user). 
  * Then the program should automatically classify each review, as positive or negative by counting the number of positive and negative words that appear in that review and assign a value to the “predictedClass” field of each review. The overall classification accuracy should also be reported, if the real class is known.
  * Finally, the newly loaded reviews should be added to the permanent database.
  * When the user selects option “3”, the results should be printed in a formatted manner. The printed information should be a table with each row showing: review ID, first 50 characters of review text, predicted class, real class.

# Implementation hints:

Java provides the method split() which allows us to split a String into multiple tokens by specifying a separator character. 
E.g.
String animals = "dog cat bear elephant giraffe";
String[] animalsArray = animals.split("\\s+");

* For each review:
  * Step 0: Open .txt file.
  * Step 1: Remove punctuation marks using regex \p{Punct} https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html e.g. review = review.replaceAll(“\\p{Punct}”, “”);
  * Step 2: Convert everything to lower case.
  * Step 3: Tokenize (split) review using white space as separating character.
  * Step 4: Count the number of positive and negative words.
  * Step 5: Close .txt file.

# Tasks:
1.	Extend the given code in src.git under project1 to create and object-oriented Java program that implements the functionality described above.  Make use of the inheritance and polymorphism concepts that we saw in class.  
2.	Try to make your program as robust as possible, by using Exception handling to deal with possible problems that may occur during the program execution. 
3.	Use javadoc comments for all of your classes and methods.


# Logistics:
* This assignment should be completed by individually or in pairs: if in pairs, please indicate in the @author tag
* The provided code should be cloned (first time) or pulled from https://git.txstate.edu/CS3354/src  according to the instructions provided in class (project/project1 folder), see README.md for more details
* The completed code should be pushed to <NET_ID>
  * Do NOT include executable .class or .jar files in your submission. Only .java files.
* You may use an IDE (VS Code, IntelliJ, Netbeans, etc) or just an editor and command line operations (javac, java) in Unix or Windows/DOS to develop your program.
* Use good design (don’t put everything in one class).
* Use a package project1 for your classes and put your files in the appropriate directory structure.
* Use a standard Java coding style to improve your program’s visual appearance and make it more readable, e.g. Google Java style guide: https://google.github.io/styleguide/javaguide.html 


