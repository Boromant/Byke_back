package com.group.byke.domains;


import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "sortie", schema = "byke")
public class EntitySortie {
    private Integer num_sortie;
    private Integer num_util;
    private Date date_sortie;
    private Time heure_depart;
    private Time heure_arrivee;
    private String lieu_depart;
    private Float distance_parcourue;
    private Collection<EntityEtape> etapesByNum_sortie;

    @Id
    @Column(name = "num_sortie", nullable = false)
    public Integer getNum_sortie() {
        return num_sortie;
    }

    public void setNum_sortie(Integer num_sortie) {
        this.num_sortie = num_sortie;
    }

    @Basic
    @Column(name = "num_util",insertable =false, updatable=false, nullable = false)
    public Integer getNum_util() {
        return num_util;
    }

    public void setNum_util(Integer num_util) {
        this.num_util = num_util;
    }

    @Basic
    @Column(name = "date_sortie",insertable =false, updatable=false, nullable = false)
    public Date getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(Date date_sortie) {
        this.date_sortie = date_sortie;
    }

    @Basic
    @Column(name = "heure_depart",insertable =false, updatable=false, nullable = false)
    public Time getHeure_depart() {
        return heure_depart;
    }

    public void setHeure_depart(Time heure_depart) {
        this.heure_depart = heure_depart;
    }

    @Basic
    @Column(name = "heure_arrivee",insertable =false, updatable=false, nullable = false)
    public Time getHeure_arrivee() {
        return heure_arrivee;
    }

    public void setHeure_arrivee(Time heure_arrivee) {
        this.heure_arrivee = heure_arrivee;
    }

    @Basic
    @Column(name = "lieu_depart",insertable =false, updatable=false, nullable = false)
    public String getLieu_depart() {
        return lieu_depart;
    }

    public void setLieu_depart(String lieu_depart) {
        this.lieu_depart = lieu_depart;
    }

    @Basic
    @Column(name = "distance_parcourue",insertable =false, updatable=false, nullable = false)
    public Float getDistance_parcourue() {
        return distance_parcourue;
    }

    public void setDistance_parcourue(Float distance_parcourue) {
        this.distance_parcourue = distance_parcourue;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntitySortie that = (EntitySortie) o;
        return Objects.equals(num_sortie, that.num_sortie) &&
                Objects.equals(num_util, that.num_util) &&
                Objects.equals(date_sortie, that.date_sortie) &&
                Objects.equals(heure_depart, that.heure_depart) &&
                Objects.equals(heure_arrivee, that.heure_arrivee) &&
                Objects.equals(lieu_depart, that.lieu_depart) &&
                Objects.equals(distance_parcourue, that.distance_parcourue);
    }

    @Override
    public int hashCode() {

        return Objects.hash(num_sortie, num_util, date_sortie, heure_depart, heure_arrivee, lieu_depart, distance_parcourue);
    }

    @OneToMany(mappedBy = "sortieByNum_sortie", cascade = CascadeType.REMOVE)
    public Collection<EntityEtape> getEtapesByNum_sortie() {
        return etapesByNum_sortie;
    }

    public void setEtapesByNum_sortie(Collection<EntityEtape> etapesByNum_sortie) {
        this.etapesByNum_sortie = etapesByNum_sortie;
    }
}
