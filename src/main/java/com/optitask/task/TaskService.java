package com.optitask.task;

import com.optitask.robot.Robot;
import com.optitask.robot.RobotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final RobotRepository robotRepository;

    public TaskService(TaskRepository taskRepository, RobotRepository robotRepository){
        this.robotRepository = robotRepository;
        this.taskRepository= taskRepository;
    }
    public List<Task> getTasksByRobot(Robot robot){
        return taskRepository.findByRobot(robot);
    }
}