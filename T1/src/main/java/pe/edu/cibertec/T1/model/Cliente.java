package pe.edu.cibertec.T1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "cliente")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "cliente_id")
    private int id;

    @Column(name = "cliente_nombre")
    private String nombre;

    @Column(name = "cliente_apellidoPaterno")
    private String apellidoPaterno;

    @Column(name = "cliente_apellidoMaterno")
    private String apellidoMaterno;

    @Column(name = "cliente_direccion")
    private String direccion;

    @Column(name = "cliente_telefono")
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "tipoCliente_id", nullable = false)
    private TipoCliente tipoCliente;
}
