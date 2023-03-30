package com.test.kakfaproducer.dtos;

import com.test.kakfaproducer.entities.CaseLog;
import com.test.kakfaproducer.entities.Communication;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CaseViewDto {
    private long id;
    private String number;
    private String description;
    private LocalDateTime caseStartTime;
    Communication communication;
    // for caseLog
    List<CaseLogDto> caseLogDtoList;

}
