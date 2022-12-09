package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Auto.Actions.GetTimeAction;
import frc.robot.Auto.Actions.MoveForwardAction;
import frc.robot.Auto.Actions.StopAction;
import frc.robot.Auto.Modes.LineTimer;
import frc.robot.subsystems.ControlBoard1;
import frc.robot.subsystems.DriveExample;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.cajasSub;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  //private RobotContainer m_robotContainer; 

  DriveExample mDriveExample = new DriveExample();
  ControlBoard1 mControl = new ControlBoard1();
  Intake mIntake = new Intake();
  cajasSub mArm = new cajasSub();

  //Declaramos los objetos de los archivos del autonomo para poder heredar las funciones de cada uno
  GetTimeAction mAutoTimer = new GetTimeAction();
  MoveForwardAction mMoveForwardAction = new MoveForwardAction();
  StopAction mStopAction = new StopAction();
  LineTimer mLineTimerMode = new LineTimer();

  @Override
  public void robotInit() {
    //m_robotContainer = new RobotContainer();
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
    //compressor1.enableDigital(); //habilitar el compresor durante el teleoperado
      
    //boolean enabled = compressor1.enabled(); //revisar estado de compresor
    //boolean pressureSwitch = compressor1.getPressureSwitchValue(); //revisar estado de pressureSwitch

    //funciones con POO
    mArm.deployArm(mControl.getBArmButton());
    mIntake.deployIntake(mControl.getAIntakeButton());
    mDriveExample.mainDrive(mControl.getControlXAxisRight(), mControl.getControlYAxisLeft(), mControl.getDirectThrottle());
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
