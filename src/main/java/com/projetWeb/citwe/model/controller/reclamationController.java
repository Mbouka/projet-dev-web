package com.projetWeb.citwe.model.controller;

import com.projetWeb.citwe.model.dto.reclamationDto;
import com.projetWeb.citwe.model.entities.reclamation;
import com.projetWeb.citwe.model.mapper.reclamationMapper;
import com.projetWeb.citwe.model.service.reclamationService;
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

@RequestMapping("/reclamation")
@RestController
@Slf4j
@Api("reclamation")
public class reclamationController {
    private final reclamationService reclamationService;

    public reclamationController(reclamationService reclamationService) {
        this.reclamationService = reclamationService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated reclamationDto reclamationDto) {
        reclamationService.save(reclamationDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<reclamationDto> findById(@PathVariable("id") Long id) {
        reclamationDto reclamation = reclamationService.findById(id);
        return ResponseEntity.ok(reclamation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Optional.ofNullable(reclamationService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data！");
            return new ResourceNotFoundException();
        });
        reclamationService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<reclamationDto>> pageQuery(reclamationDto reclamationDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<reclamationDto> reclamationPage = reclamationService.findByCondition(reclamationDto, pageable);
        return ResponseEntity.ok(reclamationPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated reclamationDto reclamationDto, @PathVariable("id") Long id) {
        reclamationService.update(reclamationDto, id);
        return ResponseEntity.ok().build();
    }
}