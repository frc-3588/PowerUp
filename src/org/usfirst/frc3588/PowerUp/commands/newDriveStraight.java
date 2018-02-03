// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3588.PowerUp.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3588.PowerUp.Robot;
import org.usfirst.frc3588.PowerUp.RobotMap;

/**
 *
 */
public class newDriveStraight extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_power;
    private double m_time;
    private double m_distance;
    private double DL = 1.0;
    private double DR = 1.0;
    private boolean ultrasensor;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public newDriveStraight(double power, double time, double distance, boolean ultrasonic) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_power = -1 * power;
        m_time = time;
        m_distance = distance;
        ultrasensor = ultrasonic;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.chassis);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	if (m_power == RobotMap.STOP) {
    		throw new IllegalArgumentException("Invalid power value " + Double.toString(m_power));
    	}
    	if (m_time > 0) {
    		setTimeout(m_time);
    	}
    	if (m_distance != 0) {
    		RobotMap.chassisleftMotorEncoder.reset();
    		RobotMap.chassisrightMotorEncoder.reset();
    	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	RobotMap.chassisleftMotor.set(m_power * DL);
    	RobotMap.chassisrightMotor.set(m_power * DR);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	if (ultrasensor && RobotMap.chassisUltrasonic1.getRangeInches() < 5) {
    		return true;
    	}
    	else if ((m_time > 0 && isTimedOut())
				|| (m_distance > 0 && RobotMap.chassisleftMotorEncoder.getDistance() >= m_distance)) {
			return true;
		} 
    	else {
			return false;
		}
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
