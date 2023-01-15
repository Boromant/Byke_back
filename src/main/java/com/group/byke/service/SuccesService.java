package com.group.byke.service;

import com.group.byke.domains.EntitySucces;
import com.group.byke.dto.SuccesResponse;
import com.group.byke.repositories.EntitySuccesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class SuccesService implements ISuccesService {

    private final EntitySuccesRepository unSuccesRepository;

    @Autowired
    public SuccesService(EntitySuccesRepository SuccesRepository) {
        this.unSuccesRepository = SuccesRepository;
    }

    // AFFICHAGE
    @Override
    public List<SuccesResponse> listerSuccess(@RequestParam("id") int numUtil) {
        try {
            List<SuccesResponse> mesSuccess = unSuccesRepository.listerSuccessUser(numUtil);
            for(SuccesResponse s : mesSuccess){
                Date date = s.getDateObtention();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, 1);
                date = c.getTime();
                s.setDateObtention(date);
            }
            return mesSuccess;
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return null;
    }

    public EntitySucces listerSucces(@RequestParam("id") int numSucces) {
        try {
            return unSuccesRepository.findById(numSucces).get();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return null;
    }


    // MODIFICATION
    @Override
    public void updateSucces (EntitySucces unS) {
        try {
            unSuccesRepository.updateSucces(unS.getNumSucces(), unS.getNomSucces());
        } catch (Exception e) {
           ResponseEntity.notFound().build();
        }
    }

    // SUPPRESSION
    @Override
    public void deleteSucces(EntitySucces unS) {
        try {
            unSuccesRepository.delete(unS);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
    }
}
