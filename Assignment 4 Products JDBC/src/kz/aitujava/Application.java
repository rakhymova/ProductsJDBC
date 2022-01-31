package kz.aitujava;

import kz.aitujava.OrderControl;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    private final OrderControl controller;
    private final Scanner scanner;

    public Application(OrderControl controller) { //constructor to initialize 'controller' and scanner object
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) { // while loop needed to keep asking options from users
            System.out.println("Choose an option :");
            System.out.println("1---Purchase Products---1");
            System.out.println("2---See my orders---2");
            System.out.println("3---Exit---3");
            try {
                System.out.print("Please, enter an option: ");
                int option = scanner.nextInt();
                if (option == 1) { // if-else statements to call for functions according to users' options
                    purchaseProducts();
                } else if (option == 2) {
                    seeMyOrders();
                } else {
                    break;
                }
            } catch (InputMismatchException se) { // catches an exception if there is any
                scanner.nextLine();
            }
            catch (Exception ve) { // catches an exception if there is any
                System.out.println(ve.getMessage());
            }

        }
    }


    public void purchaseProducts(){
        System.out.println("Please, enter your name: ");
        String name = scanner.next();
        System.out.println("Please, enter your phone: ");
        String phone = scanner.next();
        getAllproducts();
        String response = controller.createCustomer(name, phone);
        int customer_id= getCustomer(name, phone);
        boolean check= true;
        while(check == true){
            System.out.println("Enter product id: ");
            int product_id = scanner.nextInt();
            controller.makeOrder(customer_id, product_id);
            System.out.println("Do you want to purchase more products? then input 'yes', otherwise 'no' ");
            String answer = scanner.next();
            if(answer.equals("yes")){
                check = false;
            }
        }
    }

    public void getAllproducts(){
        String response = controller.gettingCustomersAllProducts();
        System.out.println(response);
    }

    public int getCustomer(String name, String phone){
        int customer_id = controller.getCustomer(name, phone);
        return customer_id;
    }

    public void seeMyOrders() {
        System.out.println("Please, enter the name: ");
        String name = scanner.next();
        System.out.println("Please, Enter the phone number: ");
        String phone = scanner.next();
        controller.seeMyOrders(name, phone);
    }
}