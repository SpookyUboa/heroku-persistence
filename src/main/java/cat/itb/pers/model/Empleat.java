package cat.itb.pers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Empleat {
    @Id
    private int id;
    private String nom;
    private String email;
    private String telefon;
    private boolean esDirectiu;
    @ManyToOne
    @JoinColumn(name = "deptid", nullable = false)
    private Departament departament;
}
