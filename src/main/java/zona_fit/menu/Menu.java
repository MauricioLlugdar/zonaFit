package zona_fit.menu;

import java.util.List;
import java.util.Scanner;

import zona_fit.data.ClientDao;
import zona_fit.domain.Client;

public class Menu {
    public static void main(String[] args) {
        boolean exit = false;
        while(!exit) {
            System.out.println("********** Menu of ZonaFit **********");
            System.out.println("  1.Add client\n" +
                    "  2.List clients\n" +
                    "  3.Search client by Id\n" +
                    "  4.Modify client\n" +
                    "  5.Delete client\n" +
                    "  6.Exit");
            System.out.print("Select option in the range (1-5): ");
            int opt;
            Scanner scanner = new Scanner(System.in);
            opt = scanner.nextInt();
            scanner.nextLine();
            ClientDao clientDao = new ClientDao();
            switch (opt) {
                case 1 -> {
                    System.out.println("********** Adding Client **********");
                    System.out.println("Insert the name of the client: ");
                    String name = scanner.nextLine();
                    System.out.println("Insert the last name of the client: ");
                    String lastName = scanner.nextLine();
                    System.out.println("Insert the chosen membership for the client: ");
                    int membership = scanner.nextInt();

                    Client client = new Client(
                            name,
                            lastName,
                            membership
                    );
                    if (clientDao.addClient(client)) {
                        System.out.println("Client " + client.toString() + " succesfully added");
                    } else {
                        System.out.println("Error adding " + client.toString());
                    }
                }
                case 2 -> {
                    System.out.println("********** Listing Clients **********");
                    List<Client> clients = clientDao.showClients();
                    for (Client client : clients) {
                        System.out.println(client.toString());
                    }
                }
                case 3 -> {
                    System.out.println("********** Search Client by id **********");
                    System.out.println("Insert the id of the client to look for: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Client client = clientDao.searchClientById(id);
                    System.out.println("Client " + client.toString() + " found");
                }
                case 4 -> {
                    System.out.println("********** Modifying Client **********");
                    System.out.println("Insert the new name of the client: ");
                    String name = scanner.nextLine();
                    System.out.println("Insert the new last name of the client: ");
                    String lastName = scanner.nextLine();
                    System.out.println("Insert the new chosen membership for the client: ");
                    int membership = scanner.nextInt();

                    Client client = new Client(
                            name,
                            lastName,
                            membership
                    );
                    if (clientDao.modifyClient(client)) {
                        System.out.println("Client " + client.toString() + " succesfully modified");
                    } else {
                        System.out.println("Error modifying " + client.toString());
                    }
                }
                case 5 -> {
                    System.out.println("********** Delete Client by id **********");
                    System.out.println("Insert the id of the client to be deleted: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    if (clientDao.deleteClient(id)) {
                        System.out.println("Client with " + id + " successfully deleted");
                    } else {
                        System.out.println("Error deleting client with id " + id);
                    }
                }
                case 6 -> {
                    exit = true;
                }

                default -> {
                }

            }
        }
    }
}
