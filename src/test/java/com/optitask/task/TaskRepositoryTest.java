package com.optitask.task;

import com.optitask.robot.Robot;
import com.optitask.robot.RobotRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class TaskRepositoryTest {

    //THIS ONE SAVES THE ROBOT
    @Autowired
    private RobotRepository robotRepository;

    //THIS ONE SAVES THE TASKS
    @Autowired
    private TaskRepository taskRepository;

    //Test - Can I save a task to the database and get it back correctly with all correct information.
    @Test
    void shouldSaveAndRetrieveTasksWithRobot(){

        //TJIA
        Robot robot = new Robot("Optimus", "Heavy Lifting Robot");
        Robot savedRobot = robotRepository.save(robot);

        Task task = new Task(savedRobot, "Cleaning", new BigDecimal("25.00"));
        Task saved = taskRepository.save(task);

        //ASSERTIONS FOR ROBOT, PROVES ROBOT WAS SAVED CORRECTLY. IF ROBOT SAVE FAILED, TASK WOULD ALSO FAIL.
        assertThat(savedRobot.getId()).isNotNull();
        assertThat(savedRobot.getName()).isEqualTo("Optimus");
        assertThat(savedRobot.getDescription()).isEqualTo("Heavy Lifting Robot");


        //ASSERTIONS FOR TASK, PROVES TASK WAS SAVED CORRECTLY W RIGHT NAME, PRICE, AND ROBOT ATTACHED.
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getRobot()).isEqualTo(savedRobot);
        assertThat(saved.getName()).isEqualTo("Cleaning");
        assertThat(saved.getBasePrice()).isEqualByComparingTo("25.00");




    }
}