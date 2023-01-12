package com.group.byke.service;


import com.group.byke.domains.EntityUsers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface IUsersService {

    List<EntityUsers> listerUsers();
    Optional<EntityUsers> listerUser(@RequestParam("id") int num_util);
    void updateUser(@RequestBody EntityUsers unS);
    void deleteUser(EntityUsers unS);
}



