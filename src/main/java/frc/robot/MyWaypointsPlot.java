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
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;


class MyWaypointsPlot extends JComponent {
  //Drawing sale
  private static final int SCALE = 200;

  private static TrajectoryConfig config = new TrajectoryConfig(0.5, 0.5);

  //Different waypoints for testing
  private static List<Translation2d> waypoints = List.of(
    new Translation2d(0.5, 0.5), //start
    new Translation2d(1.0, 1.0), //
    new Translation2d(2.0, 1.0), //
    new Translation2d(1.5, 1.5) //end

  );
  private static List<Translation2d> waypoints2 = List.of(
    new Translation2d(0.5, 0.5), //start
    new Translation2d(1.5, 0.5), 
    new Translation2d(1.5, 1.5),
    new Translation2d(0.5, 1.5),
    new Translation2d(0.5, 1.0),
    new Translation2d(0.0, 1.0) //end

  );
  private static List<Translation2d> waypoints3 = List.of(
    //Intermediate points manually created. For testing purpose
    new Translation2d(0.5, 0.5), //start
    new Translation2d(1.4, 0.5), 
    new Translation2d(1.5, 0.6), 
    new Translation2d(1.5, 1.4), 
    new Translation2d(1.4, 1.5),
    new Translation2d(0.6, 1.5),
    new Translation2d(0.5, 1.4),
    new Translation2d(0.5, 1.1),
    new Translation2d(0.4, 1.0),
    new Translation2d(0.0, 1.0) //end
  );
  private static Trajectory traj =
  MyGenerateTrajectory.generateTrajectory(
      waypoints,
      config, 0.05);

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

      double dT=0.02;

      int N = (int)(traj.getTotalTimeSeconds()/dT) + 1;
      int[] xPoints = new int[N];
      int[] yPoints = new int[N];
      int n=0;

      for (double t=0.0; t<=traj.getTotalTimeSeconds(); t+=dT) {
        Pose2d p = traj.sample(t).poseMeters;
        //Convert trajectory points to Graphic integer points
        xPoints[n] = (int)(p.getTranslation().getX()*SCALE);
        yPoints[n] = (int)(p.getTranslation().getY()*SCALE);
 
        n++;
      }

      GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
          xPoints.length);

      // Adds point to the path by moving to the specified
      // coordinates.
      path.moveTo(xPoints[0], yPoints[0]);
      for (int i = 1; i < xPoints.length; i++) {
          // Adds a point to the path by drawing a straight
          // line from the current position to the specified
          // coordinates.
          path.lineTo(xPoints[i], yPoints[i]);
      }
      g2.draw(path);

      g2.setPaint(Color.BLUE);
      for (int i=0; i<waypoints.size(); i++) {
        drawCircle(g2, (int)(waypoints.get(i).getX()*SCALE), (int)(waypoints.get(i).getY()*SCALE), 5 );
      }
     
  }
}
