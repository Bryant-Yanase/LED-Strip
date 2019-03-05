/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.constants.Constants;

/**
 * Add your docs here.
 */
public class LedArduino extends Subsystem {
  public SerialPort m_adruino;
  public LedArduino(){
    m_adruino = new SerialPort(115200, SerialPort.Port.kUSB1);
  }

  public void makeLEDBlue(){
    m_adruino.write(Constants.kWesleyBlue.getBytes(), Constants.kWesleyBlue.length());
    // Timer.delay(0.1);
  }

  public void makeLEDRed(){
    String red = "255 0 0";
    m_adruino.write(red.getBytes(), red.length());
    // Timer.delay(0.1);
  }

  public void makeColor(int r, int g, int b){
    String color = String.valueOf(r) + " " + String.valueOf(g) + " " + String.valueOf(b);
    SmartDashboard.putString("color you chose", color);
    m_adruino.write(color.getBytes(), color.length());
    // Timer.delay(0.1);
  }
  
  public byte[] readStuff(){
    return m_adruino.read(16);
  }

  public void reportToSmartDashBoard(){
    SmartDashboard.putString("Adruino Says: ", new String(readStuff()));
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
