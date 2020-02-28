/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The C+onstants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //CAN Devices
    public static final int[] drivers = {1,2,3,0};          //DriveTrain TalonSRXs
    public static final int[] shooterMaxes = {5,7};         //SparkMAXs for the SA shooter -> can also be PWM but with less functions

    //PWM Devices
    public static final int collectMotor = 0;               //Spark for the OTB ball collector
    public static final int[] feedMotors = {2,5};           //Sparks for feeder plate thing
    public static final int beltMotor = 1;                  //Spark for belts up to shooter

    //PCM Numbers -> for pistons
    public static final int[] collectPistons = {3,2};       //Pistons that move the OTB collector over the bumper
    public static final int[] climbPistons = {1,0,4,5};     //Pistons on the climber

    //numbers for subsystems/commands
    public static final double feedPower = .3;              //Power value for feeder sparks in Hopper subsystem
    public static final double beltPower = .6;              //Power value for belt spark in Hopper subsystem
    public static final double shooterPower = .9;           //Power value for SparkMax's in Shooter subsystem
    public static final double beltDownPulse = .5;          //Timing for running the down pulse in AutoShoot
    public static final double collectSpeed = .6;           //Power value for the OTB collector
}
