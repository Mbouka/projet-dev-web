package com.projetWeb.citwe.model.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class FactureBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static FactureDto getDto() {
        FactureDto dto = new FactureDto();
        dto.setId("1");
        return dto;
    }
}