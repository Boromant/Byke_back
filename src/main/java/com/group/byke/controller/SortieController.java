package com.group.byke.controller;

import com.group.byke.domains.EntitySortie;
import com.group.byke.service.SortieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/sortie")
public class SortieController {
    @Autowired
    private SortieService unSortieService;

    // AFFICHAGE
    @GetMapping("/getSortie")
    public EntitySortie getSortie(@RequestParam("id") int num_sortie) {
        EntitySortie maSortie = null;
        try {
            maSortie = unSortieService.listerSortie(num_sortie);

        }
        catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return maSortie;

    }

    @GetMapping("/getSorties")
    public List<EntitySortie> getSorties(@RequestParam("id") int num_util) {
        List<EntitySortie> mesSorties = null;
        try {
            mesSorties = unSortieService.listerSorties(num_util);

        }
        catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesSorties;

    }

    @GetMapping("/getDureeSortie")
    public String getDureeSortie(@RequestParam("id") int num_sortie) {
        String maDuree = null;
        try {
            maDuree = unSortieService.getDureeSortie(num_sortie);

        }
        catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return maDuree;

    }

    @GetMapping("/getDistanceSortie")
    public float getDistanceSortie(@RequestParam("id") int num_sortie) {
        float maDistance = 0.0f;
        try {
            maDistance = unSortieService.getDistanceSortie(num_sortie);

        }
        catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return maDistance;

    }

    @GetMapping("/getDateSortie")
    public String getDateSortie(@RequestParam("id") int num_sortie) {
        String maDate = "";
        try {
            maDate = unSortieService.getDateSortie(num_sortie);

        }
        catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return maDate;

    }

    // CREATION
    @PostMapping(path ="/creation", consumes = "application/json")
    public ResponseEntity<?> createSortie(@RequestBody EntitySortie unS) {
        try {
            unSortieService.createSortie(unS);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }
    

    // MODIFICATION
    @PostMapping(path ="/modification",  consumes = "application/json")
    public ResponseEntity<?> updateSortie(@RequestBody EntitySortie unS) {
        try {
            unSortieService.updateSortie(unS);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }

    // SUPPRESSION
    @PostMapping(path ="/suppression", consumes = "application/json")
    public ResponseEntity<?> deleteSortie(@RequestBody EntitySortie unS) {
        try {
            unSortieService.deleteSortie(unS);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }
}
