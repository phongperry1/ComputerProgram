
package com.mycompany.computerprogram;

import java.util.Scanner;


public class Manager {
    
    public int menu() {
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = checkInputIntLimit(1, 3);
        return choice;
    }
    
    public int checkInputIntLimit(int min, int max) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public double checkInputDouble() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public String checkInputOperator() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String result = sc.nextLine().trim();
            if(result.isEmpty()) {
                System.err.println("Not empty");
            } else if(result.equalsIgnoreCase("+") || result.equalsIgnoreCase("-") || result.equalsIgnoreCase("*") || result.equalsIgnoreCase("/") || result.equalsIgnoreCase("^") || result.equalsIgnoreCase("=")) {
                return result;
            } else {
                System.err.println("Please input (+,-,*,/,^,=)");
            }
            System.out.print("Enter again");
        }
    }
    
    public double inputNumber() {
        System.out.print("Enter number: ");
        double number = checkInputDouble();
        return number;
    }
    
    public void normalCalculator() {
        double memory;
        System.out.print("Enter number: ");
        memory = checkInputDouble();
        while(true) {
            System.out.print("Enter operator: ");
            String operator = checkInputOperator();
            if(operator.equalsIgnoreCase("+")) {
                memory += inputNumber();
                System.out.println("Memory: " + memory);
            }
            if(operator.equalsIgnoreCase("-")) {
                memory -= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if(operator.equalsIgnoreCase("*")) {
                memory *= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if(operator.equalsIgnoreCase("/")) {
                memory /= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if(operator.equalsIgnoreCase("^")) {
                memory = Math.pow(memory, inputNumber());
                System.out.println("Memory: " + memory);
            }
            if(operator.equalsIgnoreCase("=")) {
                System.out.println("Result: " + memory);
                return;
            }
        }
}
    
    public String BMIStatus(double bmi) {
        if(bmi < 19) {
            return "Under-standard.";
        } else if(bmi >= 19 && bmi < 25) {
            return "Standard";
        } else if(bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if(bmi >= 30 && bmi < 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }
    
    public void BMICalculator() {
        System.out.print("Enter weight(kg): ");
        double weight = checkInputDouble();
        System.out.print("Enter height(cm): ");
        double height = checkInputDouble();
        double bmi = weight*10000 / (height*height);
        System.out.printf("BMI number: %.2f\n", bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));
    }
}