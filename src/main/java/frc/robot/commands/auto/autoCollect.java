/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CollectMotor;

public class autoCollect extends CommandBase {
  /**
   * Creates a new autoCollect.
   */
  private final CollectMotor collie;
  private double inSpeed;
  private double time;
  private boolean done = false;

  private Timer timer = new Timer();
  

  public autoCollect(CollectMotor col, double ins, double tim) {
    collie = col;
    inSpeed = ins;
    time = tim;
    addRequirements(collie);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  public autoCollect(CollectMotor col){
    collie = col;
    inSpeed = .8;
    time = 1;

    addRequirements(collie);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(timer.get() < time){
      collie.pewpew(inSpeed);
    }
    else{
      collie.pewpew(0);
      done = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    done = interrupted;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return done;
  }
}
