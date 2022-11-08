package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  //Hardware ----------------------------------------------------------------->
  public final DoubleSolenoid pistonIntake = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 7); 
  public final CANSparkMax motorIntake = new CANSparkMax(0, MotorType.kBrushless);

  //INPUTS ------------------------------------------------------------------>
      
  //OUTPUTS ----------------------------------------------------------------->
  double final_intake_demand = 0.7;
    
  //Logic ----------------------------------------------------------------->
  
    
  public Intake() {} //constructor del subsistema

  //------------------// Funciones del subsistema //-------------------------------//

  //funcion principal de Drive con argumentos de entrada de controles
  public void deployIntake(boolean active){
    if(active){
        pistonIntake.set(Value.kForward);
        motorIntake.set(final_intake_demand);
    }
    else{
        pistonIntake.set(Value.kReverse);
        motorIntake.set(0);
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
