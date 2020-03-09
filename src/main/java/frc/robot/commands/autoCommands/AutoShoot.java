/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Shooter;

public class AutoShoot extends CommandBase {
  //subsystems
  private final Shooter shooter;
  private final Hopper hopper;

  //inputs
  private double time;
  private boolean downPulse;
  private boolean done = false;
  private boolean trapezoid;

  private Timer timer = new Timer();
  
  public AutoShoot(Shooter s, Hopper h, double t, boolean dP, boolean trap) {
    // Use addRequirements() here to declare subsystem dependencies.
    shooter = s;
    hopper = h;
    time = t;
    downPulse = dP;
    trapezoid = trap;
    addRequirements(shooter, hopper);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(downPulse){
      if(timer.get() < Constants.beltDownPulse){
        hopper.runBelts(true, true);
        shooter.shoot(true);
      }
      else{
        hopper.runBelts(false, true);
        downPulse = false;
        timer.reset();
      }
    }
    else if(timer.get() < time){
      hopper.runBelts(true, false);
      hopper.runFeeders(trapezoid);
      shooter.shoot(true);
    }
    else{
      hopper.runBelts(false, false);
      hopper.runFeeders(false);
      shooter.shoot(false);
      done = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return done;
  }
}
