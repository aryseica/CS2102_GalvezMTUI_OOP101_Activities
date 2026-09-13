import java.util.Scanner;

public class Menu {

    public static void menu() {
        System.out.println("====(●'◡'●) 	M E N U 	(●ˇ∀ˇ●)====");
        System.out.println("1. Four Cheese Burger		- $80.00");
        System.out.println("2. Creamy SpinachPizza		- $120.00");
        System.out.println("3. Carbonara Pasta		- $100.00");
        System.out.println("4. Donut 		        - $70.00");
        System.out.println("5. Okinawa Milk Tea  		- $90.00");
        System.out.println("6. Vietnamese Coffee		- $50.00");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        menu();

        // Index 0 is unused so item numbers 1-6 line up directly with the array index
        int[] prices = {0, 80, 120, 100, 70, 90, 50};

        int totalQuantity = 0;
        double totalSubtotal = 0;
        double totalDiscountAmount = 0;

        while (true) {
            System.out.print("Enter item number: ");
            int item = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter quantity: ");
            int quantityFood = Integer.parseInt(scanner.nextLine().trim());

            if (item < 1 || item > 5) {
                System.out.println("Invalid order! Please enter a valid item and quantity.\n");
                System.out.print("Do you want to order again? (Y/N): ");
                String orderAgain = scanner.nextLine().trim().toUpperCase();
                System.out.println();

                if (!orderAgain.equals("Y")) {
                    break;
                } else {
                    continue;
                }
            }

            double subtotal = prices[item] * quantityFood;

            System.out.print("Are you a student? (Y/N): ");
            String student = scanner.nextLine().trim().toUpperCase();

            double discount;

            if (student.equals("Y")) {
                if (subtotal >= 500) {
                    discount = subtotal * 0.15;
                } else {
                    discount = subtotal * 0.10;
                }
            } else {
                if (subtotal >= 500) {
                    discount = subtotal * 0.5;
                } else {
                    discount = 0;
                }
            }

            double orderTotal = subtotal - discount;

            System.out.println("\nSubtotal: " + subtotal);
            System.out.println("Discount: " + discount);
            System.out.println("Order Total: " + orderTotal);

            totalQuantity += quantityFood;
            totalSubtotal += subtotal;
            totalDiscountAmount += discount;

            System.out.print("\nDo you want to order again? (Y/N): ");
            String orderAgain = scanner.nextLine().trim().toUpperCase();
            System.out.println();

            if (!orderAgain.equals("Y")) {
                break;
            }
        }

        double finalTotal = totalSubtotal - totalDiscountAmount;

        System.out.println();
        System.out.println("====ヽ(✿ﾟ▽ﾟ)ノ O R D E R     S U M M A R Y (╹ڡ╹ )====");
        System.out.println("Total items: " + totalQuantity + " ");
        System.out.printf("Total before discount: $%.2f%n", totalSubtotal);
        System.out.printf("Total discount: %.2f%n", totalDiscountAmount);
        System.out.printf("Final amount: $%.2f%n", finalTotal);
        System.out.println("\nYour order will be right up! Thank you for ordering!");

        scanner.close();
    }
}
