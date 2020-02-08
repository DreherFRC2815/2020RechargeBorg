/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter2wheel;

public class Shoot extends CommandBase {
  /**
   * Creates a new Shoot.
   */
  private final Shooter2wheel powpowpow;
  private final BooleanSupplier right;
  private final BooleanSupplier left;
  private final BooleanSupplier aButton;
  public Shoot(Shooter2wheel subsys, BooleanSupplier shoo, BooleanSupplier lef, BooleanSupplier a) {
    powpowpow = subsys;
    right = shoo;
    left = lef;
    aButton = a;
    addRequirements(powpowpow);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //powpowpow.shoot(right.getAsBoolean(), left.getAsBoolean());
    powpowpow.shoot(aButton.getAsBoolean());
    powpowpow.incrementPower(left.getAsBoolean(), right.getAsBoolean());
    //SmartDashboard.putNumber("Encoder V", powpowpow.encoders[1].getVelocity());
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
