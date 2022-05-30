package com.projetWeb.citwe.model.controller;

import com.projetWeb.citwe.model.dto.ChambreDto;
import com.projetWeb.citwe.model.service.ChambreService;
import com.sun.tools.javac.util.DefinedBy.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/chambre")
@RestController
@Slf4j
@Api("chambre")
public class ChambreController {
    private final ChambreService chambreService;

    public ChambreController(ChambreService chambreService) {
        this.chambreService = chambreService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ChambreDto chambreDto) {
        chambreService.save(chambreDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChambreDto> findById(@PathVariable("id") Long id) {
        ChambreDto chambre = chambreService.findById(id);
        return ResponseEntity.ok(chambre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Optional.ofNullable(chambreService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data！");
            return new ResourceNotFoundException();
        });
        chambreService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<ChambreDto>> pageQuery(ChambreDto chambreDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ChambreDto> chambrePage = chambreService.findByCondition(chambreDto, pageable);
        return ResponseEntity.ok(chambrePage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated ChambreDto chambreDto, @PathVariable("id") Long id) {
        chambreService.update(chambreDto, id);
        return ResponseEntity.ok().build();
    }
}