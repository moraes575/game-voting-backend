package com.moraes.gamevotingbackend.repositories;

import com.moraes.gamevotingbackend.models.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

    @Query("SELECT record FROM Record record WHERE " +
            "(coalesce(:minDate, NULL) IS NULL OR record.moment >= :minDate) AND " +
            "(coalesce(:maxDate, NULL) IS NULL OR record.moment <= :maxDate)")
    Page<Record> findByMoment(Instant minDate, Instant maxDate, Pageable pageable);

}
