package frc.robot;

import java.io.Externalizable;
import java.util.EnumMap;

import javax.sql.XAConnectionBuilder;

//imports que se agregan en el codigo
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer; //aqui declaramos todo lo que vamos a usar

  //Neumatica
  Compressor compressor1 = new Compressor(0,PneumaticsModuleType.CTREPCM); //creas el objeto compresor
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
  private final XboxController control1 = new XboxController(0);

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
    //aqui se inicializan los motores y la informacion total
    motor1.set(0.0); //set todos los motores a 0 para que esten quietos
    motor2.set(0.0);
    motor3.set(0.0);
    mMotor1FrontRight.set(ControlMode.PercentOutput, 0);
    
    //Inicializar el compresor para que encienda
    compressor1.enableDigital();
    compressor1.disable();    
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
    rightDemand = control1.getRawAxis(3); //obtener los datos del control y pasarlos a las variables
    leftDemand = control1.getRawAxis(2);
    totalDemand = control1.getRawAxis(1);
    Abutton = control1.getAButtonReleased();
    Bbutton = control1.getRawButton(2);
    Xbutton = control1.getXButtonPressed();

    rightDemand = Math.abs(rightDemand) < 0.15 ? 0 : control1.getRawAxis(3); //mapeo para sticks y triggers
    leftDemand = Math.abs(leftDemand) < 0.15 ? 0 : control1.getRawAxis(2);
    totalDemand = Math.abs(totalDemand) < 0.15 ? 0 : control1.getRawAxis(1);

    motor1.set(rightDemand); //dar la potencia a los motores
    motor2.set(leftDemand);
    
    compressor1.enableDigital(); //habilitar el compresor
    
    if(Bbutton) piston2.set(true); //activar pistonres
    else piston2.set(false);
      
    boolean enabled = compressor1.enabled(); //revisar estado de compresor
    boolean pressureSwitch = compressor1.getPressureSwitchValue(); //revisar estado de pressureSwitch
    
    
    SmartDashboard.putNumber("rightDemand", rightDemand); //funciones para ver datos en SmartDashBoard
    SmartDashboard.putNumber("leftDemand", leftDemand);
    SmartDashboard.putNumber("rawDemandA1", totalDemand);
    SmartDashboard.putBoolean("bButton", Bbutton);
    SmartDashboard.putBoolean("comEnabled", enabled);
    SmartDashboard.putBoolean("comPressure", pressureSwitch);
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
