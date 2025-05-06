package zona_fit.data;

import zona_fit.domain.Client;
import java.util.List;

public interface IClientDao {
    List<Client> showClients();
    Client searchClientById(int id);
    boolean addClient(Client client);
    boolean modifyClient(Client client);
    boolean deleteClient(Client client);
}
