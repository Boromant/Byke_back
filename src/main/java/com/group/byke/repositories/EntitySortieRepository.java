package com.group.byke.repositories;

import com.group.byke.domains.EntitySortie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;

@Repository
public interface EntitySortieRepository extends JpaRepository<EntitySortie, Integer> {


    @Modifying
    @Transactional
    @Query("UPDATE EntitySortie SET num_util= :num_util ," +
            " date_sortie= :date_sortie ," +
            " heure_depart= :heure_depart ," +
            " heure_arrivee= :heure_arrivee," +
            " lieu_depart= :lieu_depart," +
            " distance_parcourue= :distance_parcourue" +
            " WHERE num_sortie = :num_sortie")
    public int updateSortie(@Param("num_sortie") int id,
                            @Param("date_sortie") Date date_sortie,
                            @Param("heure_depart") Time heure_depart,
                            @Param("heure_arrivee") Time heure_arrivee,
                            @Param("lieu_depart") String lieu_depart,
                            @Param("distance_parcourue") float distance_parcourue);

    @Modifying
    @Transactional
    @Query("DELETE FROM EntitySortie WHERE num_sortie = :num_sortie")
    public int deleteSortie(@Param("num_sortie") int num_sortie);

}