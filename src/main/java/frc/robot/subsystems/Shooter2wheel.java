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

public class Shooter2wheel extends SubsystemBase {
  /**
   * Creates a new Shooter2wheel.
   */
  private Spark[] motors = new Spark[2];
  private double power = .6;

  public Shooter2wheel() {
    for(int i = 0; i < 2; i++){
      motors[i] = new Spark(Constants.shooters[i]);
    }
  }

  public void incrementPower(boolean l, boolean r){
    if(l && power > .4){
      power = power - .05;
      power = Math.round(power*100.)/100.;
      System.out.println("Shooter 2 Wheel Power: " + power);
    }
    else if(r && power < 1){
      power = power + .05;
      power = Math.round(power*100.)/100.;
      System.out.println("Shooter 2 Wheel Power: " + power);
    }
  }
  
  public void shoot(boolean a){
    if(a){
      motors[0].set(-power);
      motors[1].set(-power);
    }
    else{
      motors[0].set(0);
      motors[1].set(0);
    }
  }

  public void shoot(boolean r, boolean l){
    if(r && l){
      motors[0].set(-.75);
      motors[1].set(-.75);
    }
    else if(l){
      motors[0].set(-.6);
      motors[1].set(-.6);
    }
    else if(r){
      motors[0].set(-1);
      motors[1].set(-1);
    }
    else{
      motors[0].set(0);
      motors[1].set(0);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
