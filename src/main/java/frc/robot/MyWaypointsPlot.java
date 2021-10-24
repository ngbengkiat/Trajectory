package frc.robot;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.List;
import java.awt.geom.GeneralPath;
import java.util.List;

import javax.swing.JComponent;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;


class MyWaypointsPlot extends JComponent {
  //Drawing sale
  private static final int SCALE = 200;

    public void drawCircle(Graphics2D g, int x, int y, int r) {
        x = x-(r/2);
        y = y-(r/2);
        g.fillOval(x,y,r,r);
      }
  @Override
  public void paint(Graphics g) {
    
      Graphics2D g2 = (Graphics2D) g;

      g2.setStroke(new BasicStroke(2.0f));
      g2.setPaint(Color.GREEN);

    
      //////////////////////////////////////////////////////////////
      // Plot trajectory path
      //////////////////////////////////////////////////////////////
      Trajectory traj = TestTrajectory.getTrajectory();

      double dT = 0.02;
      int N = (int)(traj.getTotalTimeSeconds()/dT) + 1;

      GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD, N);

      Pose2d p = traj.sample(0).poseMeters;

      path.moveTo(p.getTranslation().getX()*SCALE, p.getTranslation().getY()*SCALE);
      for (double t=0.0; t<=traj.getTotalTimeSeconds(); t+=dT) {
          p = traj.sample(t).poseMeters;
          path.lineTo(p.getTranslation().getX()*SCALE, p.getTranslation().getY()*SCALE);
      }
      g2.draw(path);

      //////////////////////////////////////////////////////////////
      //Plot waypoints for comparison
      //////////////////////////////////////////////////////////////
      g2.setPaint(Color.BLUE);
      List<Translation2d> waypoints = TestTrajectory.getWayPoints();
      for (int i=0; i<waypoints.size(); i++) {
        drawCircle(g2, (int)(waypoints.get(i).getX()*SCALE), (int)(waypoints.get(i).getY()*SCALE), 5 );
      }
     
  }
}
