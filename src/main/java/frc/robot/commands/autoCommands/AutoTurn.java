/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoCommands;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoTurn extends CommandBase {
  //subsystems and sensors
  private DriveTrain driveTrain;
  private ADIS16448_IMU adis;

  //input vals
  private double turnPower;
  private int turnDegrees;
  private boolean done = false;

  public AutoTurn(DriveTrain d, ADIS16448_IMU a, double tP, int deg) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = d;
    adis = a;
    turnPower = tP;
    turnDegrees = deg;

    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    adis.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Math.abs(adis.getAngle()) < turnDegrees){
      driveTrain.driveArcade(0,turnPower);
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
