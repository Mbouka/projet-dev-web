package com.projetWeb.citwe.model.controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.projetWeb.citwe.model.controller.CustomUtils;
import com.projetWeb.citwe.model.controller.FactureController;
import com.projetWeb.citwe.model.dto.FactureDto;
import com.projetWeb.citwe.model.entities.Facture;
import com.projetWeb.citwe.model.mapper.EntityMapper;
import com.projetWeb.citwe.model.mapper.FactureMapper;
import com.projetWeb.citwe.model.service.FactureService;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
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
public class FactureControllerTest {
    private static final String ENDPOINT_URL = "/api/facture";
    @InjectMocks
    private FactureController factureController;
    @Mock
    private FactureService factureService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(factureController)
                //.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                //.addFilter(CustomFilter::doFilter)
                .build();
    }

    @Test
    public void findAllByPage() throws Exception {
        Page<FactureDto> page = new PageImpl<>(Collections.singletonList(FactureBuilder.getDto()));

        Mockito.when(factureService.findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(page);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.content", Matchers.hasSize(1)));

        Mockito.verify(factureService, Mockito.times(1)).findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verifyNoMoreInteractions(factureService);

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(factureService.findById(ArgumentMatchers.anyString())).thenReturn(FactureBuilder.getDto());

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(factureService, Mockito.times(1)).findById("1");
        Mockito.verifyNoMoreInteractions(factureService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(factureService.save(ArgumentMatchers.any(FactureDto.class))).thenReturn(FactureBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(FactureBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(factureService, Mockito.times(1)).save(ArgumentMatchers.any(FactureDto.class));
        Mockito.verifyNoMoreInteractions(factureService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(factureService.update(ArgumentMatchers.any(), ArgumentMatchers.anyString())).thenReturn(FactureBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(FactureBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(factureService, Mockito.times(1)).update(ArgumentMatchers.any(FactureDto.class), ArgumentMatchers.anyString());
        Mockito.verifyNoMoreInteractions(factureService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(factureService).deleteById(ArgumentMatchers.anyString());
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomUtils.asJsonString(FactureBuilder.getIds()))).andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(factureService, Mockito.times(1)).deleteById(Mockito.anyString());
        Mockito.verifyNoMoreInteractions(factureService);
    }
}