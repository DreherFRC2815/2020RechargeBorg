/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Drive extends CommandBase {
  
  //what subsystem will this command feed inputs in to
  private final DriveTrain train;

  //what inputs does this command feed in to a subsystems
  private final DoubleSupplier forward;
  private final DoubleSupplier turn;

  //constructor
  public Drive(DriveTrain d, DoubleSupplier f, DoubleSupplier t) {
    train = d;
    forward = f;
    turn = t;
    //The code template tells us to use this method
    addRequirements(train);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //getting current input values and feeding them in to the subsystem
    train.driveArcade(forward.getAsDouble(), turn.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
