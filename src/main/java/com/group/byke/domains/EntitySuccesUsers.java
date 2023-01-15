package com.group.byke.domains;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "succesusers", schema = "byke")
public class EntitySuccesUsers implements Serializable {
    private Integer id;
    private Date dateObtention;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "dateObtention")
    public Date getDateObtention() {
        return dateObtention;
    }
    public void setDateObtention(Date dateObtention) {
        this.dateObtention = dateObtention;
    }

    private EntitySucces succes;
    
    @ManyToOne
    @JoinColumn(name = "numSucces", referencedColumnName = "numSucces")
    public EntitySucces getSucces() {
        return succes;
    }
    public void setSucces(EntitySucces succes) {
        this.succes = succes;
    }

    private EntityUsers users;

    @ManyToOne
    @JoinColumn(name = "numUser", referencedColumnName = "numUtil")
    public EntityUsers getUsers() {
        return users;
    }
    public void setUsers(EntityUsers users) {
        this.users = users;
    }
}