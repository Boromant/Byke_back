package com.group.byke.repositories;

import com.group.byke.domains.EntityEtape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface EntityEtapeRepository extends JpaRepository<EntityEtape, Integer> {

    @Query("Select E.id_etape, E.num_etape, E.num_sortie, S.date_sortie, S.lieu_depart,"
            + " E.nom_etape, E.latitude, E.longitude"
            + " from EntityEtape E, EntitySortie S"
            + " where E.num_sortie = S.num_sortie"
            + " and E.num_sortie = :num_sortie"
            + " and E.num_etape = :num_etape")
    EntityEtape listerEtape(@Param("num_sortie") int id, @Param("num_etape") int ide);

    @Query("Select E.id_etape, E.num_etape, E.num_sortie, S.date_sortie, S.lieu_depart,"
            + " E.nom_etape, E.latitude, E.longitude"
            + " from EntityEtape E, EntitySortie S"
            + " where E.num_sortie = S.num_sortie"
            + " and E.num_sortie = :num_sortie")
    List<EntityEtape> listerEtapes(@Param("num_sortie") int id);

    @Modifying
    @Transactional
    @Query("UPDATE EntityEtape SET num_etape= :num_etape ," +
            "num_sortie= :num_sortie ," +
            "nom_etape= :nom_etape ," +
            "latitude= :latitude ," +
            "longitude= :longitude " +
            " WHERE id_etape = :id_etape")
    int updateEtape(@Param("id_etape") int id,
                            @Param("num_etape") int num_etape,
                            @Param("num_sortie") int num_sortie,
                            @Param("nom_etape") String nom_etape,
                            @Param("latitude") float latitude,
                            @Param("longitude") float longitude);

}