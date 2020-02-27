package frc.robot.commands.autoCommandGroups;

import frc.robot.commands.autoCommands.AutoDrive;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;;

/* Creates a new sequential command group
 *
 */
public class BasicAutoCommandGroup extends SequentialCommandGroup {
    public BasicAutoCommandGroup(DriveTrain dt) {
        // Add any commands here
        super(new AutoDrive(dt, 1.0, 1.0, 1.0));
        // Execute parallel commands in this sequential group
        // new ParallelCommandGroup(commands);
    }
} 