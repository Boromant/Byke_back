package com.group.byke.service;


import com.group.byke.domains.EntitySucces;
import com.group.byke.dto.SuccesResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ISuccesService {

    List<SuccesResponse> listerSuccess(@RequestParam("id") int numUtil);
    EntitySucces listerSucces(@RequestParam("id") int numSucces);
    void updateSucces(@RequestBody EntitySucces unS);
    void deleteSucces(EntitySucces unS);
}
