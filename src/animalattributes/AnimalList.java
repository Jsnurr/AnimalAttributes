package animalattributes;

import java.io.*;
import java.util.*; // Import java utility package for ArrayList

/**
 * Author: John D. Snurr
 * Date: December 5, 2016
 */

public class AnimalList // Singleton class to limit application to a single ArrayList for manipulation
{
    private static final AnimalList SINGLETON_ANIMALLIST = new AnimalList(); // Declare and instantiate encapsulated reference to AnimalList
    private final ArrayList<Animal> animalArray; // Declare encapsulated final ArrayList to hold animal objects
    
    private AnimalList() // Private constructor for AnimalList
    {
        animalArray = new ArrayList<>(); // Initialize ArrayList for animals
    }
    
    public static AnimalList getAnimalList() // Accessor for AnimalList reference
    {
        return SINGLETON_ANIMALLIST; // Return SINGLETON_ANIMALLIST to caller
    }
    
    public ArrayList getAnimalArray() // Accessor for animalArray
    {
        return animalArray; // Return ArrayList holding animal data
    }
}

class Animal // Animal object to be used for data input
{
    private String name, type, diet, habitat, size; // Declare encapsulated class variables 
    private boolean isEndangered, canFly, canSwim;  // to hold animal attributes
    
    /* ---------------------------------
     * ---------- ACCESSORS ------------
     * --------------------------------- */
    public String getName() // Accessor for animal name
    {
        return name; // Return the name of the animal
    }
    
    public String getType() // Accessor for animal type
    {
        return type; // Return the type of animal (Mammal, Reptile, Bird, Insect, Arachnids, Aquatic Animal)
    }
    
    public String getDiet() // Accessor for animal diest
    {
        return diet; // Return the diet of the animal (carnivore, herbivore, omnivore)
    }
    
    public String getHabitat() // Accessor for animal habitat
    { 
        return habitat; // Return habitat of the animal (Desert, Grasslands, Forests, Mountains, Freshwater, Oceans, Tundra)
    }
    
    public String getSize() // Accessor for animal size 
    {
        return size; // Return animal size (small, medium, large)
    }
    
    public boolean getIsEndangered() // Accessor for endangerment
    {
        return isEndangered; // Return animal endangerment status
    }
    
    public boolean getCanFly() // Accessor for animal ability to fly
    {
        return canFly; // Return animal flight capabilities
    }
    
    public boolean getCanSwim() // Accessor for animal ability to swim
    {
        return canSwim; // Return animal swimming capabilities
    }
    
    /* ---------------------------------
     * ----------- MUTATORS ------------
     * --------------------------------- */
    public void setName(String animalName) // Mutator for animal name variable
    {
        name = animalName; // Assign method parameter as the name
    }
    
    public void setType(String animalType) // Mutator for animal type variable
    {
        // If the method parameter is one of the accepted animal types...
        if (animalType.equalsIgnoreCase("Mammal") || animalType.equalsIgnoreCase("Reptile") ||
                animalType.equalsIgnoreCase("Bird") || animalType.equalsIgnoreCase("Insect") ||
                animalType.equalsIgnoreCase("Arachnid") || animalType.equalsIgnoreCase("Aquatic"))
        {
            type = animalType; // assign the method parameter as the type
        }
    }
    
    public void setDiet(String animalDiet) // Mutator for animal diet variable
    {
        // If the method parameter is one of the accepted animal diets...
        if (animalDiet.equalsIgnoreCase("Carnivore") || animalDiet.equalsIgnoreCase("Herbivore") ||
                animalDiet.equalsIgnoreCase("Omnivore"))
        {
            diet = animalDiet; // assign the method parameter as the diet
        }
    }
    
    public void setHabitat(String animalHabitat) // Mutator for animal habitat variable
    {
        // If the method parameter is one of the accepted animal habitats...
        if (animalHabitat.equalsIgnoreCase("Desert") || animalHabitat.equalsIgnoreCase("Grasslands") ||
                animalHabitat.equalsIgnoreCase("Forest") || animalHabitat.equalsIgnoreCase("Mountains") ||
                animalHabitat.equalsIgnoreCase("Freshwater") || animalHabitat.equalsIgnoreCase("Ocean") ||
                animalHabitat.equalsIgnoreCase("Tundra"))
        {
            habitat = animalHabitat; // assign the method parameter to the habitat
        }
    }
    
