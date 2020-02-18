/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  //system has 2 Solenoids for 4 pistons
  private DoubleSolenoid[] solenoids; 

  public Climber() {
    //initiating DoubleSolenoids
    for(int i = 0; i < 2; i++){
      solenoids[i] = new DoubleSolenoid(Constants.climbPistons[2*i],Constants.climbPistons[2*i + 1]);
    }
  }

  //do-stuff methods extending different stages based on boolean inputs
  public void stageOne(boolean b){
    //the ?: statement is explained elsewhere in the code
    solenoids[0].set(b ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
  }

  public void stageTwo(boolean b){
    solenoids[1].set(b ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
