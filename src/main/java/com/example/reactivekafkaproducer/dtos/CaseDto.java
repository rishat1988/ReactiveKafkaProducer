package com.test.kakfaproducer.dtos;

import com.test.kakfaproducer.entities.Communication;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaseDto {

    private String number;
    private String description;
    private LocalDateTime startTime;
    Communication communication;
    List<CaseLogDto> caseLogDtoList;
}