    public void setSize(String animalSize) // Mutator for animal size variable 
    {
        // If the method parameter is one of the accepted animal sizes...
        if (animalSize.equalsIgnoreCase("Small") || animalSize.equalsIgnoreCase("Medium") ||
                animalSize.equalsIgnoreCase("Large"))
        {
            size = animalSize; // assign the method parameter to the size
        }
    }
    
    public void setIsEndangered(boolean endangerment) // Mutator for animal isEndangered boolean
    {
        isEndangered = endangerment; // assign method parameter to isEndangered
    }
    
    public void setCanFly(boolean hasFlight) // Mutator for animal canFly boolean
    {
        canFly = hasFlight; // assign method parameter to canFly
    }
    
    public void setCanSwim(boolean isAquatic) // Mutator for animal canSwim boolean
    {
        canSwim = isAquatic; // assign parameter to canSwim
    }
}

class AnimalManipulation // Class containing the add, edit, delete, and search methods for the animal ArrayList
{
    // INSTANCE VARIABLES USED WITHIN EACH METHOD
    AnimalList currentList = AnimalList.getAnimalList(); // Delcare and instantiate reference to current AnimalList
    ValidateInput validation = new ValidateInput(); // Declare and instantiate reference to ValidateInput to validate user input
    Animal tempAnimal = new Animal(); // Declare and instantiate reference to Animal to store user input
        
    String tempInput; // Declare String to temporarily store user input (name, type, diet, habitat, size)
    boolean tempBoolean; // Declare boolean to temporarily store user input (endangered, flight, swimming)
    
    public void animalMenu()
    {
        do { // Do-while loop to prompt user for actions and manipulate animal ArrayList
            
            System.out.println("\n----------- WELCOME TO THE ANIMAL DATABASE ----------");  // Display welcome message to the user
            String consoleMessage = "What would you like to do (Add, Edit, Delete, Search, End)? "; // Display options to user 
            tempInput = validation.validateString(consoleMessage, false); // Validate user input
            
            AnimalManipulation arrayModifications = new AnimalManipulation(); // Declare and instantiate new AnimalManipulation reference
        
            switch(tempInput.toLowerCase()) // Switch statement used to navigate options based upon user input
            {
                case "add": // If user wants to add an animal
                    System.out.println("\n----------- ADD AN ANIMAL TO THE DATABASE ----------"); // Display the add message to the user
                    arrayModifications.addAnimal(); // Call the addAnimal() of the AnimalManipulation class
                    break; // Break out of switch statement and return to the welcome message
                case "edit": // If user wants to edit an animal
                    System.out.println("\n----------- EDIT AN ANIMAL IN THE DATABASE ----------"); // Display the edit message to the user
                    arrayModifications.editAnimal(); // Call the editAnimal() of the AnimalManipulation class
                    break; // Break out of switch statement and return to the welcome message
                case "delete": // If user wants to delete an animal
                    System.out.println("\n----------- DELETE AN ANIMAL IN THE DATABASE ----------"); // Display the deletion message to the user
                    arrayModifications.deleteAnimal(); // Call the deleteAnimal() of the AnimalManipulation class
                    break; // Break out of switch statement and return to the welcome message
                case "search": // If user wants to search for an animal
                    System.out.println("\n----------- SEARCH FOR AN ANIMAL IN THE DATABASE ----------"); // Display the search message to the user
                    arrayModifications.searchAnimal(); // Call the searchAnimal() of the AnimalManipulation class
                    break; // Break out of switch statement and return to the welcome message
            }
            
        } while (!tempInput.equalsIgnoreCase("End")); // If the user inputs the word "end," exit the application
    }
        
