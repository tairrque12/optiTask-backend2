package com.optitask.task;


import com.optitask.robot.Robot;
import com.optitask.robot.RobotService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


//HANDLES REQUEST FROM OUTSIDE WORLD.
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    //CONTROLLER NEEDS THIS TO DO ITS JOB, CANT DO ANYTHING W/O IT.
    private final TaskService taskService;
    private final RobotService robotService;

    public TaskController(TaskService taskService, RobotService robotService) {
        this.taskService = taskService;
        this.robotService=robotService;

    }
    @GetMapping("/robot/{robotId}")
    public List<Task> getTasksByRobot(@PathVariable Long robotId){
        Robot robot = robotService.getRobotById(robotId);
        return taskService.getTasksByRobot(robot);
    }


}