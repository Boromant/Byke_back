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



    @GetMapping("/getSorties")
    public List<EntitySortie> findAllSorties() {
        String destinationPage = "";
        List<EntitySortie> mesSorties = null;
        try {
            mesSorties = unSortieService.listerSorties();

        }
        catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesSorties;

    }


    @PostMapping(path ="/modification",  consumes = "application/json")
    public ResponseEntity updateSortie(@RequestBody EntitySortie unS) {
        try {
            unSortieService.updateSortie(unS);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path ="/suppression")
    public ResponseEntity deleteSortie(@RequestBody EntitySortie unS) {
        try {
            unSortieService.deleteSortie(unS);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }
}