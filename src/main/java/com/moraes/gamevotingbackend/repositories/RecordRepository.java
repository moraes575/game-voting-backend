package com.moraes.gamevotingbackend.repositories;

import com.moraes.gamevotingbackend.models.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

}
