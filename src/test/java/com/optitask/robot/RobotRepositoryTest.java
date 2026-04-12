package com.optitask.robot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class RobotRepositoryTest {

    @Autowired
    private RobotRepository robotRepository;

    @Test
    void shouldSaveAndRetrieveRobot() {
        Robot robot = new Robot("Optimus", "Heavy Lifting Robot");
        Robot saved = robotRepository.save(robot);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getName()).isEqualTo("Optimus");
    }
}