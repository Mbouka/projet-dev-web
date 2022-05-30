package com.projetWeb.citwe.model.controller;

import com.projetWeb.citwe.model.dto.ChambreDto;
import com.projetWeb.citwe.model.service.ChambreService;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Transactional
public class ChambreControllerTest {
    private static final String ENDPOINT_URL = "/api/chambre";
    @InjectMocks
    private ChambreController chambreController;
    @Mock
    private ChambreService chambreService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(chambreController)
                //.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                //.addFilter(CustomFilter::doFilter)
                .build();
    }

    @Test
    public void findAllByPage() throws Exception {
        Page<ChambreDto> page = new PageImpl<>(Collections.singletonList(ChambreBuilder.getDto()));

        Mockito.when(chambreService.findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(page);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.content", Matchers.hasSize(1)));

        Mockito.verify(chambreService, Mockito.times(1)).findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verifyNoMoreInteractions(chambreService);

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(chambreService.findById(ArgumentMatchers.anyString())).thenReturn(ChambreBuilder.getDto());

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(chambreService, Mockito.times(1)).findById("1");
        Mockito.verifyNoMoreInteractions(chambreService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(chambreService.save(ArgumentMatchers.any(ChambreDto.class))).thenReturn(ChambreBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(ChambreBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(chambreService, Mockito.times(1)).save(ArgumentMatchers.any(ChambreDto.class));
        Mockito.verifyNoMoreInteractions(chambreService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(chambreService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(ChambreBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(ChambreBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(chambreService, Mockito.times(1)).update(ArgumentMatchers.any(ChambreDto.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(chambreService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(chambreService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomUtils.asJsonString(ChambreBuilder.getIds()))).andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(chambreService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(chambreService);
    }
}