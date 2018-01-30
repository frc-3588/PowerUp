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
public class moveElevatorAuto extends Command {
	private double encoderDistance; //resets on initialize
	private int elevatorHeight; //for the buttons to check what button gets pressed. 
	private double SWITCH_HEIGHT = 30.0; // for encoder readings
	private double CLIMB_HEIGHT = 200.0; // for encoder readings
	private double LOW_SCALE = 80.0; // for encoder readings
	private double MID_SCALE = 120.0; // for encoder readings
	private double HIGH_SCALE = 160.0; //for encoder readings
	private double ACQUIRE_HEIGHT = 0.0; // base height to acquire cubes
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public moveElevatorAuto(int button) {
    	elevatorHeight = button;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	RobotMap.elevatorliftEncoder.reset();
    	encoderDistance = RobotMap.elevatorliftEncoder.get();
    	RobotMap.elevatorliftSolenoid.set(false);
    	RobotMap.elevatorliftMotor.set(0.8);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	//if (RobotMap.elevatorliftMotor.get() > 0.0) {
    		//RobotMap.elevatorliftSolenoid.set(false);
    	//}
    	//else if (RobotMap.elevatorliftMotor.get() == 0.0) {
    		//RobotMap.elevatorliftSolenoid.set(true);
    	//}
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	if ((elevatorHeight == 1 && encoderDistance > SWITCH_HEIGHT) || (elevatorHeight == 2 && encoderDistance > LOW_SCALE)
    			|| (elevatorHeight == 3 && encoderDistance > MID_SCALE) || (elevatorHeight == 4 && encoderDistance > HIGH_SCALE)
    			|| (elevatorHeight == 5 && encoderDistance >= CLIMB_HEIGHT) || (elevatorHeight == 6 && encoderDistance > ACQUIRE_HEIGHT)) {
    		RobotMap.elevatorliftMotor.set(0.0);
    		RobotMap.elevatorliftSolenoid.set(true);
    		//MOVE FORWARD
    		//PLACE CUBE
    		//MOVE BACKWARD
    		RobotMap.elevatorliftSolenoid.set(false);
    		RobotMap.elevatorliftMotor.set(-0.8);
    		while (!(RobotMap.elevatorliftEncoder.get() < ACQUIRE_HEIGHT + 4)) {
    			RobotMap.elevatorliftMotor.set(0.0);
    			RobotMap.elevatorliftSolenoid.set(true);
    		}
    		return true;
    	}
    	return false;
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