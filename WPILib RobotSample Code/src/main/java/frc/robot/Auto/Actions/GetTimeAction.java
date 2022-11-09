package frc.robot.Auto.Actions;

import edu.wpi.first.wpilibj.Timer;

public class GetTimeAction{
  double absoluteTimer;
  double relativeTimer;

  public void autoAbsoluteTimeControl(){
    absoluteTimer = Timer.getFPGATimestamp();
  }
  public void autoRelativeTimeControl(){
    relativeTimer = Timer.getFPGATimestamp();
  }
  public double getAbsoluteTimer(){
    return absoluteTimer;
  }
  public double getRelativeTimer(){
    return relativeTimer;
  }
}

/*-------------------------------------------------------------------------------------------->

Esta accion inicia un contador de tiempo, desde cuando se inicia el robot y cuando se manda llamar el 
relative timer, cuando se inicia el robot es el absolute y cuando se manda llamar en el auto es el 
relative, cada uno se hereda en el archivo del robot en la parte de autonomous init

-------------------------------------------------------------------------------------------->*/