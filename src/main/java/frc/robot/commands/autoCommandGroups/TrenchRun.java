package frc.robot.commands.autoCommandGroups;

import frc.robot.commands.autoCommands.*;
import frc.robot.subsystems.*;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;;

/* Creates a new sequential command group
 *
 */
public class TrenchRun extends SequentialCommandGroup {
    public TrenchRun(DriveTrain driveTrain, Shooter shooter, Hopper hopper, Collector collector, ADIS16448_IMU imu) {
        super(
            new AutoDrive(driveTrain, -.5, 0, 4),
            new ParallelCommandGroup(
                new AutoDrive(driveTrain, -.5, 0, 4),
                new AutoCollect(collector, 4)
            ),
            new AutoDrive(driveTrain, .5, 0, 4),
            new AutoTurn(driveTrain, imu, .7, 145),
            new AutoShoot(shooter, hopper, 3, false, true)
        );
    }
} 