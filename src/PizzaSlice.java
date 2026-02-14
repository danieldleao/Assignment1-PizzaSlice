/**
 * Durham College - Computer Programming and Analysis
 * COSC 1200 Object-Oriented Programming 1
 * Prof. Ken Hodgson
 * Daniel Doro Leao | SID: 101042176
 * Date: 2026-02-12
 * Activity Name: Assignment 1: Pizza Cutting
 */

import java.util.Scanner;

void main() {
  Scanner input = new Scanner(System.in);
  boolean continueProgram = true;

  // Constants
  double MIN_DIAMETER = 6.0;
  double MAX_DIAMETER = 24.0;

  // Welcome message
  System.out.println("Welcome to the Pizza Slice Calculator!");
  System.out.println("There is available pizzas in a range of 6\" to 24\" inches.");
  System.out.println("You can choose any number (whole or decimal) in between this range");

  // Main loop
  while (continueProgram) {
    double diameter = 0.0;
    boolean validInput = false;

    // Input (string, int, and double)
    while (!validInput) {
      System.out.println("Please enter the desired diameter for your pizza:");

      // Check if input is a number
      if (!input.hasNextDouble()) {
        String invalidInput = input.nextLine(); // Clear invalid input
        System.out.println("WRONG! Please enter a NUMERIC value (whole or decimal).");
        System.out.println("So, you entered: \"" + invalidInput + "\" which is not a number.");
        continue;
      }

      // Reading the number from the input
      diameter = input.nextDouble();
      input.nextLine(); // Cleaning the buffer after reading number

      // Validate diameter (acceptable range)
      if (diameter < MIN_DIAMETER || diameter > MAX_DIAMETER) {
        System.out.printf("WRONG! The pizza diameter should be in the range of %.0f\" to %.0f\" inclusive! Please try " +
                        "again.%n",
                MIN_DIAMETER, MAX_DIAMETER);
      } else {
        validInput = true;
      }
    }

    // Calculate (determine) the number of slices
    int numberOfSlices = determineSlices(diameter);

    // Calculate the area of each slice. Area of each slice = (π * r²) / number of slices
    double radius = diameter / 2.0;
    double totalArea = Math.PI * radius * radius;
    double areaPerSlice = totalArea / numberOfSlices;

    // Outputs (rounded to 2 decimal)
    System.out.printf("A %.2f\" pizza will yield %d slices.%n", diameter, numberOfSlices);
    System.out.printf("Each slice will have an area of %.2f square inches.%n", areaPerSlice);

    // Ask if the user wants to do it again
    boolean validResponse = false;
    while (!validResponse) {
      System.out.println("\nHey, would you like to still doing it? (yes/no):");
      String response = input.nextLine().trim().toLowerCase();

      // Validate response is yes, y / no, n
      if (response.equals("yes") || response.equals("y") ||
              response.equals("no") || response.equals("n")) {
        validResponse = true;

        if (response.equals("no") || response.equals("n")) {
          continueProgram = false;
          System.out.println("Right, in this case tank you for using the Pizza Slice Calculator. Goodbye!");
        }
      } else {
        System.out.println("WRONG! Please enter 'yes', 'y' or 'no', 'n'.");
      }
    }
    System.out.println(); // Just a space
  }

  input.close();
}

// Rules to determines the number of slices to cut pizza
private static int determineSlices(double diameter) {
  if (diameter >= 6.0 && diameter < 8.0) {
    return 4;
  } else if (diameter >= 8.0 && diameter < 12.0) {
    return 6;
  } else if (diameter >= 12.0 && diameter < 14.0) {
    return 8;
  } else if (diameter >= 14.0 && diameter < 16.0) {
    return 10;
  } else if (diameter >= 16.0 && diameter < 20.0) {
    return 12;
  } else { // diameter >= 20.0 && diameter <= 24.0
    return 16;
  }
}