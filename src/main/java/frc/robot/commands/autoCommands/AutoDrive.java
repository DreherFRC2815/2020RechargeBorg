/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoDrive extends CommandBase {
  //subsystem
  private final DriveTrain driveTrain;

  //inputs
  private double forward, turn, time;

  //necessary for sequential and parallel command groups to work properly... trust me
  //make sure to edit the default isFinished method to return done
  private boolean done = false;

  private Timer timer = new Timer();

  public AutoDrive(DriveTrain d, double f, double tu, double ti) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = d;
    forward = f;
    turn = tu;
    time = ti;
    addRequirements(driveTrain);
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
      driveTrain.driveArcade(forward, turn);
    }
    else{
      driveTrain.driveArcade(0,0);
      done = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return done;
  }
}
