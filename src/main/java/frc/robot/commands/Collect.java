/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Collector;

public class Collect extends CommandBase {
  //subsystem
  private final Collector collector;
  
  //use one or the other depending on later input preferences
  private DoubleSupplier axis;
  private BooleanSupplier button;

  public Collect(Collector c, DoubleSupplier d) {
    // Use addRequirements() here to declare subsystem dependencies.
    collector = c;
    axis = d;

    addRequirements(collector);
  }

  public Collect(Collector c, BooleanSupplier b){
    collector = c;
    button = b;

    addRequirements(collector);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    collector.extendSystem(true);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //this code will make sure that the correct input is fed in to the subsystem
    //it can be deleted later when input choice has been made
    if(axis.equals(null)){
      collector.collect(button.getAsBoolean());
    }
    else{
      collector.collect(axis.getAsDouble());
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    collector.extendSystem(false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
