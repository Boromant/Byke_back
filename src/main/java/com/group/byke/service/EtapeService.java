package com.group.byke.service;

import com.group.byke.domains.EntityEtape;
import com.group.byke.repositories.EntityEtapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class EtapeService implements IEtapeService {

    private EntityEtapeRepository unEtapeRepository;

    @Autowired
    public EtapeService(EntityEtapeRepository EtapeRepository) {
        this.unEtapeRepository = EtapeRepository;
    }

    @Override
    public List<EntityEtape> listerEtapesSortie(@RequestParam("id") int num_sortie) {
        String destinationPage = "";
        List<EntityEtape> mesEtapes = null;
        try {
            mesEtapes = unEtapeRepository.listerEtapesSortie(num_sortie);

        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesEtapes;
    }

    @Override
    public void updateEtape (EntityEtape unE)
    {
        try {
            unEtapeRepository.updateEtape(unE.getId_etape(), unE.getNum_etape(), unE.getNum_sortie(),
                    unE.getNom_etape(), unE.getLatitude(), unE.getLongitude());
        } catch (Exception e) {
           ResponseEntity.notFound().build();
        }
    }
}
