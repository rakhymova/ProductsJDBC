package kz.aitujava;

import kz.aitujava.idbINTerface;
import java.sql.*;

public class OrderRepositories implements RepositoryInterface {
    private final idbINTerface db;

    public OrderRepositories(idbINTerface db) {
        this.db = db;
    }

    @Override
    public String gettingCustomersAllProducts() {
        Connection con =null;
        try {
            con = db.getConnection();
            String sql_query = "select * from product"; // initializing sql 'select from' query
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql_query); // call for 'executeQuery()' function to execute SQL 'select from' Query
            while (rs.next()) {
                System.out.println("[ id: " + rs.getInt("product_id")
                        + ", Name: "+ rs.getString("product_name")
                        + ", Price: "+ rs.getString("price")+"]");
            }
        } catch (SQLException throwables) { // catches an exception if there is any
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) { // catches an exception if there is any
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) { // catches an exception if there is any
                throwables.printStackTrace();
            }
        }

        return "";
    }

    @Override
    public boolean creatingtheCustomer(String name, String phone) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "insert into orders(customer_name,customer_phone) values (?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, name);
            st.setString(2, phone);

            st.execute(); // call for 'execute()' function to execute SQL 'Insert into' Query
            return true; // if query has been executed then it returns true
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) { // catches an exception if there is any
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) { // catches an exception if there is any
                throwables.printStackTrace();
            }
        }
        return false; // if query has not been executed then it returns false
    }

    @Override
    public int getCustomer(String name, String phone) {
        Connection con = null;
        try {

            con = db.getConnection();
            String sql = "select order_id from orders where customer_name = ? and customer_phone = ? ";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1,name);
            st.setString(2,phone);

            ResultSet rs = st.executeQuery(); // call for 'executeQuery()' function to execute SQL 'select from' Query
            if (rs.next()) {
                int id =  rs.getInt("order_id");
                return id; // if connection issuccessfull it will return id
            }
        } catch (SQLException throwables) { // catches an exception if there is any
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) { // catches an exception if there is any
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) { // catches an exception if there is any
                throwables.printStackTrace();
            }
        }
        return 0; // if connection is not successful it will return 0;
    }

    @Override
    public boolean makeOrder(int customer_id, int product_id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "insert into order_details(order_id,product_id) values (?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, customer_id);
            st.setInt(2, product_id);

            st.execute();
            return true; // if query has been executed then it returns true
        } catch (SQLException throwables) { // catches an exception if there is any
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) { // catches an exception if there is any
                throwables.printStackTrace();
            }
        }
        return false; // if query has not been executed then it returns false
    }


    @Override
    public String ToSeeAllOrders(String name, String phone) {
        Connection  con =null;
        try {
            con = db.getConnection();
            String sql = "select orders.order_id, product.product_name, product.price from orders inner join order_details on orders.order_id = order_details.order_id inner join product on order_details.product_id = product.product_id where orders.customer_name = ? and orders.customer_phone = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1,name);
            st.setString(2,phone);

            ResultSet rs = st.executeQuery();

            while (rs.next()){
                System.out.println("[Order_id: " + rs.getInt("order_id")
                        + " , Product_Name: "+ rs.getString("product_name")
                        + " , Product_Price: "+ rs.getInt("price")+"]");
            }
        } catch (SQLException throwables) { // catches an exception if there is any
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) { // catches an exception if there is any
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) { // catches an exception if there is any
                throwables.printStackTrace();
            }
        }
        return "";
    }
}