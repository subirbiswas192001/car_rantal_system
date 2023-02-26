import java.util.Scanner;

interface HDFC_Gateway {
    void payBill();
}

class OrderObj implements HDFC_Gateway {
    private String obj;
    private double objCost = 0;

    OrderObj(String nameObj, int cost) {
        obj = nameObj;
        objCost = cost;
    }

    private void addToCart() {
        System.out.println("'" + obj + "' has been added to cart and is ready to be billed.");
    }

    private void orderSuccess() {
        System.out.println("Whoo! your fav order is on the way to reach you. \nVisit My Orders to get a track of it.");
    }

    public void payBill() {
        addToCart();
        System.out.println(
                "\nWelcome to HDFC payment gateway: \nTotal cost: " + objCost + "\n\nEnter you PIN to pay the bill: ");
        Scanner sc = new Scanner(System.in);
        int pin = sc.nextInt();
        System.out.println("Congratulations! your payment of " + objCost + " is successful.");
        orderSuccess();
    }
}

public class assign {
    public static void main(String[] args) {
        OrderObj mac = new OrderObj("windows", 70000);
        mac.payBill();
    }
}