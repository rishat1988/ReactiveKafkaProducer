package com.test.kakfaproducer.configs.mapper;

import com.test.kakfaproducer.dtos.CaseDto;
import com.test.kakfaproducer.dtos.CaseViewDto;
import com.test.kakfaproducer.entities.Case;
import org.springframework.stereotype.Service;

@Service
public class CaseMapper {

    public static CaseViewDto buildCaseViewDto(Case caseEntity) {
        return CaseViewDto.builder()
                .id(caseEntity.getId())
                .number(caseEntity.getNumber())
                .caseStartTime(caseEntity.getStartTime())
                .description(caseEntity.getDescription())
                .communication(caseEntity.getCommunication())
                .build();
    }

    public static void enrichCaseDto(CaseViewDto caseViewDto, CaseDto caseDto)
    {
        caseDto.getCaseLogDtoList().forEach(cld -> cld.setCaseId(caseViewDto.getId()));
    }

    public static Case buildCase(CaseDto caseDto) {
        return Case.builder()
                .number(caseDto.getNumber())
                .startTime(caseDto.getStartTime())
                .description(caseDto.getDescription())
                .communication(caseDto.getCommunication())
                .build();
    }

}
