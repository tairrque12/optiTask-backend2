package com.optitask.robot;
import org.springframework.data.jpa.repository.JpaRepository;

/*

This Entire File Is A Repo That Manages Robots.
It Gives Me All Basic SQL Operations.

Robot - what type of object this repo manages
Long - what type of ID it is

 */

public interface RobotRepository extends JpaRepository<Robot, Long> {

}