    public void addAnimal() // addAnimal() prompts user to add an animal and its attributes to the ArrayList
    {       
        String nameMessage = "\nPlease enter the name of the animal: "; // Create String message to send to validateString()
        tempAnimal.setName(validation.validateString(nameMessage, false)); // Call validateString() to validate name (numbers are not accepted)
        
        for (Iterator it = currentList.getAnimalArray().iterator(); it.hasNext();) // For loop to iterate through currentList AnimalArray
        { 
            Animal compareAnimal = (Animal)it.next(); // Cast the next object in the AnimalArray to type Animal and assign it to a new Animal
            String tempName = compareAnimal.getName(); // Assign the name of the current AnimalArray position to a new String
            
            tempBoolean = tempAnimal.getName().equalsIgnoreCase(tempName); // Compare the name the user input with each name in the currentList
            
            if(tempBoolean) // If the name matches the current next() name...
                break; // end the for loop and move to the below if statement
        }
        
        if(!tempBoolean) // If the above name check passes...
        {
            do { // Do-while loop to gather animal type from user
            
                String typeMessage = "Please enter the type of animal (Mammal, Reptile, Bird, Insect, Arachnid, or Aquatic): "; // Create String message to send to validateString()
                tempInput = validation.validateString(typeMessage, false); // Call validateString() to validate type (numbers are not accepted)
            
            } while (!tempInput.equalsIgnoreCase("Mammal") && !tempInput.equalsIgnoreCase("Reptile") &&
                !tempInput.equalsIgnoreCase("Bird") && !tempInput.equalsIgnoreCase("Insect") &&
                !tempInput.equalsIgnoreCase("Arachnid") && !tempInput.equalsIgnoreCase("Aquatic")); // End the do-while loop when the user inputs an accepted String
            
            tempAnimal.setType(tempInput); // Assign the user input to the type attribute of the tempAnimal
        
            do { // Do-while loop to gather animal diet from user
                
                String dietMessage = "Please enter the diet of the animal (Carnivore, Herbivore, or Omnivore): "; // Create String message to send to validateString()
                tempInput = validation.validateString(dietMessage, false); // Call validateString() to validate diet (numbers are not accepted)
                
            } while (!tempInput.equalsIgnoreCase("Carnivore") && !tempInput.equalsIgnoreCase("Herbivore") &&
                !tempInput.equalsIgnoreCase("Omnivore")); // End the do-while loop when the user inputs an accepted String
            
            tempAnimal.setDiet(tempInput); // Assign the user input to the diet attribute of the tempAnimal
            
            do { // Do-while loop to gather animal habitat from user
                
                String habitatMessage = "Please enter the habitat of the animal (Desert, Grasslands, Forest, Mountains, " +
                        "Freshwater, Ocean, or Tundra): "; // Create String message to send to validateString()
                tempInput = validation.validateString(habitatMessage, false); // Call valiadteString() to validate habitat (numbers are not accepted)
                
            } while (!tempInput.equalsIgnoreCase("Desert") && !tempInput.equalsIgnoreCase("Grasslands") &&
                !tempInput.equalsIgnoreCase("Forest") && !tempInput.equalsIgnoreCase("Mountains") &&
                !tempInput.equalsIgnoreCase("Freshwater") && !tempInput.equalsIgnoreCase("Ocean") &&
                !tempInput.equalsIgnoreCase("Tundra")); // End the do-while loop when the user inputs an accepted String
            
            tempAnimal.setHabitat(tempInput); // Assign the user input to the habitat attribute of the tempAnimal
            
            do { // Do-while loop to gather animal size from user
                
                String sizeMessage = "Please enter the size category of the animal (Small, Medium, or Large): "; // Create String message to send to validateString()
                tempInput = validation.validateString(sizeMessage, false); // Call validateString() to validate size (numbers are not accepted)
                
            } while (!tempInput.equalsIgnoreCase("Small") && !tempInput.equalsIgnoreCase("Medium") &&
                !tempInput.equalsIgnoreCase("Large")); // End the do-while loop when the user inputs an accepted String
            
            tempAnimal.setSize(tempInput); // Assign the user input to the size attribute of the tempAnimal
            
            do { // Do-while loop to gather animal endangerment status from user
                
                String endangeredMessage = "Is the animal an endangered species (Yes or No)? "; // Create String message to send to validateString()
                tempInput = validation.validateString(endangeredMessage, false); // Call validateString() to validate endangered status (numbers are not accepted)
                
                tempBoolean = tempInput.equalsIgnoreCase("Yes"); // Call equalsIgnoreCase() to decipher user input
                
            } while(!tempInput.equalsIgnoreCase("Yes") && !tempInput.equalsIgnoreCase("No")); // End do-while loop when the user inputs an accepted String
            
            tempAnimal.setIsEndangered(tempBoolean); // Assign tempBoolean to isEndangered attribute of the tempAnimal
            
            do { // Do-while loop to gather animal flight capabilites from user
                
                String flightMessage = "Is the animal capable of flight (Yes or No)? "; // Create String message to send to validateString()
                tempInput = validation.validateString(flightMessage, false); // Call validateString() to validate flight capabilites (numbers are not accepted)
                
                tempBoolean = tempInput.equalsIgnoreCase("Yes"); // Call equalsIgnoreCase() to decipher user input
                
            } while (!tempInput.equalsIgnoreCase("Yes") && !tempInput.equalsIgnoreCase("No")); // End do-while loop when the user inputs an accepted String
            
            tempAnimal.setCanFly(tempBoolean); // Assign tempBoolean to canFly attribute of the tempAnimal
            
            do { // Do-while loop to gather animal swimming capabilities from user
                
                String swimMessage = "Is the animal capable of swimming (Yes of No)? "; // Create String message to send to validateString
                tempInput = validation.validateString(swimMessage, false); // Call validateString() to validate swimming capabilities (numbers are not accepted)
                
                tempBoolean = tempInput.equalsIgnoreCase("Yes"); // Call equalsIgnoreCase() to decipher user input
                
            } while (!tempInput.equalsIgnoreCase("Yes") && !tempInput.equalsIgnoreCase("No")); // End do-while loop when the user inputs an accepted String
            
            tempAnimal.setCanSwim(tempBoolean); // Assign tempBoolean to canSwim attribute of the tempAnimal
            
            tempAnimal = attributeToUppercase(tempAnimal); // Call attributeToUppercase to convert all input attributes to uppercase to make output more readable
            currentList.getAnimalArray().add(tempAnimal); // Get the animalArray of the currentList and add the current tempAnimal
        }
        else // If the animal already exists in the currentList...
        {
            System.out.println("That animal already exists in the list."); // Display the message to the user
        }
    }

