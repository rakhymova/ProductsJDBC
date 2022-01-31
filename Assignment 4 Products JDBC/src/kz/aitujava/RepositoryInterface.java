package kz.aitujava;

public interface RepositoryInterface { // Repository interface

    int getCustomer(String name, String phone);
    boolean creatingtheCustomer(String name, String phone);
    boolean makeOrder(int customer_id, int product_id);
    String gettingCustomersAllProducts();
    String ToSeeAllOrders(String name, String phone);

}