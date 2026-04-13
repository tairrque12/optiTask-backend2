package com.optitask.task;
import com.optitask.robot.Robot;
import com.optitask.robot.RobotRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;
    @Mock
    private RobotRepository robotRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void shouldReturnTaskWithCorrectRobot(){
        // Created Fake Data
        Robot robot = new Robot("Figure03", "Household Tasks");
        Task task = new Task(robot, "Mopping", new BigDecimal("30.00"));

        //Programming The Fake Repo
        when(taskRepository.findByRobot(robot)).thenReturn(List.of(task));

        //Call Service, Capture Result
        List<Task> result = taskService.getTasksByRobot(robot);

        //ASSERTIONS
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Mopping");
        assertThat(result.get(0).getRobot().getName()).isEqualTo("Figure03");

    }

}