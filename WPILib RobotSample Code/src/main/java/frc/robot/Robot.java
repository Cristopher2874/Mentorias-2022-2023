package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.Feeder;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer; //aqui declaramos todo lo que vamos a usar
  //Neumatica
  Compressor compressor1 = new Compressor(0,PneumaticsModuleType.CTREPCM); //creas el objeto compresor para poder usarlo
  private final Solenoid piston2 = new Solenoid(PneumaticsModuleType.CTREPCM, 0); //declaracion del piston

  //Declaracion de motores
  private TalonSRX mMotor1FrontRight = new TalonSRX(6);  //Declaracion de un Talon con ID = 6
  private CANSparkMax motor1 = new CANSparkMax(1, MotorType.kBrushless); //Declaracion de un NEO con ID = 1
  private CANSparkMax motor2 = new CANSparkMax(14, MotorType.kBrushless);
  private CANSparkMax motor3 = new CANSparkMax(3, MotorType.kBrushless);
  
  //Variables
  double rightDemand = 0; 
  double leftDemand = 0;
  double totalDemand = 0;
  boolean flag = true;
  boolean Abutton = false;
  boolean Bbutton = false;
  boolean Xbutton = false;
  double speedF = 0.8;

  //Declaracion del control
  
  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();

  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  //Lo que se va a ejecutar durante el match
  @Override
  public void teleopPeriodic() {
    //mFeeder.activateFeeder(0.8);
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
