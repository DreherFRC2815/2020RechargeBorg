package frc.robot.commands.autoCommandGroups;

import frc.robot.commands.autoCommands.*;
import frc.robot.subsystems.*;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;;

/* Creates a new sequential command group
 *
 */
public class BasicAutoCommandGroup extends SequentialCommandGroup {
    public BasicAutoCommandGroup(DriveTrain driveTrain, Shooter shooter, Hopper hopper, Collector collector, ADIS16448_IMU imu) {
        // Add any commands here
        super(new AutoShoot(shooter, hopper, 5, true, true));
        // Execute parallel commands in this sequential group
        // new ParallelCommandGroup(commands);
    }
} 