package com.projetWeb.citwe.model.controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.projetWeb.citwe.model.controller.CustomUtils;
import com.projetWeb.citwe.model.controller.reclamationController;
import com.projetWeb.citwe.model.dto.reclamationDto;
import com.projetWeb.citwe.model.entities.reclamation;
import com.projetWeb.citwe.model.mapper.EntityMapper;
import com.projetWeb.citwe.model.mapper.reclamationMapper;
import com.projetWeb.citwe.model.service.reclamationService;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;

@Transactional
public class reclamationControllerTest {
    private static final String ENDPOINT_URL = "/api/reclamation";
    @InjectMocks
    private reclamationController reclamationController;
    @Mock
    private reclamationService reclamationService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(reclamationController)
                //.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                //.addFilter(CustomFilter::doFilter)
                .build();
    }


    @Test
    public void save() throws Exception {
        Mockito.when(reclamationService.save(ArgumentMatchers.any(reclamationDto.class))).thenReturn(reclamationBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(reclamationBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(reclamationService, Mockito.times(1)).save(ArgumentMatchers.any(reclamationDto.class));
        Mockito.verifyNoMoreInteractions(reclamationService);
    }


}