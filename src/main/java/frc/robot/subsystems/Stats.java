/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Stats extends SubsystemBase {
  private double batteryVoltage, matchTime;
  private boolean enabled, auto;
  private DriverStation drvrst;

  public Stats() {
      batteryVoltage = 0;
      matchTime = 0;
      enabled = false;
      auto = false;
  }

  public void update() {
    drvrst = DriverStation.getInstance();

    batteryVoltage = RobotController.getBatteryVoltage();
    matchTime = drvrst.getMatchTime();
    enabled = drvrst.isEnabled();
    auto = drvrst.isAutonomous();

    SmartDashboard.putNumber("Battery Voltage", batteryVoltage);
    SmartDashboard.putNumber("Match Time", matchTime);
    SmartDashboard.putBoolean("Enabled", enabled);
    SmartDashboard.putBoolean("Auto", auto);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
