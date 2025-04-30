package zona_fit.data;

import zona_fit.domain.Client;
import java.util.List;

public interface IClientDao {
    List<Client> showClients();
    boolean searchClientById(Client client);
    boolean addClient(Client client);
    boolean modifyClient(Client client);
    boolean deleteClient(Client client);
}
