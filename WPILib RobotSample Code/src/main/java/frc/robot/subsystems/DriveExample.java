package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveExample extends SubsystemBase {

  ControlBoard1 mOperatorControl = new ControlBoard1();//declaracion de un objeto tipo ControlBoard para usar las funciones de ese archivo

  //ponemos el nombre del archivo, luego el nombre del objeto (puede ser el que quieran) y lo igualamos a un nuevo constructor

  //Hardware ----------------------------------------------------------------->
  TalonSRX motorDrive1 = new TalonSRX(Constants.kFrontRightDriveID); //declaración de los motores dentro del subsistema
  TalonSRX motorDrive2 = new TalonSRX(Constants.kFrontLeftDriveID); //cada ID se declara en el archivo de constants
  TalonSRX motorDrive3 = new TalonSRX(Constants.kBackLeftDriveID); //se heredan los ID's desde el otro archivo para cambiarlos facilmente
  TalonSRX motorDrive4 = new TalonSRX(Constants.kBackRightDriveID);

  //INPUTS ------------------------------------------------------------------>

  //OUTPUTS ----------------------------------------------------------------->

  //Logic ----------------------------------------------------------------->
  final double speed = 0.5;
  double stickInput = 0; //variable para guardar los datos del stick
  
  public DriveExample() {} //constructor del subsistema para hacer pasos logicos

  //------------------// Funciones del subsistema //-------------------------------//

  //Declaracion de una funcion dentro del subsistema
  public void SimpleDrive(){
    motorDrive1.set(ControlMode.PercentOutput, speed); //se le da la velocidad de la variable que se declaró arriba
    motorDrive2.set(ControlMode.PercentOutput, -speed);
    motorDrive3.set(ControlMode.PercentOutput, -speed);
    motorDrive4.set(ControlMode.PercentOutput, speed);
  }
  //esta función se puede mandar llamar en el robot

  public void HeredaExample(){
    stickInput = mOperatorControl.getControlXAxis(); //usamos el objeto tipo ControlBoard para mandar llamar una función dentro de ese archivo, en este caso mandamos llamar getControlXAxis
    //estamos heredando la función dentro del subsistema de Drive
  } //esta es una segunda función del subsistema

  public void ControledSpeed(double speedIn){ //esta es una función que recibe un argumento
    motorDrive1.set(ControlMode.PercentOutput, speedIn); //usamos el argumento de la función para darle velocidad al motor
  }

  @Override
  public void periodic() {
    
  }

  @Override
  public void simulationPeriodic() {
    
  }
}
