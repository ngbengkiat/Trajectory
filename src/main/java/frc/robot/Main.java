package frc.robot;
import javax.swing.JFrame;


public class Main {
  public static void main(String[] a) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setBounds(30, 30, 450, 450);
    window.getContentPane().add(new MyWaypointsPlot());
    window.setVisible(true);
  }
}