package zona_fit.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter // Getters w lombok
@Setter // Setters w lombok
@AllArgsConstructor // Create w Lombok a constructor with all the args
public class Client {
    private int id;
    private String name;
    private String lastName;
    private int membership;

    public Client(){}

    // Delete a client
    public Client(int id){
        this.id = id;
    }

    public Client(String name, String lastName, int membership){
        this.name = name;
        this.lastName = lastName;
        this.membership = membership;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", membership=" + membership +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && membership == client.membership && Objects.equals(name, client.name) && Objects.equals(lastName, client.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, membership);
    }
}
