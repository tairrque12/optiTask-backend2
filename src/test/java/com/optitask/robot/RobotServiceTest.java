// Files Run All Business Logic
package com.optitask.robot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RobotServiceTest {

    @Mock
    private RobotRepository robotRepository;

    @InjectMocks
    private RobotService robotService;

    @Test
    void shouldReturnAllRobots() {
        Robot robot = new Robot("Optimus", "Heavy lifting robot");
        when(robotRepository.findAll()).thenReturn(List.of(robot));

        List<Robot> result = robotService.getAllRobots();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Optimus");
    }
}