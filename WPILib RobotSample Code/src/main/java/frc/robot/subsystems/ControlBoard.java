package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ControlBoard extends SubsystemBase {

    //Hardware
    private final XboxController control1 = new XboxController(0); //declaración del control

    //INPUTS

    //OUTPUTS

    //Control
    int Y_LeftAxis = 1, X_LeftAxis = 2;
  
  public ControlBoard(){} //Constructor del subsistema para todas las variables

  public double getControlYAxis(){ //esta función manda llamar el objeto del eje y, regresa su valor
    return control1.getRawAxis(Y_LeftAxis);
  }

  public double getControlXAxis(){ //Manda llamar el valor del eje x
    return control1.getRawAxis(X_LeftAxis);
  }

  public boolean getControlAButton(){ //función que regresa el estado del botón A
      return control1.getAButton();
  }

  @Override
  public void periodic() {
    
  }

  @Override
  public void simulationPeriodic() {
    
  }
}
