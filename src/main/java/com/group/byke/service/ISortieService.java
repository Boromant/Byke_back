package com.group.byke.service;


import com.group.byke.domains.EntitySortie;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface ISortieService {

    public List<EntitySortie> listerSorties();
    public void updateSortie(@RequestBody EntitySortie unS);
    public void deleteSortie(EntitySortie unS);
}



