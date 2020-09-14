package com.moraes.gamevotingbackend.repositories;

import com.moraes.gamevotingbackend.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
