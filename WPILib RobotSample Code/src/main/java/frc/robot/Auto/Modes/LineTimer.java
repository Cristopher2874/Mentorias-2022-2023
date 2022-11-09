package frc.robot.Auto.Modes;

import frc.robot.Auto.Actions.GetTimeAction;
import frc.robot.Auto.Actions.MoveForwardAction;
import frc.robot.Auto.Actions.StopAction;
import frc.robot.subsystems.DriveExample;

public class LineTimer{
  DriveExample mAutoDriveExample = new DriveExample();
  MoveForwardAction mForwardAction = new MoveForwardAction();
  StopAction mStopAction = new StopAction();
  GetTimeAction mGetTimeAction = new GetTimeAction();
  
  public void finalLineTimer(){
    if(mGetTimeAction.getAbsoluteTimer()-mGetTimeAction.getRelativeTimer()<3){
        mForwardAction.finalMoveForwardACtion();
      }
      else mStopAction.finalStopAction();
  }
}

/*-------------------------------------------------------------------------------------------->

Esta es una rutina que hereda varias funciones de otras acciones que están arriba, se declaran los objetos
para cada accion y luego se mandan llamar en la rutina que luego se vuelve a heredar en el robot.

-------------------------------------------------------------------------------------------->*/