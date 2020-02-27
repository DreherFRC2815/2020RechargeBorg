/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoCommandGroups;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.autoCommands.*;
import frc.robot.subsystems.*;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class LeftAutoBasic extends SequentialCommandGroup {
  /**
   * Creates a new LeftAutoBasic.
   */
  public LeftAutoBasic(DriveTrain driveTrain, Shooter shooter, Hopper hopper, Collector collector, ADIS16448_IMU imu) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    new ParallelCommandGroup(
      new AutoDrive(driveTrain, -.5, 0, 3),
      new AutoCollect(collector, .5)
    );
    new AutoTurn(driveTrain, imu, .5, 180);
  }
}
