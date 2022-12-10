package frc.robot.Auto.Actions;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.subsystems.Intake;


public class deployIntake{
  Intake mAutoIntake = new Intake(); //se declara un objeto de tipo Intake para poder usar el motor
  
  public void finalDeployIntakeAction(){
    mAutoIntake.motorIntake1.set(ControlMode.PercentOutput, 0.5);
/*
Lo que hace esta segunda función es activar el motor del Intake para que se mueva
La velocidad y el signo también se pueden cambiar dependiendo del motor
*/
  }

  public void finalStopIntakeAction(){
    mAutoIntake.motorIntake1.set(ControlMode.PercentOutput, 0);
/*
Esta función se llama en el autónomo y es para detener el motor del intake
*/
  }
}

/*-------------------------------------------------------------------------------------------->

Esta accion trabaja heredando una funcion del archivo Intake que le da velocidad directa a los motores
es una funcion creada adicionalmente solo para el autonomo y se puede heredar en este archivo desde el objeto

-------------------------------------------------------------------------------------------->*/