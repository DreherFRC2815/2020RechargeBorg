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

public class PistonClimb extends SubsystemBase {
  /**
   * Creates a new PistonClimb.
   */
  // private final DoubleSolenoid[] climbers = new DoubleSolenoid[2];
  // private int stage = 0;
  private final DoubleSolenoid piston;
  private boolean state = true;

  public PistonClimb() {
    // for(int i = 0; i < 2; i++){
    //   climbers[i] = new DoubleSolenoid(Constants.climbPistons[2*i], Constants.climbPistons[2*i + 1]);
    // }
    piston = new DoubleSolenoid(Constants.climbPistons[0], Constants.climbPistons[1]);
  }

  public void doDisTing(boolean a){
    state = a? !state: state;
    piston.set(state? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
    // if(a){
    //   switch(stage){
    //     default:
    //       climbers[0].set(DoubleSolenoid.Value.kForward);
    //       break;
    //     case 1:
    //       climbers[1].set(DoubleSolenoid.Value.kForward);
    //       break;
    //     case 2:
    //       climbers[1].set(DoubleSolenoid.Value.kReverse);
    //       break;
    //     case 3:
    //       climbers[0].set(DoubleSolenoid.Value.kReverse);
    //       break;
    //   }
    //   stage = (stage+1)%4;
    // }

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
