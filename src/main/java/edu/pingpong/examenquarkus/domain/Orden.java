package edu.pingpong.examenquarkus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "t_ordenes")
public class Orden extends PanacheEntityBase{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ord_id")
    public Long id;

    @OneToOne
    @JoinColumn(name = "ord_user")
    public Usuaria usuaria; 

    @OneToOne 
    @JoinColumn(name = "ord_item")
    public Item item;

    public Orden() {}

    public Orden(Usuaria usuaria, Item item) {
        this.usuaria = usuaria;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public Usuaria getUser() {
        return usuaria;
    }

    public void setUser(Usuaria usuaria) {
        this.usuaria = usuaria;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
