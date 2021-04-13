package cat.itb.pers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuari implements Serializable {
    @Id
    private String username;
    private String password;
    private String rol; //"USER" o "ADMIN"

    public Usuari(String user, String pwd) {
        username = user;
        password = pwd;
        rol = "USER"; //per defecte, tothom és USER
    }
}

