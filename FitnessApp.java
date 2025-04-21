/*
* Fitness.java
* @author JiaLiu
* 8/11/24
*/

import javax.swing.JOptionPane;

public class FitnessApp {

    public static void main(String[] args) {
        // Ask user to enter the number of sets of conditions they want to check
        int numSets = getValidInt("How many sets of conditions would you like to check?");

        // Repeat for the specified number of sets
        for (int i = 0; i < numSets; i++) {
            runApp();
        }
        JOptionPane.showMessageDialog(null, "Thank you for using the Fitness Activity Recommendation App!");
    }

    // Main application loop
    private static void runApp() {
        Fitness fitness = null; // Declare Fitness object initially as null because we will ask the user for details later
        int isDataEntered = 0;    // Use 0 to represent data not entered, 1 for data entered
        double calories;
        int exit = 0;           // Use 0 to continue, 1 to exit

        // Continue to display the menu until the user decides to exit
        while (exit == 0) {
            displayMenu();
            int UsersChoice = getValidInt("Enter your choice (1-7):");

            // Check each menu option
            if (UsersChoice == 1) {
                fitness = getWeatherDetails(); // Get weather details from the user
                isDataEntered = 1; // Set isDataEntered to 1 (indicating data has been entered)
            } else if (UsersChoice == 2) {
                // Temperature-based activity recommendation
                if (isDataEntered == 1) {
                    JOptionPane.showMessageDialog(null, fitness.recommendActivityByTemperature());
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter weather details first (Option 1).");
                }
            } else if (UsersChoice == 3) {
                // Heat index calculation and display
                if (isDataEntered == 1) {
                    JOptionPane.showMessageDialog(null, "Heat Index: " + fitness.calculateHeatIndex());
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter weather details first (Option 1).");
                }
            } else if (UsersChoice == 4) {
                // Wind speed conditions and recommendations
                if (isDataEntered == 1) {
                    JOptionPane.showMessageDialog(null, fitness.recommendActivityByWindSpeed());
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter weather details first (Option 1).");
                }
            } else if (UsersChoice == 5) {
                // UV index precautions
                if (isDataEntered == 1) {
                    JOptionPane.showMessageDialog(null, fitness.recommendUvPrecautions());
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter weather details first (Option 1).");
                }
            } else if (UsersChoice == 6) {
                // Calorie burn calculation
                if (isDataEntered == 1) {
                    calculateCalories(fitness);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter weather details first (Option 1).");
                }
            } else if (UsersChoice == 7) {
                exit = exitPrompt(); // Check if the user wants to exit
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a valid option.");
            }
        }
    }

    // Display menu options
    private static void displayMenu() {
        String menu = "Application Menu:\n" +
                "1. Provide weather details (Temperature, Humidity, Wind Speed, UV Index)\n" +
                "2. Recommendations based on Temperature conditions\n" +
                "3. Calculate Heat Index\n" +
                "4. Check Wind Speed conditions\n" +
                "5. UV Index precautions\n" +
                "6. Calculate the number of calories burned for an activity\n" +
                "7. Exit Application";
        JOptionPane.showMessageDialog(null, menu);
    }

    // Method to get weather details
    private static Fitness getWeatherDetails() {
        double temperature = getValidDouble("Enter Temperature (e.g., 20):");
        double humidity = getValidDouble("Enter Humidity (%) (e.g., 50):");
        double windSpeed = getValidDouble("Enter Wind Speed (km/h) (e.g., 10):");
        int uvIndex = getValidInt("Enter UV Index (e.g., 5):");
        double weight = getValidDouble("Enter Weight (kg) (e.g., 70):");

        // Create a new Fitness object with the entered details
        return new Fitness(temperature, humidity, windSpeed, uvIndex, weight, 0, 0);// met and duration not entered at this point so set as 0 here. Will be entered later if the user chooses.
    }

    // Prompt user if they would like to continue or exit
    private static int exitPrompt() {
        String answer = JOptionPane.showInputDialog("Would you like to check another set of conditions? (yes/no):");
        if (answer.equalsIgnoreCase("yes")) {
            return 0; // 0 means continue
        } else {
            return 1; // 1 means exit
        }
    }

    // Calculate calories burned for a given activity
    private static void calculateCalories(Fitness fitness) {
        double met = getValidDouble("Enter MET value (e.g., 7 for jogging, 8 for Cycling,6 for Swimming,1 for Yoga, 9 for  Strength Training, 10 for Hiking,5 for Running,4 for Tennis, 11 for Water Sports)):");
        double duration = getValidDouble("Enter Duration (hours) (e.g., 1.5):");

        // Set MET and duration in the Fitness object to calculate calories burned
        fitness.setMet(met);
        fitness.setDuration(duration);

        // Display the calculated calories burned
        JOptionPane.showMessageDialog(null, "Calories Burned: " + fitness.calculateCaloriesBurned());
    }

    // Get a valid double input from the user
    private static double getValidDouble(String message) {
        double value = 0;
        int isDataValid = 0;

        while (isDataValid == 0) {
            String input = JOptionPane.showInputDialog(message);

            // Check if input is valid (not null or empty and numeric)
            if (input != null && input.matches("[-+]?[0-9]*\\.?[0-9]+")) {
                value = Double.parseDouble(input);
                isDataValid = 1; // Mark as valid input
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numeric value.");
            }
        }
        return value;
    }

    // Get a valid integer input from the user
    private static int getValidInt(String message) {
        int value = 0;
        int isDataValid = 0;

        while (isDataValid == 0) {
            String input = JOptionPane.showInputDialog(message);

            // Check if input is valid (not null or empty and numeric integer)
            if (input != null && input.matches("[-+]?[0-9]+")) {
                value = Integer.parseInt(input);
                isDataValid = 1; // Mark as valid input
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter an integer.");
            }
        }
        return value;
    }//main
}//class
