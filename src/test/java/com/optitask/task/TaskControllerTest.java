package com.optitask.task;

import com.optitask.robot.Robot;
import com.optitask.robot.RobotService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TaskService taskService;

    @MockitoBean
    private RobotService robotService;

    @Test
    void shouldGetAllTasksBackBasedOnRobot() throws Exception {

        // FAKE DATA
        Robot robot = new Robot("Figure03", "Vacuuming");
        Task task = new Task(robot, "Household Tasks", new BigDecimal("25.00"));

        // GETS THE ROBOT - GIVE ME ROBOT WITH ID OF 1
        when(robotService.getRobotById(1L)).thenReturn(robot);

        // GETS THE TASK - GIVE ME ALL TASKS FOR THIS ROBOT
        when(taskService.getTasksByRobot(robot)).thenReturn(List.of(task));

        mockMvc.perform(get("/api/tasks/robot/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Household Tasks"));
    }
}