package frc.robot.Auto.Actions;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.subsystems.DriveExample;

public class MoveForwardAction{
  DriveExample mAutoDriveExample = new DriveExample(); //aquí se crea un objeto de tipo drive para usar los motores del chasis
  
  public void finalMoveForwardACtion(){
    mAutoDriveExample.mMotor1FrontRight.set(ControlMode.PercentOutput, 0.3);
    mAutoDriveExample.mMotor2BackRight.set(ControlMode.PercentOutput, 0.3);
    mAutoDriveExample.mMotor3FrontLeft.set(ControlMode.PercentOutput, -0.3);
    mAutoDriveExample.mMotor4BackLeft.set(ControlMode.PercentOutput, -0.3);
//    mAutoDriveExample.outMotoresAuto(0.3, 0.3, -0.3, -0.3);
/*
Lo que hace esta función es ponerle la velocidad a los motores del chasis para que avancen
Los signos de las velocidades dependen de cada chasis y su orientación
solo es cambiarlos y modificar la velocidad en caso de ser necesario
*/
  }
}

/*-------------------------------------------------------------------------------------------->

Esta accion trabaja heredando una funcion del archivo drive que le da velocidad directa a los motores
es una funcion creada adicionalmente solo para el autonomo y se puede heredar en este archivo desde el objeto

-------------------------------------------------------------------------------------------->*/