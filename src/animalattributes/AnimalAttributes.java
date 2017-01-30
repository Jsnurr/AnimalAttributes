package animalattributes;

import java.io.*;

/**
 * Author: John D. Snurr
 * Date: December 5, 2016
 */

public class AnimalAttributes 
{    
    public static void main(String[] args) 
    {
        try { // Try statement to catch NIO exceptions
            File animalText = new File("AnimalList.txt"); // Declare and initialize AnimalList.txt reference
            animalText.createNewFile(); // Create new AnimalList.txt
        } catch (IOException e) { // Catch any IOExceptions
            // System.out.println("IOExcpetion while reading from file!"); // Notify the developer of the issue
        } 
        
        AnimalManipulation animalDatabase = new AnimalManipulation(); // Declare and instantiate AnimalManipulation reference
        animalDatabase.readAnimalList(); // Read the animalList.txt by calling readAnimalList()
        animalDatabase.animalMenu(); // Call animalMenu() to present menu to user
        animalDatabase.writeAnimalList(); // Write the animalList.txt by calling writeAnimalList()
    }
}

/**
 * Author: John D. Snurr
 * Date: December 5, 2016
 */