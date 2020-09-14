package com.moraes.gamevotingbackend.dto;

import com.moraes.gamevotingbackend.models.Record;
import com.moraes.gamevotingbackend.models.enums.Platform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecordDTO {

    private Long id;
    private Instant moment;
    private String name;
    private Integer age;
    private String gameTitle;
    private Platform gamePlatform;
    private String genreName;

    public RecordDTO(Record record) {
        this.id = record.getId();
        this.moment = record.getMoment();
        this.name = record.getName();
        this.age = record.getAge();
        this.gameTitle = record.getGame().getTitle();
        this.gamePlatform = record.getGame().getPlatform();
        this.genreName = record.getGame().getGenre().getName();
    }

}
