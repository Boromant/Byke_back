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

    @GetMapping("/getEtape")
    public EntityEtape getEtapeBySortie(@RequestParam("id") int num_sortie, @RequestParam("ide") int num_etape) {
        EntityEtape maEtape = null;
        try {
            maEtape = unEtapeService.listerEtape(num_sortie, num_etape);

        }
        catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return maEtape;

    }

    @GetMapping("/getEtapes")
    public List<EntityEtape> getEtapesBySortie(@RequestParam("id") int num_sortie) {
        return unEtapeService.listerEtapes(num_sortie);
    }

    @PostMapping(path ="/modification",  consumes = "application/json")
    public ResponseEntity<?> updateEtape(@RequestBody EntityEtape unE) {
        try {
            unEtapeService.updateEtape(unE);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path ="/suppression", consumes = "application/json")
    public ResponseEntity<?> deleteSortie(@RequestBody EntityEtape unE) {
        try {
            unEtapeService.deleteEtape(unE);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }
}
