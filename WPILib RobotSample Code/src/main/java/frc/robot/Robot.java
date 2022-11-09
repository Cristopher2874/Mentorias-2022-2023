package frc.robot;

//imports que se agregan en el codigo
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Auto.Actions.GetTimeAction;
import frc.robot.Auto.Actions.MoveForwardAction;
import frc.robot.Auto.Actions.StopAction;
import frc.robot.Auto.Modes.LineTimer;
import frc.robot.subsystems.DriveExample;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer; 
  //aqui declaramos todo lo que vamos a usar
  //NO SE DEBE PONER PASOS DE LOGICA, SIMPLEMENTE DECLARAR O INICIALIZAR VARIABLES

  DriveExample mDriveExample = new DriveExample(); //Declaración de un objeto tipo DriveExample para poder usar las funciones dentro de ese archivo
  //podemos mandar llamar las funciones usando el nombre del nuevo objeto

  //Neumatica
  Compressor compressor1 = new Compressor(0,PneumaticsModuleType.CTREPCM); //creas el objeto compresor para poder usarlo
  private final Solenoid piston2 = new Solenoid(PneumaticsModuleType.CTREPCM, 0); //declaracion del piston de un single solenoid
  private final DoubleSolenoid pistonDoble2 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 6); //declaracion dle objeto de pistón con double solenoid

  private final XboxController control1 = new XboxController(0); //declaración del control para usarlo en robot

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

  //Declaramos los objetos de los archivos del autonomo para poder heredar las funciones de cada uno
  GetTimeAction mAutoTimer = new GetTimeAction();
  MoveForwardAction mMoveForwardAction = new MoveForwardAction();
  StopAction mStopAction = new StopAction();
  LineTimer mLineTimerMode = new LineTimer();

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
    //aqui se inicializan los motores y la informacion total
    motor1.set(0.0); //set todos los motores a 0 para que esten quietos
    motor2.set(0.0);
    motor3.set(0.0);
    mMotor1FrontRight.set(ControlMode.PercentOutput, 0); //declaracion de la velocidad para el motor tipo talon
    
    //Inicializar el compresor para que encienda
    compressor1.enableDigital(); //inicializamos el compresor con pressureSwitch digital
    compressor1.disable(); //desabilitamos inicialmente
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

    //Aqui va todo lo que hay que declarar cuando inicie el autonomo

    mAutoTimer.autoRelativeTimeControl(); //inicializar el timeStap relativo a auto
  }

  @Override
  public void autonomousPeriodic() {

    //Aqui va todo lo que se va a ejecutar durante el autonomo

    mAutoTimer.autoAbsoluteTimeControl(); //inicializa el timeStap absoluto
    if(mAutoTimer.getAbsoluteTimer()-mAutoTimer.getRelativeTimer()<2){ //esta lógica se manda llamar para contar el tiempo que se tarda en ejecutar la accion (2 seg en este caso)
      mMoveForwardAction.finalMoveForwardACtion(); //mandar llamar la funcion del subsistema de auto
    }
    else mStopAction.finalStopAction(); //detener el robot cuando haya pasado el tiempo que se pidio
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    //Aqui se pone lo que hay que hacer al iniciar el teleoperado
  }

  //Lo que se va a ejecutar durante el match
  @Override
  public void teleopPeriodic() {

    //en esta parte se agrega la LOGICA y las funciones de todo lo que se va a hacer en el teleoperado

    rightDemand = control1.getRawAxis(3); //obtener los datos del control y pasarlos a las variables
    leftDemand = control1.getRawAxis(2); //cada variable que declaramos en el robot container se iguala a un valor del control
    totalDemand = control1.getRawAxis(1);
    Abutton = control1.getAButtonReleased();
    Bbutton = control1.getRawButton(2);
    Xbutton = control1.getXButtonPressed();

    rightDemand = Math.abs(rightDemand) < 0.15 ? 0 : control1.getRawAxis(3); //mapeo para sticks y triggers
    leftDemand = Math.abs(leftDemand) < 0.15 ? 0 : control1.getRawAxis(2); //quita los valores pequeños para que no se muevan solos
    totalDemand = Math.abs(totalDemand) < 0.15 ? 0 : control1.getRawAxis(1);

    motor1.set(rightDemand); //dar la potencia a los motores tipo NEO
    motor2.set(leftDemand);
    
    compressor1.enableDigital(); //habilitar el compresor durante el teleoperado
    
    if(Bbutton) piston2.set(true); //activar pistonres a partir del valor del pistón
    else piston2.set(false);

    pistonDoble2.set(Value.kForward); //habilita el compresor con double solenoid para que se abra
    pistonDoble2.set(Value.kReverse); //habilita el compresor con double solenoid para que se cierre
      
    boolean enabled = compressor1.enabled(); //revisar estado de compresor
    boolean pressureSwitch = compressor1.getPressureSwitchValue(); //revisar estado de pressureSwitch
    
    
    SmartDashboard.putNumber("rightDemand", rightDemand); //funciones para ver datos en SmartDashBoard
    SmartDashboard.putNumber("leftDemand", leftDemand); //cada función da una salida a la SmartDashBoard
    SmartDashboard.putNumber("rawDemandA1", totalDemand);
    SmartDashboard.putBoolean("bButton", Bbutton);
    SmartDashboard.putBoolean("comEnabled", enabled);
    SmartDashboard.putBoolean("comPressure", pressureSwitch);

    //funciones con POO

    mDriveExample.SimpleDrive(); //mandamos llamar la función de simpleDrive desde el archivo de DriveExample
    mDriveExample.HeredaExample(); //mandamos llamar la segunda función del subsistema
    mDriveExample.ControledSpeed(0.5); //esta es una función que recibe un argumento, le damos el argumento que pide de tipo double, puede ser una entrada o una variable
    mDriveExample.ControledSpeed(leftDemand); //aqui le damos como argumento a la función el valor de una variable
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
