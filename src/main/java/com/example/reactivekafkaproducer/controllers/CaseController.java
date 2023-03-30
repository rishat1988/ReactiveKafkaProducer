package com.test.kakfaproducer.controllers;

import com.test.kakfaproducer.dtos.CaseDto;
import com.test.kakfaproducer.dtos.CaseViewDto;
import com.test.kakfaproducer.services.CaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("case")
public class CaseController {

    private final CaseService caseService;

    @PostMapping
    public Mono<ResponseEntity<CaseViewDto>> createCase(@RequestBody CaseDto caseDto) {
        return caseService.createCaseService(caseDto)
                .map(ResponseEntity::ok);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<CaseViewDto>> getCaseById(@PathVariable long id) {
        return caseService.getCaseById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
