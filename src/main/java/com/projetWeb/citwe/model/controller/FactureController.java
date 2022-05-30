package com.projetWeb.citwe.model.controller;

import com.projetWeb.citwe.model.dto.FactureDto;
import com.projetWeb.citwe.model.entities.Facture;
import com.projetWeb.citwe.model.mapper.FactureMapper;
import com.projetWeb.citwe.model.service.FactureService;
import com.sun.tools.javac.util.DefinedBy.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/facture")
@RestController
@Slf4j
@Api("facture")
public class FactureController {
    private final FactureService factureService;

    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated FactureDto factureDto) {
        factureService.save(factureDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FactureDto> findById(@PathVariable("id") String id) {
        FactureDto facture = factureService.findById(id);
        return ResponseEntity.ok(facture);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(factureService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data！");
            return new ResourceNotFoundException();
        });
        factureService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<FactureDto>> pageQuery(FactureDto factureDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<FactureDto> facturePage = factureService.findByCondition(factureDto, pageable);
        return ResponseEntity.ok(facturePage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated FactureDto factureDto, @PathVariable("id") String id) {
        factureService.update(factureDto, id);
        return ResponseEntity.ok().build();
    }
}