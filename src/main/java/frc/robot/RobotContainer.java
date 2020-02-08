/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import frc.robot.commands.auto.*;
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

  public static final ADIS16448_IMU imu = new ADIS16448_IMU();
  
  // The robot's subsystems and commands are defined here...
  private final DriveTrain dTrain = new DriveTrain();
  private final CollectMotor collie = new CollectMotor();
  private final Shooter2wheel doubSpin = new Shooter2wheel();
  private final Collect2Motor foosV2 = new Collect2Motor();
  private final Shooter1Wheel fancyThing = new Shooter1Wheel();
  private final PistonClimb omg = new PistonClimb();
  
  XboxController xbox = new XboxController(0);
  Joystick flight = new Joystick(1);
  
  private final Drive driver = new Drive(dTrain, imu, () -> xbox.getRawAxis(1), () -> xbox.getRawAxis(4));
  private final Collect pew = new Collect(collie, () -> xbox.getRawAxis(3), () -> xbox.getRawButton(2));
  private final Shoot pow = new Shoot(doubSpin, () -> xbox.getRawButtonPressed(6), () -> xbox.getRawButtonPressed(5), () -> xbox.getRawButton(1));
  private final TwoMotorCollection foosBall = new TwoMotorCollection(foosV2, () -> xbox.getRawAxis(3));    //X button
  private final ShootSingle soPretty = new ShootSingle(fancyThing, () -> xbox.getRawButtonPressed(6), () -> xbox.getRawButtonPressed(5), () -> xbox.getYButtonPressed());
  private final Climb doIt = new Climb(omg, () -> xbox.getRawButtonPressed(7));

  private SequentialCommandGroup auto;
  private CameraServer camera = CameraServer.getInstance();

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    dTrain.setDefaultCommand(driver);
    collie.setDefaultCommand(pew);
    doubSpin.setDefaultCommand(pow);
    foosV2.setDefaultCommand(foosBall);
    fancyThing.setDefaultCommand(soPretty);
    omg.setDefaultCommand(doIt);
    camera.startAutomaticCapture();
    setupAuto();
    configureButtonBindings();
  }
  

  private void setupAuto(){
    /*auto  = new SequentialCommandGroup(
      new ParallelCommandGroup(
        new SequentialCommandGroup(
          new autoDrive(dTrain, .7, 0, 1),
          new autoDrive(dTrain, -.7, 0, 1)
        ),
        new autoCollect(collie, -.6, 2)
      )
    );*/

    auto = new SequentialCommandGroup(
      new autoDrive(dTrain, .5, 0, 1),
      new autoDrive(dTrain, 0, .5, 1)
    );
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
    return auto;
  }
}
