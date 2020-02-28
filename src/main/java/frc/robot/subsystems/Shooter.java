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

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */
  //Motor Controllers for the shooter
  private CANSparkMax[] maxes = new CANSparkMax[2];

  //Encoders associated with each Spark Max
  private CANEncoder[] encoders = new CANEncoder[2];

  public Shooter() {
    //Max and Encoder setup
    //PWM setup for SparkMax is simpler but loses the encoder capabilities
    for(int i = 0; i < 2; i++){
      maxes[i] = new CANSparkMax(Constants.shooterMaxes[i], MotorType.fromId(1));
      encoders[i] = maxes[i].getEncoder();
    }
  }

  //do-stuff method. setting values for the SparkMax's
  public void shoot(boolean b){
    maxes[0].set(b ? -Constants.shooterPower : 0);
    maxes[1].set(b ? Constants.shooterPower : 0);
  }

  public double getEncoder(){
    if (encoders.length <= 0){
      return 0;
    }
    return encoders[1].getVelocity();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
