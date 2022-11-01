package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class controlBoard extends SubsystemBase {
  //Hardware ----------------------------------------------------------------->
  public final XboxController driverControl = new XboxController(0);
  public final XboxController operatorControl = new XboxController(1);

  //INPUTS ------------------------------------------------------------------>
      
  //OUTPUTS ----------------------------------------------------------------->
      
  //Logic ----------------------------------------------------------------->
  
    
  public controlBoard() {} //constructor del subsistema

  //------------------// Funciones del subsistema //-------------------------------//

  //funcion principal de Drive con argumentos de entrada de controles
  public boolean getXButton(){
    return operatorControl.getRawButton(3);
  }

  public boolean getYButton(){
    return operatorControl.getRawButton(4);
  }

  public double getRightTrigger(){
    return operatorControl.getRawAxis(1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
