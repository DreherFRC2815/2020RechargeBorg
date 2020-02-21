package frc.robot;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Stats;

public class UpdateStats extends CommandBase {
    private boolean updates;
    private Stats stats;

    public UpdateStats(Stats s, BooleanSupplier b) {
        updates = b.getAsBoolean();
        stats = s;

        addRequirements(stats);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (updates) stats.update();
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
}