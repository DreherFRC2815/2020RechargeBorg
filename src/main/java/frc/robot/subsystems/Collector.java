/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Collector extends SubsystemBase {
  /**
   * Creates a new Collector.
   */
  //system has one spark to make the system spin
  private final Spark motor;

  //system has 1 solenoid running 2 pistons
  private final DoubleSolenoid pistons;

  public Collector() {
    motor = new Spark(Constants.collectMotor);
    pistons = new DoubleSolenoid(Constants.collectPistons[0],Constants.collectPistons[1]);
  }

  //choose between collect methods based on personal preference later
  public void collect(boolean b){
    //while b is true, the motor will be at .5 otherwise at 0
    //try to replace .5 with a value from constants later on if this run method is chosen
    motor.set(b ? -Constants.collectSpeed : 0);
  }

  public void collect(double d){
    //set the motor to provided double d
    motor.set(d);
  }

  //this method should only be called once at the beginning of the match to push the system out of frame
  public void extendSystem(boolean b){
    pistons.set(b ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
