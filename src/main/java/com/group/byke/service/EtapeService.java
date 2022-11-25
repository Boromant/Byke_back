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

    private final EntityEtapeRepository unEtapeRepository;

    @Autowired
    public EtapeService(EntityEtapeRepository EtapeRepository) {
        this.unEtapeRepository = EtapeRepository;
    }

    // AFFICHAGE
    public EntityEtape listerEtape(@RequestParam("id") int num_sortie, @RequestParam("ide") int num_etape){
        EntityEtape maEtape = null;
        try {
            maEtape = unEtapeRepository.listerEtape(num_sortie, num_etape);

        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return maEtape;
    }
    @Override
    public List<EntityEtape> listerEtapes(@RequestParam("id") int num_sortie) {
        List<EntityEtape> mesEtapes = null;
        try {
            mesEtapes = unEtapeRepository.listerEtapes(num_sortie);

        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesEtapes;
    }

    // MODIFICATION
    @Override
    public void updateEtape (EntityEtape unE) {
        try {
            unEtapeRepository.updateEtape(unE.getId_etape(), unE.getNum_etape(), unE.getNum_sortie(),
                    unE.getNom_etape(), unE.getLatitude(), unE.getLongitude());
        } catch (Exception e) {
           ResponseEntity.notFound().build();
        }
    }

    // SUPPRESSION
    @Override
    public void deleteEtape (EntityEtape unE) {
        try {
            unEtapeRepository.delete(unE);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
    }
}
