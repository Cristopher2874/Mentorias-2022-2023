package frc.robot.Auto.Actions;

import edu.wpi.first.wpilibj.Timer;

public class GetTimeAction{
  double absoluteTimer;
  double relativeTimer;

  public void autoAbsoluteTimeControl(){
    absoluteTimer = Timer.getFPGATimestamp();
  }

  /*
  Esta función de arriba es la que se manda llamar en el Autonomous Periodic
  */

  public void autoRelativeTimeControl(){
    relativeTimer = Timer.getFPGATimestamp();
  }
  
  /*
  Esta función de arriba es la que se manda llamar en el Autonomous Init
  */

  public double getAbsoluteTimer(){
    return absoluteTimer;
  }
  public double getRelativeTimer(){
    return relativeTimer;
  }

  /*
  Las dos funciones de arriba son para recuperar el valor de los timers que se mandan llamar en el autonomo
  */
}

/*-------------------------------------------------------------------------------------------->

Esta accion inicia un contador de tiempo, desde cuando se inicia el robot y cuando se manda llamar el 
relative timer, cuando se inicia el robot es el absolute y cuando se manda llamar en el auto es el 
relative, cada uno se hereda en el archivo del robot en la parte de autonomous init

-------------------------------------------------------------------------------------------->*/