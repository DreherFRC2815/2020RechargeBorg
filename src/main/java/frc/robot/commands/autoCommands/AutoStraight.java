/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoCommands;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoStraight extends CommandBase {
  //subsystems and sensors
  private final DriveTrain driveTrain;
  private final ADIS16448_IMU imu;

  //inputs
  private final double power, time;
  private final float adjust = .05f;

  //timer
  Timer timer = new Timer();

  public AutoStraight(DriveTrain d, ADIS16448_IMU i, double pow, double tim) {
    driveTrain = d;
    imu = i;
    power = pow;
    time = tim;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    imu.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(timer.get() < time){
      if(imu.getAngle() > 7) {

      }
      else if(imu.getAngle() < -7) {

      }
      else {

      }
    }
    else{
      driveTrain.driveArcade(0,0);
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
