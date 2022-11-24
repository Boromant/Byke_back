package com.group.byke.domains;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "etape", schema = "byke")
public class EntityEtape {
    private Integer id_etape;
    private Integer num_etape;
    private Integer num_sortie;
    private String nom_etape;
    private Float latitude;
    private Float longitude;
    private EntitySortie sortieByNum_sortie;

    @Id
    @Column(name = "id_etape", nullable = false)
    public Integer getId_etape() {
        return id_etape;
    }

    public void setId_etape(Integer id_etape) {
        this.id_etape = id_etape;
    }

    @Basic
    @Column(name = "num_etape",insertable =false, updatable=false, nullable = false)
    public Integer getNum_etape() {
        return num_etape;
    }

    public void setNum_etape(Integer num_etape) {
        this.num_etape = num_etape;
    }

    @Basic
    @Column(name = "num_sortie",insertable =false, updatable=false, nullable = false)
    public Integer getNum_sortie() {
        return num_sortie;
    }

    public void setNum_sortie(Integer num_sortie) {
        this.num_sortie = num_sortie;
    }


    @Basic
    @Column(name = "nom_etape", nullable = false, length = 50)
    public String getNom_etape() {
        return nom_etape;
    }

    public void setNom_etape(String nom_etape) {
        this.nom_etape = nom_etape;
    }

    @Basic
    @Column(name = "latitude", nullable = false, precision = 14)
    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude", nullable = false, precision = 14)
    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityEtape that = (EntityEtape) o;
        return Objects.equals(id_etape, that.id_etape) &&
                Objects.equals(num_etape, that.num_etape) &&
                Objects.equals(num_sortie, that.num_sortie) &&
                Objects.equals(nom_etape, that.nom_etape) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(longitude, that.longitude);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_etape, num_etape, num_sortie, nom_etape, latitude, longitude);
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "num_sortie", referencedColumnName = "num_sortie", nullable = false)
    public EntitySortie getSortieByNum_sortie() {
        return sortieByNum_sortie;
    }

    public void setSortieByNum_sortie(EntitySortie sortieByNum_sortie) {
        this.sortieByNum_sortie = sortieByNum_sortie;
    }

}
