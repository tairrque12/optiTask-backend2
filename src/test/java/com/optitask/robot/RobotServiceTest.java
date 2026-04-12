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

//Turns On Mockito For This Test Class, This Creates Fake Objects.
@ExtendWith(MockitoExtension.class)

public class RobotServiceTest {

    @Mock
    //Creates A Fake Repository, Never Touches DB, I control what it returns.
    private RobotRepository robotRepository;

    @InjectMocks
    // Creates Real Robot Service, Puts Fake Repo Inside Of It.
    // Testing Real Code Against Fake DB
    private RobotService robotService;

    //
    @Test
    void shouldReturnAllRobots() {
        //Creates Fake Robot Object In Memory.
        Robot robot = new Robot("Optimus", "Heavy lifting robot");
        //Programs Fake Data.
        when(robotRepository.findAll()).thenReturn(List.of(robot));

        //Goes To Service, stores it back into result
        List<Robot> result = robotService.getAllRobots();

        //Ensures It Has Only One Robot
        assertThat(result).hasSize(1);
        //Give First Name In List, Ensure Name Is Optimus
        assertThat(result.get(0).getName()).isEqualTo("Optimus");
    }
}