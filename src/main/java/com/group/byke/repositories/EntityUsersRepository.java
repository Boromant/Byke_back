package com.group.byke.repositories;

import com.group.byke.domains.EntityUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface EntityUsersRepository extends JpaRepository<EntityUsers, Integer> {

   public EntityUsers rechercheNom(String login);

   @Query("Select Max(numUtil) from EntityUsers")
   int getLastNumUtil();

   @Query("Select id from EntityUsers where nomUtil = :nomUtil")
   int getIdByNomUtil(@Param("nomUtil") String nomUtil);
}
