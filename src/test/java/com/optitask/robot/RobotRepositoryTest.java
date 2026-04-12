package com.optitask.robot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

//Data Jpa Only Test The DB & Nothing else
@DataJpaTest
//This Uses The Real DB I Created Instead Of A Fake One
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class RobotRepositoryTest {

    //Spring Gives Me A Tool Ready To Use
    @Autowired
    private RobotRepository robotRepository;

    //Test - Can I Create A Robot To The DB & Get It Back Correctly?
    @Test
    void shouldSaveAndRetrieveRobot() {

        //This Is Just Sitting In Memory Not In DB Yet.
        Robot robot = new Robot("Optimus", "Heavy Lifting Robot");

        //I Handed The Robot To The Database, The DB saved It & Handed Me Back A Receipt. Now Has An ID
        Robot saved = robotRepository.save(robot);

        //Check that the receipt has an ID on it.
        assertThat(saved.getId()).isNotNull();
        //Check that what I put in the DB is exactly what I put in.
        assertThat(saved.getName()).isEqualTo("Optimus");
    }
}