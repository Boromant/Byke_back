package com.group.byke.controller;

import com.group.byke.domains.EntitySucces;
import com.group.byke.dto.SuccesResponse;
import com.group.byke.service.SuccesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/succes")
public class SuccesController {
    @Autowired
    private SuccesService unSuccesService;

    // AFFICHAGE
    @GetMapping("/getSucces")
    public EntitySucces getSucces(@RequestParam("id") int numSucces) {
        EntitySucces maSucces = null;
        try {
            maSucces = unSuccesService.listerSucces(numSucces);

        }
        catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return maSucces;

    }

    @GetMapping("/getSuccess")
    public List<SuccesResponse> getSuccess(@RequestParam("id") int numUtil) {
        List<SuccesResponse> mesSuccess = null;
        try {
            mesSuccess = unSuccesService.listerSuccess(numUtil);

        }
        catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesSuccess;

    }

    // MODIFICATION
    @PostMapping(path ="/modification",  consumes = "application/json")
    public ResponseEntity<?> updateSucces(@RequestBody EntitySucces unS) {
        try {
            unSuccesService.updateSucces(unS);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }

    // SUPPRESSION
    @PostMapping(path ="/suppression", consumes = "application/json")
    public ResponseEntity<?> deleteSucces(@RequestBody EntitySucces unS) {
        try {
            unSuccesService.deleteSucces(unS);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }
}
