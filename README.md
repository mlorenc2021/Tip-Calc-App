# Tip Calculator Android App

![](https://github.com/mlorenc2021/Tip-Calc-App/blob/master/demo.gif)

This is a simple Android application designed to act as a tip calculator.  
The user inputs the bill amount and a tip percentage, and the app dynamically calculates and displays both the tip amount and the total bill. The app also includes a scrollable help page with information for the user.

## Features

- Input fields for bill amount and tip percentage
- Real-time calculation of tip and total bill as inputs change
- Displays formatted currency values for tip and total
- Input validation with error handling for invalid or empty inputs
- Help page with scrollable instructions and info
- Clear separation of logic via a `TipCalculator` class

## Technologies Used

- Java
- Android SDK
- AndroidX AppCompat
- XML layouts for UI
- `TextWatcher` for dynamic input monitoring

## Project Structure

- `MainActivity.java`  
  Connects UI elements to the code, handles input changes with a custom `TextWatcher`, validates user input, calculates the tip and total amounts, and launches the Help page.

- `TipCalculator.java`  
  Contains the core logic for tip calculation including setters with validation, and methods to calculate the tip amount and total bill.

- `HelpActivity.java`  
  Displays a scrollable help page and includes a button to return to the main activity.

- `activity_main.xml` and `activity_help.xml`  
  Define the layouts for the main tip calculator screen and the help page, respectively.

## Usage

1. Enter the bill amount in the first input field.
2. Enter the tip percentage in the second input field.
3. The tip and total will be calculated and displayed automatically.
4. Tap the Help button for instructions or info.
