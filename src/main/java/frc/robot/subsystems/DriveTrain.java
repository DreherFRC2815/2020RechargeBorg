/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */
  public WPI_TalonSRX[] talons = new WPI_TalonSRX[4];

  public DifferentialDrive tank;

  public DriveTrain() {

    for(int i = 0; i < 4; i++){
      talons[i] = new WPI_TalonSRX(Constants.talonNums[i]);
    }

    SpeedControllerGroup left = new SpeedControllerGroup(talons[0], talons[1]);
    SpeedControllerGroup right = new SpeedControllerGroup(talons[2], talons[3]);

    tank = new DifferentialDrive(left, right);
  }

  public void driveArcade(double f, double t){
    tank.arcadeDrive(f, t, true);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
