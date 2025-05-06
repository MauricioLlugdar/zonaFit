package zona_fit.data;

import zona_fit.connection.Connect;
import zona_fit.domain.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDao implements IClientDao {
    @Override
    public List<Client> showClients() {
        List<Client> clients = new ArrayList<>();
        PreparedStatement ps; // Prepared the sql sentence that its going to impact in the db
        ResultSet rs; // It let us rcv the info of our consult to the db
        Connection conn = Connect.getConnection();
        var sql = "SELECT * FROM client ORDER BY id";
        try{
            ps = conn.prepareStatement(sql); // Prepare Stm w the db
            rs = ps.executeQuery(); // Execute the stm
            while(rs.next()){
                Client client = new Client(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getInt("membership")
                );
                clients.add(client); // Save all the clients
            }
        }catch (SQLException e){
            System.out.println("Error listing the clients " + e.getMessage());
        } finally {
            Connect.closeConnection(conn);
        }
        return clients;
    }

    @Override
    public Client searchClientById(int id) {
        PreparedStatement ps;
        ResultSet rs;
        Connection conn = Connect.getConnection();
        Client client = null;
        var sql = "SELECT * FROM client WHERE client.id = ?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                client = new Client(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getInt("membership")
                );
            }
        }catch(SQLException e){
            System.out.println("Error while searching for a client by id" + e.getMessage());
        }
        return client;
    }

    @Override
    public boolean addClient(Client client) {
        PreparedStatement ps; // Prepared the sql sentence that its going to impact in the db
        Connection conn = Connect.getConnection();
        int rs = 0;
        var sql = "INSERT INTO client (id, name, lastName, membership) VALUES (?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, client.getId()); // Add client.getId into the sql query in the position 1
            ps.setString(2, client.getName());
            ps.setString(3, client.getLastName());
            ps.setInt(4, client.getMembership());
            rs = ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error while adding a client " + e.getMessage());
        }finally {
            Connect.closeConnection(conn);
        }
        return (rs == 1);
    }

    @Override
    public boolean modifyClient(Client client) {
        return false;
    }

    @Override
    public boolean deleteClient(Client client) {
        return false;
    }

    public static void main(String[] args) {
        IClientDao clientDao = new ClientDao();
        Client clientEdu = new Client("Candelaria2", "Chapuis2", 2);
        System.out.println("***Add Client");
        if(!clientDao.addClient(clientEdu)) System.out.println("Impossible to add");
        System.out.println("***List Clients***");
        List<Client> clients = clientDao.showClients();
        for(Client client: clients){
            System.out.println(client.toString());
        }
        Client clientFound = clientDao.searchClientById(1);
        if(clientFound == null){
            System.out.println("Client not found with id " + 1);
        } else{
            System.out.println(("The client found was: " + clientFound.toString()));
        }
    }
}


