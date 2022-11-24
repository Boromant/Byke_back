package com.group.byke.service;


import com.group.byke.domains.EntityEtape;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IEtapeService {

    public List<EntityEtape> listerEtapesSortie(@RequestParam("id") int num_sortie);
    public void updateEtape(@RequestBody EntityEtape unE);
}



