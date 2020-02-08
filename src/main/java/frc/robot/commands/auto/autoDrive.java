/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class autoDrive extends CommandBase {
  /**
   * Creates a new autoDrive.
   */
  private final DriveTrain vroom;
  private double forwSpeed;
  private double turnSpeed;
  private double time;

  private boolean done = false;

  private Timer timer = new Timer();
  
  public autoDrive(DriveTrain vro, double forw, double turn, double tem) {
    // Use addRequirements() here to declare subsystem dependencies.
    vroom = vro;
    forwSpeed = forw;
    turnSpeed = turn;
    time = tem;

    addRequirements(vroom);
  }
  
  public autoDrive(DriveTrain vro){
    vroom = vro;
    forwSpeed = .5;
    turnSpeed = 0;
    time = 1;

    addRequirements(vroom);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(timer.get() < time){
      System.out.println(timer.get());
      vroom.driveArcade(forwSpeed, turnSpeed);
    }
    else{
      vroom.driveArcade(0,0);
      done = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    done = interrupted;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return done;
  }
}
