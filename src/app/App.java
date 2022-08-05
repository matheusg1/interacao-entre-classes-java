package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class App {
    public static void main(String[] args) throws ParseException{
        var sdf = new SimpleDateFormat("dd/MM/yyyy");
        var sc = new Scanner(System.in);

        System.out.println("Enter the client data:");
        System.out.print("Name ");
        String name = sc.next();
        sc.nextLine();

        System.out.print("Email ");
        String email = sc.next();

        System.out.print("Birth date (DD/MM/YYYY) ");
        String birthDate = sc.next();
        
        Date birthDate2 = sdf.parse(birthDate);
        
        Client c1 = new Client(name, email, birthDate2);

        System.out.println("Enter the order data:");
        System.out.print("Status ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        var moment = new Date();
        Order order = new Order(moment, status, c1);


        System.out.print("How many items to this order? ");
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println("Enter " + (i + 1) + " item data: ");
            System.out.print("Product name ");
            sc.nextLine();
            String productName = sc.nextLine();

            System.out.print("Product price ");
            Double productPrice = sc.nextDouble();

            System.out.print("Quantity ");

            Integer quantity = sc.nextInt();

            var product = new Product(productName, productPrice);

            var it = new OrderItem(quantity, productPrice, product);

            order.addItem(it);
        }
    
        System.out.println();

        System.out.println(order);

        sc.close();

    }
}