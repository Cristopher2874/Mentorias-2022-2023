package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class cajasSub extends SubsystemBase {
  //Hardware ----------------------------------------------------------------->
  public final TalonSRX motorBrazo = new TalonSRX(6); //usamos el ID de constants
  //public final VictorSpx motorBrazo = new TalonSRX(6); //usamos el ID de constants

  //INPUTS ------------------------------------------------------------------>
      
  //OUTPUTS ----------------------------------------------------------------->
  double final_brazo_demand = 0.7; //variable para control de velocidad
    
  //Logic ----------------------------------------------------------------->
  
    
  public cajasSub() {} //constructor del subsistema

  //------------------// Funciones del subsistema //-------------------------------//

  //funcion principal de Drive con argumentos de entrada de controles
  public void deployArm(boolean active){
    if(active){ //if que evalua la funcion usando el argumento que se le entrega a la funcion
        motorBrazo.set(ControlMode.PercentOutput, final_brazo_demand);
    }
    else{
        motorBrazo.set(ControlMode.PercentOutput, 0);
    } 
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
