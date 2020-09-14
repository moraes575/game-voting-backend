package com.moraes.gamevotingbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecordPostDTO {

    private String name;
    private Integer age;
    private Long gameId;

}
