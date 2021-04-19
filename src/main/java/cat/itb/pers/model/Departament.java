package cat.itb.pers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Departament {
    @Id
    private int id;
    private String nom;
    @OneToMany(mappedBy = "departament")
    private Set<Empleat> empleats;

    public Departament(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
}