    public void editAnimal() // editAnimal() prompts user to edit an animal and its attributes
    {
        for (Iterator it = currentList.getAnimalArray().iterator(); it.hasNext();) // For loop to iterate through currentList AnimalArray 
        {                                                                          // and display the animals it contains
            tempAnimal = (Animal)it.next(); // Cast current object in list to Animal type and assign to tempAnimal
            System.out.println(tempAnimal.getName()); // Display tempAnimal name
        }
        
        String editMessage = "\nWhich animal would you like to edit? "; // Create String message to send to validateString
        tempInput = validation.validateString(editMessage, false); // Call validateString() to validate animal name (numbers are not allowed)
        
        
        for (Iterator it = currentList.getAnimalArray().iterator(); it.hasNext();) // For loop to iterate through currentList AnimalArray
        {
            tempAnimal = (Animal)it.next(); // Cast current object in list to Animal tupe and assign to tempAnimal
            
            if (tempAnimal.getName().equalsIgnoreCase(tempInput)) // If the name of the tempAnimal is equal to the name the user input...
            {
                String attributeMessage = "Which attribute would you like to edit " +
                        "(Name, Type, Diet, Habitat, Size, Endangerment, Flight, or Swimming): "; // Prompt user to select an attribute to edit
                tempInput = validation.validateString(attributeMessage, false); // Call validateString to validate attribute (numbers are not allowed)
                
                switch (tempInput.toLowerCase()) // Switch statement to determine attribute to edit
                {
                    case "name": // If the user wants to change the animals name
                        String nameMessage = "Please enter the name of the animal: "; // Create String message to send to validateString
                        tempAnimal.setName(validation.validateString(nameMessage, false)); // Call validateString() to validate name before assigning to tempAnimal name
                        break; // Break out of the editing menu
                    case "type": // If the user wants to change the animals type
                        System.out.println("Current type: " + tempAnimal.getType()); // Display the animals current type to the user
                        
                        do { // Do-while loop to gather new animal type from user
            
                            String typeMessage = "Please enter the type of animal (Mammal, Reptile, Bird, Insect, Arachnid, or Aquatic): "; // Create String message to send to validateString
                            tempInput = validation.validateString(typeMessage, false); // Call validateString() to validate type before assigning to tempAnimal type
            
                        } while (!tempInput.equalsIgnoreCase("Mammal") && !tempInput.equalsIgnoreCase("Reptile") &&
                            !tempInput.equalsIgnoreCase("Bird") && !tempInput.equalsIgnoreCase("Insect") &&
                            !tempInput.equalsIgnoreCase("Arachnid") && !tempInput.equalsIgnoreCase("Aquatic")); // End do-while loop when user inputs an accepted String
            
                        tempAnimal.setType(tempInput); // Assign new type to tempAnimal type
                        break; // Break out of the editing menu
                    case "diet": // If the user wants to change the animals diet
                        System.out.println("Current diet: " + tempAnimal.getDiet()); // Display the animals current diet to the user
                        
                        do { // Do-while loop to gather new animal diet from user
                
                            String dietMessage = "Please enter the diet of the animal (Carnivore, Herbivore, or Omnivore): "; // Create String message to send to validateString
                            tempInput = validation.validateString(dietMessage, false); // Call validateString() to validate diet before assigning to tempAnimal diet
                
                        } while (!tempInput.equalsIgnoreCase("Carnivore") && !tempInput.equalsIgnoreCase("Herbivore") &&
                            !tempInput.equalsIgnoreCase("Omnivore")); // End do-while loop when user inputs an accepted String
            
                        tempAnimal.setDiet(tempInput); // Assign new diet to tempAnimal diet
                        break; // Break out of the editing menu
                    case "habitat": // If the user wants to change the animals habitat
                        System.out.println("Current habitat: " + tempAnimal.getHabitat()); // Display the animals current habitat to the user
                        
                        do { // Do-while loop to gather new animal habitat from user
                
                            String habitatMessage = "Please enter the habitat of the animal (Desert, Grasslands, Forest, Mountains, " +
                                "Freshwater, Ocean, or Tundra): "; // Create String message to send to validateString()
                            tempInput = validation.validateString(habitatMessage, false); // Call validateString() to validate habitat before assigning to tempAnimal habitat
                
                        } while (!tempInput.equalsIgnoreCase("Desert") && !tempInput.equalsIgnoreCase("Grasslands") &&
                            !tempInput.equalsIgnoreCase("Forest") && !tempInput.equalsIgnoreCase("Mountains") &&
                            !tempInput.equalsIgnoreCase("Freshwater") && !tempInput.equalsIgnoreCase("Ocean") &&
                            !tempInput.equalsIgnoreCase("Tundra")); // End do-while loop when user inputs an accepted String
            
                        tempAnimal.setHabitat(tempInput); // Assign new habitat to tempAnimal habitat
                        break; // Break out of editing menu
                    case "size": // If the user wants to change the animals size
                        System.out.println("Current size: " + tempAnimal.getSize()); // Display the animals current size to the user
                        
                        do { // Do-while loop to gather new animal size from user
                
                            String sizeMessage = "Please enter the size category of the animal (Small, Medium, or Large): "; // Create String message to send to validateString()
                            tempInput = validation.validateString(sizeMessage, false); // Call validateString() to validate size before assigning to tempAnimal size
                
                        } while (!tempInput.equalsIgnoreCase("Small") && !tempInput.equalsIgnoreCase("Medium") &&
                            !tempInput.equalsIgnoreCase("Large")); // End do-while loop when user inputs an accepted String
            
                        tempAnimal.setSize(tempInput); // Assign new size to tempAnimal size
                        break; // Break out of editing menu
                    case "endangerment": // If the user wants to change the animals endangerment status
                        String isEndangered = tempAnimal.getIsEndangered() ? "Yes" : "No"; // Decipher current isEndangered boolean
                        System.out.println("Is animal listed as endangered: " + isEndangered); // Display current endangerment status to user
                        
                        do { // Do-while loop to gather new animal endangerment status from user
                
                            String endangeredMessage = "Is the animal an endangered species (Yes or No)? "; // Create String message to send to validateString()
                            tempInput = validation.validateString(endangeredMessage, false); // Call validateString() to validate endangerment status before assigning to tempAnimal isEndangered
                
                            tempBoolean = tempInput.equalsIgnoreCase("Yes"); // Decipher user input and assign boolean value
                
                        } while(!tempInput.equalsIgnoreCase("Yes") && !tempInput.equalsIgnoreCase("No")); // End do-while loop when user inputs accepted String
            
                        tempAnimal.setIsEndangered(tempBoolean); // Assign new endangerment status to tempAnimal isEndangered
                        break; // Break out of editing menu
                    case "flight": // If the user wants to change the animals flight status
                        String hasFlight = tempAnimal.getCanFly() ? "Yes" : "No"; // Decipher current canFly boolean
                        System.out.println("Does animal have flight capabilities: " + hasFlight); // Display current flight status to user
                        
                        do { // Do-while loop to gather new animal flight status from user
                
                            String flightMessage = "Is the animal capable of flight (Yes or No)? "; // Create String message to send to validateString()
                            tempInput = validation.validateString(flightMessage, false); // Call validateString() to validate flight status before assigning to tempAnimal canFly
                
                            tempBoolean = tempInput.equalsIgnoreCase("Yes"); // Decipher user input and assign boolean value
                
                        } while (!tempInput.equalsIgnoreCase("Yes") && !tempInput.equalsIgnoreCase("No")); // End do-while loop when user inputs accepted String
            
                        tempAnimal.setCanFly(tempBoolean); // Assign new flight status to tempAnimal canFly
                        break; // Break out of editing menu
                    case "swimming": // If the user wants to change the animals swimming status
                        String canSwim = tempAnimal.getCanSwim() ? "Yes" : "No"; // Decipher current canSwim boolean
                        System.out.println("Does animal have swimming capabilities: " + canSwim); // Display current simming status to user
                        
                        do { // Do-while loop to gather new animal swimming status from user
                
                            String swimMessage = "Is the animal capable of swimming (Yes of No)? "; // Create String message to send to validateString()
                            tempInput = validation.validateString(swimMessage, false); // Call validateString() to validate swimming status before assigning to tempAnimal canSwim
                
                            tempBoolean = tempInput.equalsIgnoreCase("Yes"); // Decipher user input and assign boolean value
                
                        } while (!tempInput.equalsIgnoreCase("Yes") && !tempInput.equalsIgnoreCase("No")); // End do-while loop when user inputs accepted String
            
                        tempAnimal.setCanSwim(tempBoolean); // Assign new swimming status to tempAnimal canSwim
                        break; // Break out of editing menu
                }
                
                tempAnimal = attributeToUppercase(tempAnimal); // Call attributeToUppercase to convert attributes of tempAnimal to uppercase
            }
        }
    }

