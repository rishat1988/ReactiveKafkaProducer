package com.test.kakfaproducer.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CaseLogDto {

    long caseId;
    String attributeName;
    Long attributeId;

}
