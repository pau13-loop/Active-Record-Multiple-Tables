package edu.pingpong.activerecordmultipletables.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "t_orders")
public class Orders extends PanacheEntityBase {

    // Los id's autogenerados no se deben pasar como parámetro o devolverá un error
    // Tampoco se deben añadir en el constructor ya que como hemos dicho los autogenera
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ord_id")
    public Long id;

    // No me deja al haber "<name>" como duplicated KEY
    // @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @OneToOne
    @JoinColumn(name = "ord_user")
    public Users users;

    // RELACIÓN UNIDIRECCIONAL
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "ord_item")
    public Items items;

    public Orders() {
    }

    public Orders(Users users, Items items) {
        this.users = users;
        this.items = items;
    }

    public Long getId() {
        return id;
    }
}