    public void deleteAnimal() // deleteAnimal() prompts user to remove an animal and its attributes from the ArrayList
    {
        for (Iterator it = currentList.getAnimalArray().iterator(); it.hasNext();) // For loop to iterate through currentList AnimalArray
        {
            tempAnimal = (Animal)it.next(); // Assign currentList object to tempAnimal
            System.out.println(tempAnimal.getName()); // Display name of current tempAnimal
        }
        
        String deleteMessage = "\nWhich animal would you like to delete? "; // Create String message to send to validateString()
        tempInput = validation.validateString(deleteMessage, false); // Call validateString() to validate name before assigning to tempInput
        tempBoolean = false; // Set tempBoolean to check for animal existence
        
        for (int i = 0; i < currentList.getAnimalArray().size(); i++) // For loop to iterate through currentList AnimalArray
        {
            tempAnimal = (Animal)currentList.getAnimalArray().get(i); // Get current Animal and assign to tempAnimal
            
            if (tempAnimal.getName().equalsIgnoreCase(tempInput)) // If the name of the tempAnimal matches the users input...
            {
                currentList.getAnimalArray().remove(i); // remove the animal from the currentList AnimalArray
                System.out.println(tempInput.toUpperCase() + " has been removed from the list!"); // Notify the user that the animal has been removed
                
                tempBoolean = true; // If the animal input has been found and deleted, set tempBoolean to true
            }
        }
        
        if (!tempBoolean) // If the animal does not exist on the list
        {
            tempInput = tempInput.toUpperCase(); // Change the input to uppercase
            System.out.println("\n" + tempInput + " IS NOT ON THE LIST!\n"); // Inform the user that the animal is unable to be located
            deleteAnimal(); // Prompt the user for new input through the use of recursion
        }
    }

