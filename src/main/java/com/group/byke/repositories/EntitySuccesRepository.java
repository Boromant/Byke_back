package com.group.byke.repositories;

import com.group.byke.domains.EntitySucces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EntitySuccesRepository extends JpaRepository<EntitySucces, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE EntitySucces SET nomSucces= :nomSucces WHERE numSucces = :numSucces")
    int updateSucces(@Param("numSucces") int id,
                     @Param("nomSucces") String nomSucces);

    @Query("Select s.nomSucces, l.dateObtention from EntitySucces s"
            + " join s.entitySuccesUsers l"
            + " join l.users u"
            + " where u.numUtil = :numUtil")
    List<EntitySucces> listerSuccessUser(@Param("numUtil") int numUtil);
}