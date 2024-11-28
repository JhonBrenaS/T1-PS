package pe.edu.cibertec.T1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "tipocliente")
public class TipoCliente implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "tipocliente_id")
    private int id;

    @Column(name = "tipocliente_nombre")
    private String nombre;
}
