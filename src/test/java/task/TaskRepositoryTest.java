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

    //Spring Gives Me Tools Ready To Use
    @Autowired
    private RobotRepository robotRepository;

    @Autowired
    private TaskRepository taskRepository;

    //Test - Can I save a task to the database and get it back correctly with all correct information.
    @Test
    void shouldSaveAndRetrieveTasksWithRobot(){

        Robot robot = new Robot("Optimus", "Heavy Lifting Robot");
        Robot savedRobot = robotRepository.save(robot);

        Task task = new Task(savedRobot, "Cleaning", new BigDecimal("25.00"));

        //Assertions For Robot
        assertThat(savedRobot.getId()).isNotNull();
        assertThat(savedRobot.getName()).isEqualTo("Optimus");
        assertThat(savedRobot.getDescription()).isEqualTo("Heavy Lifting Robot");


        //Assertions For Task
        Task saved = taskRepository.save(task);
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getRobot()).isEqualTo(savedRobot);
        assertThat(saved.getName()).isEqualTo("Cleaning");
        assertThat(saved.getBasePrice()).isEqualByComparingTo("25.00");




    }
}