package com.optitask.robot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RobotService {

    //Declares that the repository needs a service to do its job.
    //Final means it cannot be swapped out.
    private final RobotRepository robotRepository;

    public RobotService(RobotRepository robotRepository) {
        this.robotRepository = robotRepository;
    }
    public List<Robot>getAllRobots(){
        return robotRepository.findAll();
    }
}