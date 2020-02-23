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
import frc.robot.subsystems.Shooter1Wheel;

public class ShootSingle extends CommandBase {
  /**
   * Creates a new Shoot.
   */
  private final BooleanSupplier button;
  private final BooleanSupplier right;
  private final BooleanSupplier left;
  private final Shooter1Wheel shootSubsys;
  private boolean running = false;

  public ShootSingle(Shooter1Wheel subsys, BooleanSupplier rr, BooleanSupplier ll, BooleanSupplier buttox) {
    shootSubsys = subsys;
    button = buttox;
    right = rr;
    left = ll;
    addRequirements(shootSubsys);
    // Use addRequirements() here to declare subsystem dependencies.
    //testing comment for git pushing stuff
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    running = button.getAsBoolean() ? !running : running;
    shootSubsys.shoot(running);
    SmartDashboard.putNumber("RPM",-shootSubsys.encoders[1].getVelocity());
    // shootSubsys.incrementPower(left.getAsBoolean(), right.getAsBoolean());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
