/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import com.analog.adis16448.frc.ADIS16448_IMU;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Drive extends CommandBase {
  /**
   * Creates a new Drive.
   */
  private final DriveTrain dTrain;
  private final ADIS16448_IMU imu;
  private final DoubleSupplier forw;
  private final DoubleSupplier turn;
   
  public Drive(DriveTrain subsys, ADIS16448_IMU im, DoubleSupplier f, DoubleSupplier t) {
    dTrain = subsys;
    imu = im;
    forw = f;
    turn = t;
    addRequirements(dTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { 
    // checkSneak();
    //new Rumble(new XboxController(0)).rumble(1);
    dTrain.driveArcade(-forw.getAsDouble(), turn.getAsDouble());
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