    public void searchAnimal() // searchAnimal() prompts user to select animal to view attributes
    {
        for (Iterator it = currentList.getAnimalArray().iterator(); it.hasNext();) // For loop to iterate through currentList AnimalArray
        {
            tempAnimal = (Animal)it.next(); // Assign currentList object to tempAnimal
            System.out.println(tempAnimal.getName()); // Display name of current tempAnimal
        }
        
        String searchMessage = "\nWhich animal would you like to view? "; // Create String message to send to validateString()
        tempInput = validation.validateString(searchMessage, false); // Call validateString() to validate name before assigning to tempInput
        tempBoolean = false; // Set tempBoolean to check for animal existence
        
        for (int i = 0; i < currentList.getAnimalArray().size(); i++) // For loop to iterate through currentList AnimalArray
        { 
            tempAnimal = (Animal)currentList.getAnimalArray().get(i); // Get current Animal and assign to tempAnimal
            
            if (tempAnimal.getName().equalsIgnoreCase(tempInput)) // If the name of the tempAnimal matches the users input...
            {
                String isEndangered = tempAnimal.getIsEndangered() ? "YES" : "NO"; // Translate isEndangered to String by using ternary operand
                String hasFlight = tempAnimal.getCanFly() ? "YES" : "NO"; // Translate canFly to String by using ternary operand
                String canSwim = tempAnimal.getCanSwim() ? "YES" : "NO"; // Translate canSwim to String by using ternary operand
                
                System.out.print("\nName: " + tempAnimal.getName() + "\nType: " + tempAnimal.getType() +
                        "\nDiet: " + tempAnimal.getDiet() + "\nHabitat: " + tempAnimal.getHabitat() + 
                        "\nSize: " + tempAnimal.getSize() + "\nEndangered: " + isEndangered +
                        "\nFlight: " + hasFlight + "\nSwimmer: " + canSwim + "\n"); // Display all requested animal attributes to user
                
                tempBoolean = true; // If the animal input has been found, set the tempBoolean to true
            }
        }
        
        if(!tempBoolean) // If the animal does not exist on the list
        {
            tempInput = tempInput.toUpperCase(); // Change the input to uppercase
            System.out.println("\n" + tempInput + " IS NOT ON THE LIST!\n"); // Inform the user that the animal is unable to be located
            searchAnimal(); // Prompt the user for new input through the use of recursion
        }
    }
    
