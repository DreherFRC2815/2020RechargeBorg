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

public class Hopper extends SubsystemBase {
  /**
   * Creates a new Hopper.
   */
  //sparks for the trapezoid feeder thing
  private Spark[] feeder;

  //spark for the belty tower thing
  private Spark belts;

  public Hopper() {
    //initialize sparks
    for(int i = 0; i < feeder.length; i++){
      feeder[i] = new Spark(Constants.feedMotors[i]);
    }
    belts = new Spark(Constants.beltMotor);
  }

  //do-stuff method that runs the feeder things
  public void runFeeders(boolean button){
    feeder[0].set(button ? Constants.feedPower : 0);
    feeder[1].set(button ? -Constants.feedPower : 0);
  }

  //do-stuff method that runs the belt tower thing
  public void runBelts(boolean button){
    belts.set(Constants.beltPower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
