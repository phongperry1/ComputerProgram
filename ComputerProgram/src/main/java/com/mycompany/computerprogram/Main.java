

package com.mycompany.computerprogram;


public class Main {

    public static void main(String[] args) {
        Manager mn = new Manager();
        while(true) {
            int choice = mn.menu();
            switch (choice) {
                case 1:
                    mn.normalCalculator();
                    break;
                case 2:
                    mn.BMICalculator();
                    break;
                case 3:
                    return;
            }
        }
    }
}
