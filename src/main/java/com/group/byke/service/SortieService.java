package com.group.byke.service;

import com.group.byke.domains.EntitySortie;
import com.group.byke.repositories.EntitySortieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortieService implements ISortieService {

    private EntitySortieRepository unSortieRepository;

    @Autowired
    public SortieService(EntitySortieRepository SortieRepository) {
        this.unSortieRepository = SortieRepository;
    }

    @Override
    public List<EntitySortie> listerSorties() {
        try {
            return unSortieRepository.findAll();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return null;
    }
    @Override
    public void updateSortie (EntitySortie unS)
    {
        try {
            unSortieRepository.updateSortie(unS.getNum_sortie(), unS.getDate_sortie(), unS.getHeure_depart(),
                    unS.getHeure_arrivee(), unS.getLieu_depart(), unS.getDistance_parcourue());
        } catch (Exception e) {
           ResponseEntity.notFound().build();
        }
    }

    @Override
    public void deleteSortie(EntitySortie unS)
    {
        try {
            unSortieRepository.deleteSortie(unS.getNum_sortie());
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
    }
}
