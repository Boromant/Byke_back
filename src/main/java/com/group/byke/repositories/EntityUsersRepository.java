package com.group.byke.repositories;

import com.group.byke.domains.EntityUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityUsersRepository extends JpaRepository<EntityUsers, Integer> {

   public EntityUsers rechercheNom(String login);
}
