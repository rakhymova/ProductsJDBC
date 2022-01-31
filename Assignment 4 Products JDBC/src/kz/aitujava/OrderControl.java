package kz.aitujava;

import kz.aitujava.RepositoryInterface;

public class OrderControl {
    private final RepositoryInterface repo; // connection with repository interface

    public OrderControl(RepositoryInterface repo) { //constructor to initialize 'repo'
        this.repo = repo;
    }

    public String gettingCustomersAllProducts() {
        return repo.gettingCustomersAllProducts();
    }

    public String createCustomer(String name, String phone) {

        boolean created = repo.creatingtheCustomer(name, phone);

        if (created==true) {
            return "Customer was created";
        } else {
            return "Failed to create a customer.";
        }
    }

    public String makeOrder(int customer_id, int product_id) {
        boolean purchase = repo.makeOrder(customer_id,product_id);
        if (purchase==true) {
            return "You have successfully placed an order!";
        } else {
            return "Failed order";
        }
    }

    public void seeMyOrders(String name, String phone) {
        System.out.println(repo.ToSeeAllOrders(name, phone));
    }

    public int getCustomer(String name, String phone){
        int customer_id = repo.getCustomer(name, phone);
        return  customer_id;
    }
}
