package kz.aitujava;

import kz.aitujava.idbINTerface;
import kz.aitujava.OrderRepositories;
import kz.aitujava.RepositoryInterface;
import kz.aitujava.OrderControl;
import kz.aitujava.DatabaseConnection;

public class Main {

    public static void main(String[] args) {
        idbINTerface database = new DatabaseConnection();
        RepositoryInterface repo = new OrderRepositories(database);
        OrderControl controller = new OrderControl(repo);
        Application application = new Application(controller);
        application.start(); // main function 'start' that begins the application
    }
}