package com.spring.database.relationship.SpringDBRelationship.Controller;

import com.spring.database.relationship.SpringDBRelationship.Entity.Registration;
import com.spring.database.relationship.SpringDBRelationship.Entity.Tournament;
import com.spring.database.relationship.SpringDBRelationship.Service.TournamentService;
import com.spring.database.relationship.SpringDBRelationship.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {
    @Autowired
    TournamentService tournamentService;

    @Autowired
    RegistrationService registerationService;

    @GetMapping // take default url.
    public List<Tournament> getAllTournaments(){
        return tournamentService.getAllTournament();
    }

    @GetMapping(value = "/{id}")
    public Tournament getTournamentByID(@PathVariable("id") int ID){
        return tournamentService.getTournamentById(ID); // PathVariable Define in Controller
    }

    @PostMapping
    //@RequestMapping(method = RequestMethod.POST)
    public Tournament addTournament(@RequestBody Tournament tournament){
        return tournamentService.addTournament(tournament);
    }

    @DeleteMapping("/{id}")
    public void deleteTournament(@PathVariable int id){
        tournamentService.deleteTournamentById(id);
    }

    @PutMapping("/{id}/registration/{reg_id}") // This from Player Entity
    public Tournament assignRegistration(@PathVariable int id, @PathVariable int reg_id){
        Registration reg = registerationService.getRegistrationById(reg_id);
        return tournamentService.addRegisterationById(id,reg);
    }

    @DeleteMapping("/{id}/registration/{reg_id}") // This from Player Entity
    public Tournament deleteRegistration(@PathVariable int id, @PathVariable int reg_id){
        Registration reg = registerationService.getRegistrationById(reg_id);
        return tournamentService.deleteRegisterationById(id,reg);
    }


}
