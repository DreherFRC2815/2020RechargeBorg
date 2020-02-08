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
import frc.robot.subsystems.CollectMotor;

public class Collect extends CommandBase {
  /**
   * Creates a new Collect.
   */
  private final CollectMotor mot;
  private final DoubleSupplier in;
  private final BooleanSupplier out;

  public Collect(CollectMotor sub, DoubleSupplier i, BooleanSupplier o) {
    // Use addRequirements() here to declare subsystem dependencies.
    mot = sub;
    in = i;
    out = o;
    addRequirements(mot);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(in.getAsDouble() > .1){
      mot.pewpew(-in.getAsDouble());
    }
    else if(out.getAsBoolean()){
      mot.pewpew(.8);
    }
    else{
      mot.pewpew(0);
    }
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
