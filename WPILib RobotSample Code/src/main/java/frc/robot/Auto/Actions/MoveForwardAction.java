package frc.robot.Auto.Actions;

import frc.robot.subsystems.DriveExample;

public class MoveForwardAction{
  DriveExample mAutoDriveExample = new DriveExample();
  
  public void finalMoveForwardACtion(){
    mAutoDriveExample.outMotoresAuto(0.3, 0.3, -0.3, -0.3);
  }
}

/*-------------------------------------------------------------------------------------------->

Esta accion trabaja heredando una funcion del archivo drive que le da velocidad directa a los motores
es una funcion creada adicionalmente solo para el autonomo y se puede heredar en este archivo desde el objeto

-------------------------------------------------------------------------------------------->*/