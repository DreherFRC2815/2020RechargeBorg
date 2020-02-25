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
  //system has 4 talonSRX controllers
  private WPI_TalonSRX[] talons = new WPI_TalonSRX[4];

  //one type of object that controlls how the robot drives
  //type of object depends on the wheel layout of the robot
  private final DifferentialDrive tank;

  public DriveTrain() {

    //initiating each SRX based on port numbers from constants
    for(int i = 0; i < 4; i++){
      talons[i] = new WPI_TalonSRX(Constants.drivers[i]);
    }

    //grouping the talons in to left and right
    //One of the talons needed to be inverted, this is how you do that                                                                   b 
    talons[0].setInverted(true);
    SpeedControllerGroup left = new SpeedControllerGroup(talons[0], talons[1]);
    SpeedControllerGroup right = new SpeedControllerGroup(talons[2], talons[3]);

    //initiating the DifferentialDrive object with the talon groups
    tank = new DifferentialDrive(left, right);
  }

  //do-stuff method. Calling arcade drive in the DifferentialDrive object
  public void driveArcade(double f, double t){
    tank.arcadeDrive(f, t, true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
