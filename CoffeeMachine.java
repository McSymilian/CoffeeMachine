package machine;
import java.util.Scanner;

public class CoffeeMachine {

    //Espresso
    static final int waterPerEs = 250;
    static final int milkPerEs = 0;
    static final int coffeeBeansPerEs = 16;
    static final int costPerEs = 4;

    //Latte
    static final int waterPerLa = 350;
    static final int milkPerLa = 75;
    static final int coffeeBeansPerLa = 20;
    static final int costPerLa = 7;

    //Cappuccino
    static final int waterPerCa = 200;
    static final int milkPerCa = 100;
    static final int coffeeBeansPerCa = 12;
    static final int costPerCa = 6;

    //Contain
    static int storedWater = 400;
    static int storedMilk = 540;
    static int storedCoffeeBeans = 120;
    static int storedDisposalCups = 9;
    static int money = 550;

    private static boolean exit = true;

    private static String cappuccino() {
        if (storedWater >= waterPerCa)
            storedWater -= waterPerCa;
        else
            return "Sorry, not enough water!";
        if (storedMilk >= milkPerCa)
            storedMilk -= milkPerCa;
        else
            return "Sorry, not enough milk";
        if (storedCoffeeBeans >= coffeeBeansPerCa)
            storedCoffeeBeans -= coffeeBeansPerCa;
        else
            return "Sorry, not enough coffee beans";
        if (storedDisposalCups > 0)
            storedDisposalCups--;
        else
            return "Sorry, not enough disposal cups";
        money += costPerCa;
        return "I have enough resources, making you a coffee!";
    }

    private static String latte() {
        if (storedWater >= waterPerLa)
            storedWater -= waterPerLa;
        else
            return "Sorry, not enough water!";
        if (storedMilk >= milkPerLa)
            storedMilk -= milkPerLa;
        else
            return "Sorry, not enough milk";
        if (storedCoffeeBeans >= coffeeBeansPerLa)
            storedCoffeeBeans -= coffeeBeansPerLa;
        else
            return "Sorry, not enough coffee beans";
        if (storedDisposalCups > 0)
            storedDisposalCups--;
        else
            return "Sorry, not enough disposal cups";
        money += costPerLa;
        return "I have enough resources, making you a coffee!";
    }

    private static String espresso() {
        if (storedWater >= waterPerEs)
            storedWater -= waterPerEs;
        else
            return "Sorry, not enough water!";
        if (storedMilk >= milkPerEs)
            storedMilk -= milkPerEs;
        else
            return "Sorry, not enough milk";
        if (storedCoffeeBeans >= coffeeBeansPerEs)
            storedCoffeeBeans -= coffeeBeansPerEs;
        else
            return "Sorry, not enough coffee beans";
        if (storedDisposalCups > 0)
            storedDisposalCups--;
        else
            return "Sorry, not enough disposal cups";
        money += costPerEs;
        return "I have enough resources, making you a coffee!";
    }

    private static void buy() {
        Scanner in = new  Scanner(System.in);
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String command = in.next();
        if(command.equals("back")) return;
        int number = Integer.parseInt(command);

        switch (number){
            case 1:
                espresso();
                break;
            case 2:
                latte();
                break;
            case 3:
                cappuccino();
                break;
            default:
                System.out.println("Unknown command");
                break;
        }
    }
    private static void showStatus() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(storedWater + " of water");
        System.out.println(storedMilk + " of milk");
        System.out.println(storedCoffeeBeans + " of coffee beans");
        System.out.println(storedDisposalCups + " of disposal cups");
        System.out.println(money + " of money");
    }

    private static void fill() {
        Scanner in = new  Scanner(System.in);

        System.out.println("\nWrite how many ml of water do you want to add:");
        storedWater += in.nextInt();

        System.out.println("\nWrite how many ml of milk do you want to add:");
        storedMilk += in.nextInt();

        System.out.println("\nWrite how many grams of coffee beans do you want to add:");
        storedCoffeeBeans += in.nextInt();

        System.out.println("\nWrite how many disposable cups of coffee do you want to add:");
        storedDisposalCups += in.nextInt();
    }

    private static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public static void main(String[] args) {
        Scanner in = new  Scanner(System.in);

        do{
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        String command = in.next();

        switch(command){
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                showStatus();
                break;
            case "exit":
                exit = false;
                break;
            default:
                System.out.println("Unknown command");
                break;
        }
        }while (exit);
    }
}
