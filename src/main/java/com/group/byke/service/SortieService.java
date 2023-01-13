package com.group.byke.service;

import com.group.byke.domains.EntitySortie;
import com.group.byke.repositories.EntitySortieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Service
public class SortieService implements ISortieService {

    private final EntitySortieRepository unSortieRepository;

    @Autowired
    public SortieService(EntitySortieRepository SortieRepository) {
        this.unSortieRepository = SortieRepository;
    }

    // AFFICHAGE
    @Override
    public EntitySortie listerSortie(@RequestParam("id") int num_sortie) {
        try {
            return unSortieRepository.findById(num_sortie).get();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return null;
    }
    @Override
    public List<EntitySortie> listerSorties(@RequestParam("id") int num_util) {
        try {
            return unSortieRepository.getSorties(num_util);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return null;
    }
    @Override
    public String getDureeSortie(@RequestParam("id") int num_sortie) {
        try {
            EntitySortie unS = listerSortie(num_sortie);
            long millis = unS.getHeure_arrivee().getTime() - unS.getHeure_depart().getTime();
            long heures = TimeUnit.MILLISECONDS.toHours(millis);
            long minutes = TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis));
            long secondes = TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis));

            if(heures == 0){
                if(minutes == 0){
                    return secondes + " sec";
                }
                return minutes + "min " + secondes + " sec";
            }else if(secondes == 0){
                return heures + "h " + minutes + "min";
            }else{
                return heures + "h " + minutes + "min " + secondes + " sec";
            }
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return "0sec";
    }
    @Override
    public float getDistanceSortie(@RequestParam("id") int num_sortie) {
        try {
            EntitySortie unS = listerSortie(num_sortie);
            return unS.getDistance_parcourue();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return 0;
    }
    @Override
    public String getDateSortie(@RequestParam("id") int num_sortie) {
        try {
            EntitySortie unS = listerSortie(num_sortie);
            SimpleDateFormat f = new SimpleDateFormat("dd MMMM yyyy", Locale.FRENCH);
            return f.format(unS.getDate_sortie());
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return "";
    }

    // CREATION
    public void createSortie(EntitySortie unS) {
        try {
            unSortieRepository.save(unS);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
    }

    // MODIFICATION
    @Override
    public void updateSortie (EntitySortie unS) {
        try {
            unSortieRepository.updateSortie(unS.getNum_sortie(), unS.getDate_sortie(), unS.getHeure_depart(),
                    unS.getHeure_arrivee(), unS.getLieu_depart(), unS.getDistance_parcourue());
        } catch (Exception e) {
           ResponseEntity.notFound().build();
        }
    }

    // SUPPRESSION
    @Override
    public void deleteSortie(EntitySortie unS) {
        try {
            unSortieRepository.delete(unS);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
    }
}