    public Animal attributeToUppercase(Animal animal) // attributeToUppercase converts all user input to UPPERCASE
    {                                                 // to make output more readable
        tempInput = animal.getName(); // Assign animal name to tempInput
        tempInput = tempInput.toUpperCase(); // Call toUppercase() and assign new String to tempInput
        animal.setName(tempInput); // Assign tempInput to animal name
        
        tempInput = animal.getType(); // Assign animal type to tempInput
        tempInput = tempInput.toUpperCase(); // Call toUppercase() and assign new String to tempInput
        animal.setType(tempInput); // Assign tempInput to animal type
        
        tempInput = animal.getDiet(); // Assign animal diet to tempInput
        tempInput = tempInput.toUpperCase(); // Call toUppercase() and assign new String to tempInput
        animal.setDiet(tempInput); // Assign tempInput to animal diet
        
        tempInput = animal.getHabitat(); // Assign animal habitat to tempInput
        tempInput = tempInput.toUpperCase(); // Call toUppercase() and assign new String to tempInput
        animal.setHabitat(tempInput); // Assign tempInput to animal habitat
        
        tempInput = animal.getSize(); // Assign animal size to tempInput
        tempInput = tempInput.toUpperCase(); // Call toUppercase() and assign new String to tempInput
        animal.setSize(tempInput); // Assign tempInput to animal size
        
        return animal; // Return modified animal to caller
    }
    
