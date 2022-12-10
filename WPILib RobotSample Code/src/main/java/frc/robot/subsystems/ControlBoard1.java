package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ControlBoard1 extends SubsystemBase {

  //Hardware ----------------------------------------------------------------->
  private final XboxController operatorControl = new XboxController(Constants.kOperatorControlPort); //declaración del control dentro del puerto 1
  private final XboxController driverControl = new XboxController(Constants.kDriverControlPort); //declaración del control para usarlo en robot

  //INPUTS ------------------------------------------------------------------>

  //OUTPUTS ----------------------------------------------------------------->

  //Logic ----------------------------------------------------------------->
  int Y_LeftAxis = 1, X_LeftAxis = 2, A_Button = 1;
  
  public ControlBoard1(){} //Constructor del subsistema para todas las variables

  //------------------// Funciones del subsistema //-------------------------------//

  //funcion principal de Drive con argumentos de entrada de controles
  public boolean getXButton(){
    return operatorControl.getRawButton(3);
  }

  public boolean getYButton(){
    return operatorControl.getRawButton(4);
  }

  public double getControlYAxis(){
    return operatorControl.getRawAxis(Y_LeftAxis);
  }

  public double getControlYAxisLeft(){
    return driverControl.getRawAxis(1);
  }

  public double getControlXAxisRight(){
    return driverControl.getRawAxis(4);
  }

  public boolean getControlAButton(){ //función que regresa el estado del botón A
      return operatorControl.getRawButton(A_Button); //mandar llamar el ID del control correspondiente al boton A (1)
  }

  public double getDirectThrottle(){
    return ( driverControl.getRawAxis(3)-driverControl.getRawAxis(2) );
  }

  public boolean getAIntakeButton(){
    return driverControl.getRawButton(1);
  }

  public boolean getBArmButton(){
    return driverControl.getRawButton(2);
  }

  //todas las funciones de arriba se pueden heredar en otros archivos

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
