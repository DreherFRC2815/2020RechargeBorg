/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Collect2Motor extends SubsystemBase {
  /**
   * Creates a new Collect2Motor.
   */
  Spark[] motors = new Spark[2];

  public Collect2Motor() {
    motors[0] = new Spark(Constants.collect2[0]);
    motors[1] = new Spark(Constants.collect2[1]);
  }

  public void collect(double b){
    // if(b){
    //   motors[0].set(1); //pullin 
    //   motors[1].set(-1); //sides
    // }
    // else{
    //   motors[0].set(0);
    //   motors[1].set(0);
    // }
    motors[1].set(b);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
