package com.clockworkjava.kursspring;

import com.clockworkjava.kursspring.Services.KnightService;
import com.clockworkjava.kursspring.Services.QuestService;
import com.clockworkjava.kursspring.controlers.QuestController;
import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInfo;
import com.clockworkjava.kursspring.domain.Quest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.RETURNS_DEFAULTS;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class WebContextTest {

    @Mock
    KnightService knightService;
    @Mock
    QuestService questService;
    @Mock
    PlayerInfo playerInfo;
    @InjectMocks
    QuestController questController;

    private MockMvc mockMvc;
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(questController).build();
    }
    @Test
    public void testCheckQuest() throws Exception {

        mockMvc.perform(get("/checkQuests")).andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/knights"));
    }
    @Test
    public void contextLoads(){


    }
}
