package com.group.byke.service;


import com.group.byke.domains.EntityEtape;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IEtapeService {
    EntityEtape listerEtape(@RequestParam("id") int num_sortie,
                                         @RequestParam("ide") int num_etape);
    List<EntityEtape> listerEtapes(@RequestParam("id") int num_sortie);
    void updateEtape(@RequestBody EntityEtape unE);
    void deleteEtape (EntityEtape unE);
}



