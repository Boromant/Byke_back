package com.group.byke.controller;

import com.group.byke.domains.EntityEtape;
import com.group.byke.service.EtapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/etape")
public class EtapeController {
    @Autowired
    private EtapeService unEtapeService;


    @GetMapping("/getEtapes")
    public List<EntityEtape> getEtapesBySortie(@RequestParam("id") int num_sortie) {
        return unEtapeService.listerEtapesSortie(num_sortie);
    }


    @PostMapping(path ="/modification",  consumes = "application/json")
    public ResponseEntity updateEtape(@RequestBody EntityEtape unE) {
        try {
            unEtapeService.updateEtape(unE);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}