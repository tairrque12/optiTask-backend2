package com.optitask.task;

import com.optitask.robot.Robot;
import com.optitask.robot.RobotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//CLASS HANDLES ALL BUSINESS LOGIC
@Service
public class TaskService {

    //NEEDS TASK REPOSITORY TO FIND TASKS
    private final TaskRepository taskRepository;

    //SERVICE ALSO HAS ACCESS TO ROBOT REPOSITORY FOR THE LOOKUP OF THE 2 ROBOTS
    private final RobotRepository robotRepository;

    // TURNS BOTH REPO'S IN, NEVER CREATE THEM MYSELF.
    public TaskService(TaskRepository taskRepository, RobotRepository robotRepository){
        this.robotRepository = robotRepository;
        this.taskRepository= taskRepository;
    }

    // THIS METHOD TAKES A ROBOT IN AND RETURNS A LIST OF TASKS.
    public List<Task> getTasksByRobot(Robot robot){

        //ASKS THE REPO TO GIVE ALL TASKS ASSOCIATED WITH ROBOT,
        // RETURNS WHAT ROBOT REPO GIVES BACK.
        return taskRepository.findByRobot(robot);
    }
}