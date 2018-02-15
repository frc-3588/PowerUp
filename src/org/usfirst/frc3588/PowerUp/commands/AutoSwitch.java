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

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc3588.PowerUp.RobotMap;
import org.usfirst.frc3588.PowerUp.subsystems.*;

/**
 *
 */
public class AutoSwitch extends CommandGroup {
	boolean sameSide = false;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
    public AutoSwitch(String robotPosition, String switchPosition) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS
    	
    	//checks if robot is on same side as the switch
    	if (robotPosition.charAt(0) == switchPosition.charAt(0)) {
    		sameSide = true;
    	}
    	
    	// moves robot from back wall to pivot if needed
    	addSequential (new DriveStraight(0.5, 1.0, 2.0));
    	
    	// checks if robot is in middle position
    	if (robotPosition.charAt(0) == 'M') {
    		// checks which side switch is on
    		// moves robot to same side as switch
    		if (switchPosition.charAt(0) == 'R') {
    			addSequential (new Pivot(90.0)); //turn right 90 degrees
    			addSequential (new DriveStraight(0.7, 3.0, 5.0));
    			addSequential (new Pivot(-90.0)); //turn left 90 degrees
    		} else {	
    			addSequential (new Pivot(-90.0)); //turn left 90 degrees
    			addSequential (new DriveStraight(0.7, 3.0, 5.0));
    			addSequential (new Pivot(90.0)); //turn right 90 degrees
    			
    		}
    		
    		// robot should be on the same side as switch by end of if/else statement
    		sameSide = true;
    		
    	}
    	
    	
    	// checks if robot is on same side
    	if (sameSide) {
    		addSequential (new DriveStraight(0.7, 2.0, 5.0));
    		
    		if (switchPosition.charAt(0) == 'R') {
    			addSequential (new Pivot(-90.0)); //turn left 90 degrees
    		} else {
    			addSequential (new Pivot(90.0)); //turn right 90 degrees
    		}
    		addSequential (new newDriveStraight(0.3, 0.0, 0.0));
    		
    	} else {
    		
    		if (switchPosition.charAt(0) == 'R') {
    			
    			addSequential (new DriveStraight(0.7, 4.0, 9.0));
    			addSequential (new Pivot(90.0)); //turn right 90 degrees
    			addSequential (new DriveStraight(0.7, 4.0, 15.0));
    			addSequential (new Pivot(90.0)); //turn right
    			addSequential (new DriveStraight(0.7, 4.0, 15.0));

    			addSequential (new Pivot(90.0)); //turn right
    			addSequential (new newDriveStraight(0.3, 0.0, 0.0));

    			addSequential (new Pivot(90.0)); //turn right
    			addSequential (new DriveStraight(0.3, 2.0, 2.0));
    		} else {
    			addSequential (new DriveStraight(0.7, 4.0, 9.0));
    			addSequential (new Pivot(-90.0)); //turn left
    			addSequential (new DriveStraight(0.7, 4.0, 15.0));
    			addSequential (new Pivot(-90.0)); //turn left
    			addSequential (new DriveStraight(0.7, 4.0, 15.0));
//<<<<<<< HEAD
    			addSequential (new Pivot(-90.0)); //turn left
    			addSequential (new newDriveStraight(0.3, 0.0, 0.0));
//=======
    			addSequential (new Pivot(-90.0)); //turn left
    			addSequential (new DriveStraight(0.3, 2.0, 2.0));
//>>>>>>> branch 'master' of https://github.com/frc-3588/PowerUp
    		}
    	}
    	//addSequential (new moveElevator(1));
     	addSequential (new moveElevatorAuto(0.5, 30));//power encoderDistance
    	addSequential (new DriveStraight (0.5, 0.5, 1));
    	addSequential (new shootAuto(0.5));
    	addSequential (new DriveStraight (-0.5, 0.5, 1));
    	
    	addSequential (new moveElevatorAuto(-0.5, -30));//power encoderDistance
    	addSequential (new DriveStraight(-0.5, 2.0, 2.0));
    	
    } 
}

