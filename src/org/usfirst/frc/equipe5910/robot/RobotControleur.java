package org.usfirst.frc.equipe5910.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotControleur extends IterativeRobot {

	public class CommandeImmobile extends CommandGroup { }
	public class CommandeTrajetR1 extends CommandGroup { }
	public class CommandeTrajetR2 extends CommandGroup { }
	public class CommandeTrajetR3 extends CommandGroup { }
	public class CommandeTrajetB1 extends CommandGroup { }
	public class CommandeTrajetB2 extends CommandGroup { }
	public class CommandeTrajetB3 extends CommandGroup { }
	
    protected SendableChooser<CommandGroup> selecteur;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 * 
	 */
	@Override
	public void robotInit() {
		System.out.println("robotInit()");
		// http://wpilib.screenstepslive.com/s/3120/m/7932/l/81109-choosing-an-autonomous-program-from-smartdashboard
		selecteur = new SendableChooser<CommandGroup>();
		selecteur.addDefault("No move", new CommandeImmobile());
		selecteur.addObject("R1", new CommandeTrajetR1());
		selecteur.addObject("R2", new CommandeTrajetR2());
		selecteur.addObject("R3", new CommandeTrajetR3());	
		selecteur.addObject("B1", new CommandeTrajetB1());
		selecteur.addObject("B2", new CommandeTrajetB2());
		selecteur.addObject("B3", new CommandeTrajetB3());	
		SmartDashboard.putData("Autonomous mode chooser", selecteur);
	}

	/**
	 * This function is run once each time the robot enters autonomous mode
	 */
	@Override
	public void autonomousInit() {
		System.out.println("autonomousInit()");
		SmartDashboard.putString("Mode", "Autonome");		
	}

	int periodeAutonome = 0;
	
	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		System.out.println("autonomousPeriodic()");
		SmartDashboard.putNumber("Periodique", periodeAutonome++);
	}

	/**
	 * This function is called once each time the robot enters tele-operated
	 * mode
	 */
	@Override
	public void teleopInit() {
		System.out.println("teleopInit()");
		SmartDashboard.putString("Mode", "Teleop");
	}

	int periodeTeleop = 0;
	
	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		System.out.println("teleopPeriodic()");
		SmartDashboard.putNumber("Periodique", periodeTeleop++);
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		System.out.println("testPeriodic()");
	}
	
	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testInit() {
		System.out.println("testInit()");
	}
	
}
