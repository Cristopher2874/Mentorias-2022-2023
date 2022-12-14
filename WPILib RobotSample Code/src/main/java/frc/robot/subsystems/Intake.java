package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  //Hardware ----------------------------------------------------------------->
  //public final TalonSRX motorIntake1 = new TalonSRX(Constants.kIntakeId); //usamos el ID de constants
  public final VictorSPX motorIntake1 = new VictorSPX(Constants.kIntakeId);
  public final VictorSPX motorIntake2 = new VictorSPX(5);

  //INPUTS ------------------------------------------------------------------>
      
  //OUTPUTS ----------------------------------------------------------------->
  double final_intake_demand = 0.7; //variable para control de velocidad
    
  //Logic ----------------------------------------------------------------->
  
    
  public Intake() {} //constructor del subsistema

  //------------------// Funciones del subsistema //-------------------------------//

  //funcion principal de Drive con argumentos de entrada de controles
  public void deployIntake(boolean active){
    if(active){ //if que evalua la funcion usando el argumento que se le entrega a la funcion
        motorIntake1.set(ControlMode.PercentOutput, final_intake_demand);
        motorIntake2.set(ControlMode.PercentOutput, final_intake_demand);
    }
    else{
        motorIntake1.set(ControlMode.PercentOutput, 0);
        motorIntake2.set(ControlMode.PercentOutput, 0);
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
