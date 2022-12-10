package frc.robot.Auto.Actions;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.subsystems.DriveExample;

public class StopAction {
    DriveExample mAutoDriveExample = new DriveExample();

    public void finalStopAction(){
    mAutoDriveExample.mMotor1FrontRight.set(ControlMode.PercentOutput, 0);
    mAutoDriveExample.mMotor2BackRight.set(ControlMode.PercentOutput, 0);
    mAutoDriveExample.mMotor3FrontLeft.set(ControlMode.PercentOutput, 0);
    mAutoDriveExample.mMotor4BackLeft.set(ControlMode.PercentOutput, 0);
        //mDriveExampleAuto.outMotoresAuto(0, 0, 0, 0);
    }
}

/*-------------------------------------------------------------------------------------------->

Esta accion trabaja heredando una funcion del archivo drive que le da velocidad directa a los motores
es una funcion creada adicionalmente solo para el autonomo y se puede heredar en este archivo desde el objeto.
En este caso se le da la velocidad de 0 a todos los motores para detener el movimiento del chasis

-------------------------------------------------------------------------------------------->*/