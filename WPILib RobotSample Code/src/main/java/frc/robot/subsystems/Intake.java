package frc.robot.subsystems;

import java.lang.module.ModuleReader;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  //Hardware ----------------------------------------------------------------->
  public final DoubleSolenoid pistonIntake = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 7); //declaracion de un double solenoids
  public final TalonSRX motorIntake1 = new TalonSRX(Constants.kIntakeMotorID); //usamos el ID de constants

  //INPUTS ------------------------------------------------------------------>
      
  //OUTPUTS ----------------------------------------------------------------->
  double final_intake_demand = 0.7; //variable para control de velocidad
    
  //Logic ----------------------------------------------------------------->
  
    
  public Intake() {} //constructor del subsistema

  //------------------// Funciones del subsistema //-------------------------------//

  //funcion principal de Drive con argumentos de entrada de controles
  public void deployIntake(boolean active){ //recibimos un argumento con entrada de tipo booleana
    if(active){ //if que evalua la funcion usando el argumento que se le entrega a la funcion
        pistonIntake.set(Value.kForward); //para abrir el piston
        motorIntake1.set(ControlMode.PercentOutput, final_intake_demand);
    }
    else{
        pistonIntake.set(Value.kReverse); //para retraer el pistón 
        motorIntake1.set(ControlMode.PercentOutput, 0);
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
