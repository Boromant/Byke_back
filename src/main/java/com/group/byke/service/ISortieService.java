package com.group.byke.service;


import com.group.byke.domains.EntitySortie;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ISortieService {

    EntitySortie listerSortie(@RequestParam("id") int num_sortie);
    List<EntitySortie> listerSorties(@RequestParam("id") int num_util);
    String getDureeSortie(@RequestParam("id") int num_sortie);
    float getDistanceSortie(@RequestParam("id") int num_sortie);
    String getDateSortie(@RequestParam("id") int num_sortie);
    void updateSortie(@RequestBody EntitySortie unS);
    void deleteSortie(EntitySortie unS);
}



