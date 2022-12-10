package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Auto.Actions.GetTimeAction;
import frc.robot.Auto.Actions.MoveForwardAction;
import frc.robot.Auto.Actions.StopAction;
import frc.robot.Auto.Actions.deployIntake;
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
  //aquí se tienen todos los objetos que van a ser necesarios
  GetTimeAction mAutoTimer = new GetTimeAction();
  MoveForwardAction mMoveForwardAction = new MoveForwardAction();
  StopAction mStopAction = new StopAction();
  deployIntake mDeployIntake = new deployIntake();

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
    mAutoTimer.autoRelativeTimeControl();
    /*
    autoRelativeTimeControl es una función del archivo de Actions GetTimeAction que manda llamar
    el tiempo desde que se inicia el autónomo. La función  está comentada en el mismo archivo
    */
  }

  @Override
  public void autonomousPeriodic() {

    //Aqui va todo lo que se va a ejecutar durante el autonomo

    mAutoTimer.autoAbsoluteTimeControl();
    /*
    autoAbsoluteTimeControl es una función del archivo de Actions GetTimeAction que manda llamar
    el tiempo desde que empieza el robot el autónomo
    */

    double difTime = mAutoTimer.getAbsoluteTimer()-mAutoTimer.getRelativeTimer(); 

    /*
    Esta variable guarda la diferencia entre ambos timers para obtener el tiempo que lleva el robot en autónomo
    Las funciones que usa están declaradas en el mismo archivo de GetTimeAction
    */

    if(difTime<2){ //esta lógica se manda llamar para contar el tiempo que se tarda en ejecutar la accion (2 seg en este caso)
      mMoveForwardAction.finalMoveForwardACtion(); //mandar llamar la funcion del subsistema de auto MoveForwardAction
      //La función hace que los motores se muevan para que el robot avance
      //el objeto de mMoveForwardAction se declara debajo de robotContainer
    }
    else if(difTime>2 && difTime<4){ //aquí el difTime sigue contando y una vez que pasan los dos segundos se usa un else if para poner la siguiente acción
      //la siguiente acción va a durar también 2 segundos
      mDeployIntake.finalDeployIntakeAction();
      //mandar llamar la funcion del subsistema de auto deployIntake
      //La función hace que el motor del intake se active
      //el objeto de mMoveForwardAction se declara debajo de robotContainer
      mStopAction.finalStopAction(); //mandamos llamar también la acción de que detenga el chasis
      //la acción está en StopAction donde todos los motores se ponen en cero
      //en este punto se detiene el chasis y se activa el motor del intake
    } //En este punto también se pueden agregar todos los else if que sean necesarios para hacer varias acciones
    //tienen que considerar que tienen que ir en secuencia y si activan algo hay que desactivarlo en otro tiempo
    //si no lo desactivan se va a quedar prendido hasta el final del autónomo
    else{
      mDeployIntake.finalStopIntakeAction(); // aquí cuando termina las demás acciones hacemos que se detenga el intake
      //como el chasis ya está en cero se termina solo deteniendo el Intake con esta función
      //En caso de haber puesto otros motores a funcionar es necesario que se detengan o nunca se van a frenar
      //es por safety
    } 

    /*
    Como recomendación general hagan que durante el autónomo el robot avance lentamente a no más de 0.3 de velocidad para
    que el caso de que no se detenga no termine dañando a la cancha u otras personas
    Consideren hacer acciones simples como vimos en mentorías, si no funciona la acción de avanzar, hagan que funcione antes 
    de que traten de hacer algo más complejo
    Lo más simple que puede funcionar y que estaría recomendable que hicieran es que primero hagan que su robot
    avance y se detenga fuera del cuadro inicial para ganar esos puntos
    Al final no queremos que sus robots terminen descalificados, entonces especialmente para el autónomo, busquen tener 
    cuidado de lo que va a hacer, pruébenlo en la escalera y decidan si es rentable que se ponga en un match
    Para dudas, sigo disponible
    */
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
    mArm.deployArm(mControl.getControlYAxis());
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
