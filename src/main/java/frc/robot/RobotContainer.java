/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //subsystems
  private final DriveTrain driveTrain = new DriveTrain();
  private final Collector collector = new Collector();
  private final Shooter shooter = new Shooter();
  private final Stats stats = new Stats();

  //Unfinished subsystems -> need testing
  private final Hopper hopper = new Hopper();
  private final Climber climber = new Climber();

  //controllers
  XboxController xbox = new XboxController(0);
  Joystick flight = new Joystick(1);

  //commands -> use these to reconfigure button bindings later
  //button bindings use lambda expressions: look them up if you are confused
  //check WPILIB for methods to get different types of input and Driver Station to get port numbers
  private final Drive drive = new Drive(driveTrain, () -> xbox.getRawAxis(1), () -> xbox.getRawAxis(4));
  
  //The button bindings for these can be changed here
  private final Collect collect = new Collect(collector, () -> xbox.getAButton());              //currently runs with the A button
  private final Shoot shoot = new Shoot(shooter, () -> flight.getRawButton(1));                 //currently runs with the flight trigger
  
  //Unfinished commands -> need testing
  private final MoveBalls hopp = new MoveBalls(hopper, () -> flight.getRawButtonPressed(2));    //currently runs with thumb button on flight stick
  private final Climb climb = new Climb(climber, () -> flight.getRawButtonPressed(12));         //currently runs with base button #12 on flight stick

  //Auto command
  // private final 

  //Shuffleboard/smartdashboard integration and statistics
  private final UpdateStats sickTatsYo = new UpdateStats(stats, () -> {return true;});

  //cameras
  private CameraServer camera1 = CameraServer.getInstance();
  private CameraServer camera2 = CameraServer.getInstance();

  public RobotContainer() {
    //subsystem.setDefaultCommand(command);
    driveTrain.setDefaultCommand(drive);
    collector.setDefaultCommand(collect);
    shooter.setDefaultCommand(shoot);
    hopper.setDefaultCommand(hopp);
    climber.setDefaultCommand(climb);
    stats.setDefaultCommand(sickTatsYo);

    //start cameras
    camera1.startAutomaticCapture();
    camera2.startAutomaticCapture();

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //see WPILIB if you want to do commands the way they want...
    //I prefer to do it the way i already have, making this method useless
    //it can probably be deleted
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
  }
}
