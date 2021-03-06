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
import org.usfirst.frc3588.PowerUp.subsystems.*;

/**
 *
 */
public class scalePosition extends CommandGroup {
boolean sameScale = false;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
    public scalePosition(String robotPosition, String scalePosition) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
    	addSequential(new grabCube());
    	addParallel(new holdCube());
    	if (robotPosition.charAt(0) == scalePosition.charAt(1)) {
    		sameScale = true;
    	}
    	
    	if (sameScale) {
    		addSequential (new DriveStraight(0.7, 4.5, 2600));//power time distance
    		if (robotPosition.charAt(0) == 'L' ) {
    			addSequential (new Pivot(-75.0));
			} else {
    				addSequential (new Pivot (75.0));
			}	
		}
    	
    	else {
    		addSequential (new DriveStraight(0.7, 3.0, 1200));
    		if (robotPosition.charAt(0) == 'L' ) {
    			addSequential (new Pivot(-70.0));
			} else {
    				addSequential (new Pivot (70.0));
			}	
    		
    		addSequential (new DriveStraight(0.7, 4.5, 2600));
    		
    		if (robotPosition.charAt(0) == 'L' ) {
    			addSequential (new Pivot(70.0));
			} else {
    				addSequential (new Pivot (-70.0));
			}	
    		
    		addSequential (new DriveStraight(0.5, 1.0, 500));
    		
    		if (robotPosition.charAt(0) == 'L' ) {
    			addSequential (new Pivot(70.0));
			} else {
    				addSequential (new Pivot (-70.0));
			}	
    		
    	}
    	
//		addSequential (new DriveStraight (-0.2, 1.5, 500));
//		addSequential (new moveElevatorAuto(0.7, 24000));//Move Elevator Up, to scale height
//		addSequential (new DriveStraight (0.2, 1.5, 500));//Drive Towards Scale
//		addParallel (new shootAuto(0.5));//Shoot Out Cube
//		addSequential (new DriveStraight (-.2, .5, 1));//lower elevator down
//		addSequential (new moveElevatorAuto(0.7,-20000));//power encoderDistance
        	
    		
    		
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
 
    } 
}

