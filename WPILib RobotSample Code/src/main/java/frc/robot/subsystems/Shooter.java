package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  //Hardware ----------------------------------------------------------------->
  public final TalonFX motorShooter1 = new TalonFX(0);
  public final TalonFX motorShooter2 = new TalonFX(1);

  //INPUTS ------------------------------------------------------------------>
      
  //OUTPUTS ----------------------------------------------------------------->
  double final_shooter_demand;
    
  //Logic ----------------------------------------------------------------->
  
    
  public Shooter() {} //constructor del subsistema

  //------------------// Funciones del subsistema //-------------------------------//

  //funcion principal de Drive con argumentos de entrada de controles
  public void activateShooter(double feederSpeed){
    motorShooter1.set(ControlMode.PercentOutput, feederSpeed);
    motorShooter2.set(ControlMode.PercentOutput, -feederSpeed);
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
