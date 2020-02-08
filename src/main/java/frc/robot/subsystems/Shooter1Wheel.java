/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter1Wheel extends SubsystemBase {
  /**
   * Creates a new Shooter2wheel.
   */
  private CANSparkMax[] maxes = new CANSparkMax[2];
  // private PWMSparkMax[] maxes = new PWMSparkMax[2];
  public CANEncoder[] encoders = new CANEncoder[2];
  private double power = 1;

  public Shooter1Wheel() {
    for (int i = 0; i<2; i++){
      maxes[i] = new CANSparkMax(Constants.spmaxids[i], MotorType.fromId(1)); // 1 = brushless, 0 = brushed
      encoders[i] = maxes[i].getEncoder();
      // maxes[i] = new PWMSparkMax(Constants.spmaxids[i]);
    }
  }
  
  public void shoot(boolean a){
    if (a){
      maxes[0].set(power);
      maxes[1].set(-power);
    }else{
      maxes[0].set(0);
      maxes[1].set(0);
    }
  }

  public void incrementPower(boolean l, boolean r){
    if(l && power > .4){
      power = power - .05;
      power = Math.round(power*100.)/100.;
      System.out.println("Shooter 1 Wheel Power: " + power);
    }
    else if(r && power < 1){
      power = power + .05;
      power = Math.round(power*100.)/100.;
      System.out.println("Shooter 1 Wheel Power: " + power);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
