package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class AppExample {
    public static void main(String[] args) throws ParseException {
        var sdf = new SimpleDateFormat("dd/MM/yyyy");

        //Client data
        String name = "Alex Green";
        String email = "Alex@gmail.com";
        String birthDate = "15/03/1985";
        Date convertedBirthDate = sdf.parse(birthDate);

        Client client = new Client(name, email, convertedBirthDate);

        //Order data
        String status = "PROCESSING";
        OrderStatus convertedStatus = OrderStatus.valueOf(status);

        
        //Product data
        String productName = "Mouse";
        Double productPrice = 40d;
        int quantity = 2;

        //Creating product
        var product = new Product(productName, productPrice);

        //Creating OrderItem
        var orderItem = new OrderItem(quantity, productPrice, product);

        //Creating Order
        var moment = new Date();
        var order = new Order(moment, convertedStatus, client);

        System.out.println(order);
        System.out.println(orderItem);
    }
}