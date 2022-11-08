package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ControlBoard1 extends SubsystemBase {

    //Hardware
    private final XboxController control1 = new XboxController(1); //declaración del control dentro del puerto 1

    //INPUTS

    //OUTPUTS

    //Control
    int Y_LeftAxis = 1, X_LeftAxis = 2, A_Button = 1;
  
  public ControlBoard1(){} //Constructor del subsistema para todas las variables

  public double getControlYAxis(){ //esta función manda llamar el objeto del eje y, regresa su valor
    return control1.getRawAxis(Y_LeftAxis);
  }

  public double getControlXAxis(){ //Manda llamar el valor del eje x
    return control1.getRawAxis(X_LeftAxis);
  }

  public boolean getControlAButton(){ //función que regresa el estado del botón A
      return control1.getRawButton(A_Button); //mandar llamar el ID del control correspondiente al boton A (1)
  }

  //todas las funciones de arriba se pueden heredar en otros archivos

  @Override
  public void periodic() {
    
  }

  @Override
  public void simulationPeriodic() {
    
  }
}
