package com.group.byke.domains;


import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "succes", schema = "byke")
public class EntitySucces {
    private Integer numSucces;
    private String nomSucces;

    @Id
    @Column(name = "numSucces", nullable = false)
    public Integer getNumSucces() {
        return numSucces;
    }

    public void setNumSucces(Integer numSucces) {
        this.numSucces = numSucces;
    }

    @Basic
    @Column(name = "nomSucces",insertable =false, updatable=false, nullable = false)
    public String getNomSucces() {
        return nomSucces;
    }

    public void setNomSucces(String nomSucces) {
        this.nomSucces = nomSucces;
    }

    private Set<EntitySuccesUsers> entitySuccesUsers = new HashSet<>();
    
    @OneToMany(mappedBy = "succes")
    public Set<EntitySuccesUsers> getEntitySuccesUsers() {
        return entitySuccesUsers;
    }
    public void setEntitySuccesUsers(Set<EntitySuccesUsers> entitySuccesUsers) {
        this.entitySuccesUsers = entitySuccesUsers;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntitySucces that = (EntitySucces) o;
        return Objects.equals(numSucces, that.numSucces) &&
                Objects.equals(nomSucces, that.nomSucces);
    }

    @Override
    public int hashCode() {

        return Objects.hash(numSucces, nomSucces);
    }
}
