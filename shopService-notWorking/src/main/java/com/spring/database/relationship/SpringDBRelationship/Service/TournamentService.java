package com.spring.database.relationship.SpringDBRelationship.Service;


import com.spring.database.relationship.SpringDBRelationship.Entity.Registration;
import com.spring.database.relationship.SpringDBRelationship.Entity.Tournament;
import com.spring.database.relationship.SpringDBRelationship.Repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {
    @Autowired
    private TournamentRepository tournamentRepository;

    public List<Tournament> getAllTournament(){
        return tournamentRepository.findAll();
    }

    public Tournament getTournamentById(int id){
        return tournamentRepository.findById(id).get();
    }

    public Tournament addTournament(Tournament tournament){
        return tournamentRepository.save(tournament);
    }

    public void deleteTournamentById(int id){
        tournamentRepository.deleteById(id);
    }

    public Tournament addRegisterationById(int id , Registration registeration){
        Tournament tournament = tournamentRepository.findById(id).get();
        tournament.addRegistration(registeration);
        return tournamentRepository.save(tournament);
    }

    public Tournament deleteRegisterationById(int id , Registration registeration){
        Tournament tournament = tournamentRepository.findById(id).get();
        tournament.deleteRegistration(registeration);
        return tournamentRepository.save(tournament);
    }
}
