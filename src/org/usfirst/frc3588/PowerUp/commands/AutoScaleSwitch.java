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

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc3588.PowerUp.subsystems.*;

/**
 *
 */
public class AutoScaleSwitch extends CommandGroup {
	boolean sameSwitch = false;
	boolean sameScale = false;
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
    public AutoScaleSwitch(String robotPosition, String switchPosition, String scalePosition) {

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
    	addSequential(new grabCube());
    	addParallel(new holdCube());
    	
    	
    	// if in middle, go for switch
    	//addSequential (new moveElevatorAuto(0.5, 4000));//power encoderDistance
    	if (robotPosition.charAt(0) == 'M') {
    		// checks which side switch is on
    		// moves robot to same side as switch
    		addSequential (new DriveStraight(0.3, 2.0, 400));
    		
    		if (switchPosition.charAt(0) == 'R') {
    			addSequential (new Pivot(-80.0)); //turn right 90 degrees
    			addSequential (new DriveStraight(0.3, 1.0, 300));
    			addSequential (new Pivot(80.0)); //turn left 90 degrees
    		} else {	
    			addSequential (new Pivot(80.0)); //turn left 90 degrees
    			addSequential (new DriveStraight(0.6, 1.3, 600));
    			addSequential (new Pivot(-75.0)); //turn right 90 degrees
    			
    		}
    		
    		// robot should be on the same side as switch by end of if/else statement
    		
    		
    		addSequential (new moveElevatorAuto(1, 3400));
    		addParallel(new holdLift());
        	addSequential (new DriveStraight (0.4, 2.5, 1000));
        	Timer.delay(0.7);
        	addParallel ( new DriveStraight (0.3, 1, 1000));
        	Timer.delay(0.5);
        	addParallel ( new shootAuto(0.5));
        	Timer.delay(2);
        	end();
    	}
    	
    	
    	
    	if (robotPosition.charAt(0) == switchPosition.charAt(0)) {
    		sameSwitch = true;
    	}
    	if (robotPosition.charAt(0) == scalePosition.charAt(1)) {
    		sameScale = true;
    	}
    	if (robotPosition.charAt(0) != 'M') {
    		if (sameScale) {
        		addSequential (new DriveStraight(0.9, 3.5, 2600));//power time distance/////////this needs to be changed
        		if (robotPosition.charAt(0) == 'L' ) {
        			addSequential (new Pivot(-75.0));
        		} else {
        			addSequential (new Pivot (75.0));
        		}	
        		addSequential (new DriveStraight (-0.2, 1.5, 500));
        		addSequential (new moveElevatorAuto(0.7, 6600));//Move Elevator Up, to scale height
        		addParallel(new holdLift());
        		addSequential (new DriveStraight (0.2, 1.5, 500));//Drive Towards Scale
        		addParallel (new shootAuto(0.5));//Shoot Out Cube
        		addSequential (new DriveStraight (-.2, .5, 1));//lower elevator down
        		addSequential (new moveElevatorAuto(0.7,-4000));//power encoderDistance
    		}
    	
    		else if (sameSwitch) {
    			addSequential (new DriveStraight(0.7, 2.3, 1300));
    		
    			if (switchPosition.charAt(0) == 'R') {
    				addSequential (new Pivot(80.0)); //turn left 90 degrees
    			} else {
    				addSequential (new Pivot(-80.0)); //turn right 90 degrees
    			}
    			//addSequential (new DriveStraight(0.3, 0.0, 500));
    		
    			addSequential (new moveElevatorAuto(1, 3400));//power encoderDistance
    			addSequential (new holdLift());
        		addSequential (new DriveStraight (0.3, 2.2, 500));
        		Timer.delay(0.5);
        		addParallel (new DriveStraight (0.2, 2, 500));
        		addParallel ( new shootAuto(0.5));
        		//addSequential (new DriveStraight (-0.5, 0.5, 1));
        	
        		
    		} else {
        		addSequential (new DriveStraight (0.5, 4.0, 500));//this just passes autoline
        		
        		
        		
//    	else if (sameScale) {
//    		addSequential (new DriveStraight(0.7, 3, 2600));//power time distance
//    		if (robotPosition.charAt(0) == 'L' ) {
//    			addSequential (new Pivot(-80.0));
//    			} else {
//    				addSequential (new Pivot (80.0));
//    			}	
//    		addSequential (new moveElevatorAuto(0.5, 30000));//Move Elevator Up, to scale height
//    		addSequential (new DriveStraight (0.5, 0.5, 500));//Drive Towards Scale
//    		addParallel ( new shootAuto(0.5));//Shoot Out Cube
//    		addSequential (new DriveStraight (-.5, .5, 1));//lower elevator down
//    		addSequential (new moveElevatorAuto(-0.5,-500));//power encoderDistance
    	
    		
    		}
    		
    	}
    	Timer.delay(2);
    	end();
    } 
}
