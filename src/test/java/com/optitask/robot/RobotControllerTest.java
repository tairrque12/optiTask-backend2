package com.optitask.robot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RobotController.class)
public class RobotControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RobotService robotService;

    @Test
    void shouldReturnAllRobots() throws Exception {
        Robot robot = new Robot("Optimus", "Heavy lifting robot");
        when(robotService.getAllRobots()).thenReturn(List.of(robot));

        mockMvc.perform(get("/api/robots"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Optimus"));
    }
}