    public void readAnimalList() // animalList file reader method
    {
        System.out.println("READING ANIMAL LIST FROM CURRENT FILE"); // Inform the user that the system is reading the file
        
        try { // Try statement to catch NIO and Null expections
            File animalText = new File("AnimalList.txt"); // Delcare and initialize file reference to AnimalList.txt
            FileReader fr = new FileReader(animalText); // Declare and initialize FileReader reference - passed to BufferedReader
            BufferedReader br = new BufferedReader(fr); // Declare and initialize BufferedReader reference - used for readLine() method
            
            do { // Do-while loop to read file and populate AnimalList
                Animal currentAnimal = new Animal(); // Declare and instantiate new animal to be populated
                
                currentAnimal.setName(br.readLine()); // Read fist line and setName()
                currentAnimal.setType(br.readLine()); // Read second line and setType()
                currentAnimal.setDiet(br.readLine()); // Read third line and setDiet()
                currentAnimal.setHabitat(br.readLine()); // Read fourth line and setHabitat()
                currentAnimal.setSize(br.readLine()); // Read fifth line and setSize()
                
                String checkBoolean; // Declare String to hold lines 6-8
                boolean attributeSetter; // Declare boolean to pass data to currentAnimal
                
                checkBoolean = br.readLine(); // Assign sixth line to checkBoolean
                attributeSetter = checkBoolean.equalsIgnoreCase("true"); // Call equalsIgnoreCase() and assign returned value to attributeSetter
                currentAnimal.setIsEndangered(attributeSetter); // setIsEndangered() with attributeSetter
                
                checkBoolean = br.readLine(); // Assign sixth line to checkBoolean
                attributeSetter = checkBoolean.equalsIgnoreCase("true"); // Call equalsIgnoreCase() and assign returned value to attributeSetter
                currentAnimal.setCanFly(attributeSetter); // setCanFly() with attributeSetter
                
                checkBoolean = br.readLine(); // Assign sixth line to checkBoolean
                attributeSetter = checkBoolean.equalsIgnoreCase("true"); // Call equalsIgnoreCase() and assign returned value to attributeSetter
                currentAnimal.setCanSwim(attributeSetter); // setCanSwim() with attributeSetter
                
                currentList.getAnimalArray().add(currentAnimal); // Add the currentAnimal to the animal ArrayList
            } while (br.readLine() != null); // Exit do-while when there is no more data
            
        } catch (IOException | NullPointerException e) { // Catch IOExceptions and NullPointerExceptions while reading from the AnimalList.txt
            // System.out.println("IOExcpetion while reading from file!"); // Notify the develoepr of the issue
            // System.out.println("NullPointerException while reading from file!"); // Notify the developer of the issue
        }
    }
    
    public void writeAnimalList() //animalList file writer method
    {
        System.out.println("\nWRITING ANIMAL LIST TO CURRENT FILE"); // Inform the user that the system is writing the file
        
        try { // Try statement to catch NIO exceptions
            File animalText = new File("AnimalList.txt"); // Declare and initialize file reference to AnimalList.txt
            try (PrintWriter pw = new PrintWriter(animalText)) { // Try statement to print to file (Declare and initilaize PrintWriter)
                for (Iterator it = currentList.getAnimalArray().iterator(); it.hasNext();) // For loop to iterate through currentList AnimalArray
                {
                    Animal currentAnimal = (Animal)it.next(); // Get next animal in list and cast to Animal type
                    
                    // Each attribute will print to a separate line
                    pw.println(currentAnimal.getName()); // Print the name to the AnimalList.txt
                    pw.println(currentAnimal.getType()); // Print the type to the AnimalList.txt
                    pw.println(currentAnimal.getDiet()); // Print the diet to the AnimalList.txt
                    pw.println(currentAnimal.getHabitat()); // Print the habitat to the AnimalList.txt
                    pw.println(currentAnimal.getSize()); // Print the size to the AnimalList.txt
                    pw.println(currentAnimal.getIsEndangered()); // Print endangerment status to the AnimalList.txt
                    pw.println(currentAnimal.getCanFly()); // Print the flight status to the AnimalList.txt
                    pw.println(currentAnimal.getCanSwim()); // Print the swim status to the AnimalList.txt
                    pw.println("-----------------"); // Create a separator in the file for the reader file to do-while loop to skip
                    pw.flush(); // Flush the writer
                }
                
                pw.close(); // Close the writer
            }
        } catch (IOException e) { // Catch IOExceptions owhile writing to the AnimalList.txt
            // System.out.println("IOException while writing to file!"); // Notify developer of the issue
        }
    }
}

/**
 * Author: John D. Snurr
 * Date: December 5, 2016
 */