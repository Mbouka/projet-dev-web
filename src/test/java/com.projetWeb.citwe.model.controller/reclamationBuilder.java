package com.projetWeb.citwe.model.controller;

import com.projetWeb.citwe.model.dto.reclamationDto;

import java.util.List;

public class reclamationBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static reclamationDto getDto() {
        reclamationDto dto = new reclamationDto();
        dto.setId("1");
        return dto;
    }
}