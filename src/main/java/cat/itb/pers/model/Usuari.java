package cat.itb.pers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuari implements Serializable {
    private String username;
    private String password;
    private String rol; //"USER" o "ADMIN"

    public Usuari(String user, String pwd) {
        username = user;
        password = pwd;
        rol = "USER"; //per defecte, tothom és USER
    }
}

