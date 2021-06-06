package edu.pingpong.activerecordmultipletables.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "t_items")
public class Items extends PanacheEntityBase{
    
    @Id 
    @Column(name = "item_name")
    public String item_name;
    
    @Column(name = "item_prop")
    public int item_prop;

    @Column(name = "item_type")
    public String item_type;

    public Items() {}

    public Items(String item_name, int item_prop, String item_type) {
        this.item_name = item_name;
        this.item_prop = item_prop;
        this.item_type = item_type;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getItem_prop() {
        return item_prop;
    }

    public void setItem_prop(int item_prop) {
        this.item_prop = item_prop;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    @Override
    public String toString() {
        return "Items [item_name=" + item_name + ", item_prop=" + item_prop + ", item_type=" + item_type + "]";
    }
}
