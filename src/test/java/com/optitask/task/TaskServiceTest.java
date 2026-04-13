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

    //CREATES FAKE REPO - NEVER TOUCHES REAL DB.
    @Mock
    private TaskRepository taskRepository;

    @Mock
    private RobotRepository robotRepository;

    //CREATES A REAL TASK SERVICE & PUTS FAKE REPOS INSIDE,
    // TEST REAL SERVICE LOGIC AGAINST FAKE DATA
    @InjectMocks
    private TaskService taskService;

    @Test
    void shouldReturnTaskWithCorrectRobot(){
        // Created A ROBOT IN MEMORY AS FAKE DATA
        Robot robot = new Robot("Figure03", "Household Tasks");

        //CREATED TASK IN MEMORY AS FAKE DATA
        Task task = new Task(robot, "Mopping", new BigDecimal("30.00"));

        //WHEN FINDBYROBOT IS CALLED ON THE FAKE REPO, RETURN WITH TASKS IN IT.
        when(taskRepository.findByRobot(robot)).thenReturn(List.of(task));

        //CALLS SERVICE AND GETS BACK THE LIST I PROGRAMMED.
        List<Task> result = taskService.getTasksByRobot(robot);

        //ASSERTIONS
        assertThat(result).hasSize(1);
        // ENSURES LIST HAS 1 TASK.

        assertThat(result.get(0).getName()).isEqualTo("Mopping");
        // GET THE FIRST ITEM IN LIST(0). GET THE NAME & ENSURE ITS EQUAL TO MOPPING.

        assertThat(result.get(0).getRobot().getName()).isEqualTo("Figure03");
        //CHECK THE FIRST TASK IN THE LIST
        // GET THE ROBOT ATTACHED TO IT
        // GET THAT ROBOTS NAME
        // MAKE SURE IT SAYS FIGURE 03
        //THIS TEST WHETHER THE CORRECT TASKS CAME BACK WITH THE ROBOT ATTACHED.

    }

}