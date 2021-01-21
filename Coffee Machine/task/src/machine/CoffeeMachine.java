package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanLine = new Scanner(System.in);
        //Scanner scanChoice = new Scanner(System.in);
        String menuSelection;
        String customerChoice;
        /**
         *         quantities[1] currentWater
         *         quantities[2] currentMilk
         *         quantities[3] currentBeans
         *         quantities[4]  currentDisposableCups
         *         quantities[0] currentMoney
         */
        int[] quantities = {550, 400, 540, 120, 9};
        while (true) {
            //machineStatus(quantities);
            System.out.print("Write action (buy, fill, take, remaining, exit):\n> ");
            menuSelection = scanLine.nextLine();
            switch (menuSelection) {
                case "buy":
                    System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:\n> ");
                    customerChoice = scanLine.nextLine();
                    switch (customerChoice) {
                        case "1":
                            if (ingredientCheck("espresso", quantities)) {
                                makeEspresso(quantities);
                            } else {
                                System.out.println("Not enough ingredients on hand");
                            }
                            break;
                        case "2":
                            if (ingredientCheck("latte", quantities)) {
                                makeLatte(quantities);
                            } else {
                                System.out.println("Not enough ingredients on hand");
                            }
                            break;
                        case "3":
                            if (ingredientCheck("cappuccino", quantities)) {
                                makeCappuccino(quantities);
                            } else {
                                System.out.println("Not enough ingredients on hand");
                            }
                            break;
                        case "back":
                            break;
                        default:
                            System.out.println("invalid selection");
                            break;
                    }
                    break;
                case "fill":
                    fillMachine(quantities);
                    break;
                case "take":
                    System.out.print("I gave you " + quantities[0] + "\n");
                    quantities[0] = 0;
                    break;
                case "remaining":
                    machineStatus(quantities);
                    break;
                case "exit":
                    return;
                default:
                    break;
            }
        }

    }

    public static void  machineStatus(int[] quantities){
        System.out.print("The coffee machine has:\n"
                + quantities[1] + " of water\n"
                + quantities[2] + " of milk\n"
                + quantities[3] + " of coffee beans\n"
                + quantities[4] + " of disposable cups\n"
                + quantities[0] + " of money\n");
    }

    public static void fillMachine(int[] quantities) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Write how many ml of water do you want to add:\n");
        quantities[1] += scanner.nextInt();
        scanner.nextLine();

        System.out.print("Write how many ml of milk do you want to add:\n");
        quantities[2] += scanner.nextInt();
        scanner.nextLine();

        System.out.print("Write how many grams of coffee beans do you want to add:\n");
        quantities[3] += scanner.nextInt();
        scanner.nextLine();

        System.out.print("Write how many disposable cups of coffee do you want to add:\n");
        quantities[4] += scanner.nextInt();
        scanner.nextLine();
    }

    public static void makeEspresso(int[] quantities) {
        quantities[1] -= 250; //currentWater
        quantities[3] -= 16; //currentBeans
        quantities[4] -= 1; // currentDisposableCups
        quantities[0] += 4; //currentMoney
    }

    public static void makeLatte(int[] quantities) {
        quantities[1] -= 350; //currentWater
        quantities[2] -= 75; //currentMilk
        quantities[3] -= 20; //currentBeans
        quantities[4] -= 1; // currentDisposableCups
        quantities[0] += 7; //currentMoney
    }

    public static void makeCappuccino(int[] quantities) {
        quantities[1] -= 200;   //currentWater
        quantities[2] -= 100;   //currentMilk
        quantities[3] -= 12;    //currentBeans
        quantities[4] -= 1;     //currentDisposableCups
        quantities[0] += 6;     //currentMoney
    }

    public static boolean ingredientCheck(String coffeeType, int[] quantities) {
        if (coffeeType == "espresso") {
            if (quantities[1] < 250 ||     //currentWater
                    quantities[3] < 16 ||      //currentBeans
                    quantities[4] < 1) {       //currentDisposableCups
                return false;
            }
        }

        if (coffeeType == "latte") {
            if(quantities[1] < 350 ||   //currentWater
                    quantities[2] < 75 ||   //currentMilk
                    quantities[3] < 20 ||   //currentBeans
                    quantities[4] < 1)      // currentDisposableCups
                return false;
        }

        if (coffeeType == "cappuccino") {
            if(quantities[1] < 200 ||   //currentWater
                    quantities[2] < 100 ||  //currentMilk
                    quantities[3] < 12 ||   //currentBeans
                    quantities[4] < 1)      // currentDisposableCups
                return false;
        }
        return true;
    }



}
