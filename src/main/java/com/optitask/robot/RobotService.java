package com.optitask.robot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RobotService {
    private final RobotRepository robotRepository;

    public RobotService(RobotRepository robotRepository) {
        this.robotRepository = robotRepository;
    }
    public List<Robot>getAllRobots(){
        return robotRepository.findAll();
    }
}