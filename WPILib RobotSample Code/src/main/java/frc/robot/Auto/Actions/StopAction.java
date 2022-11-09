package frc.robot.Auto.Actions;

import frc.robot.subsystems.DriveExample;

public class StopAction {
    DriveExample mDriveExampleAuto = new DriveExample();

    public void finalStopAction(){
        mDriveExampleAuto.outMotoresAuto(0, 0, 0, 0);
    }
}

/*-------------------------------------------------------------------------------------------->

Esta accion trabaja heredando una funcion del archivo drive que le da velocidad directa a los motores
es una funcion creada adicionalmente solo para el autonomo y se puede heredar en este archivo desde el objeto.
En este caso se le da la velocidad de 0 a todos los motores para detener el movimiento del chasis

-------------------------------------------------------------------------------------------->*/