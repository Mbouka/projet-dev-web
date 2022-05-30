package com.projetWeb.citwe.model.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projetWeb.citwe.model.dto.ChambreDto;

import java.util.Collections;
import java.util.List;

public class ChambreBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static ChambreDto getDto() {
        ChambreDto dto = new ChambreDto();
        dto.setId("1");
        return dto;
    }
}