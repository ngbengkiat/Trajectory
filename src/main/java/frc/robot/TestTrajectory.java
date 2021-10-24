package frc.robot;
import java.util.List;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;

//Create the necessary waypoints to test
//Integrate with A* ????????????????????????????????????
public class TestTrajectory {
    private static TrajectoryConfig config = new TrajectoryConfig(0.5, 0.5);

    //Different waypoints for testing
    private static List<Translation2d> waypoints = List.of(
      new Translation2d(0.0, 0.0), //start
      new Translation2d(1.0, 0.5), 
      new Translation2d(1.0, 1.0), 
      new Translation2d(0.1, 1.0)
  
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

    private static Trajectory trajectory =
    MyGenerateTrajectory.generateTrajectory(
        waypoints,
        config, 0.05);

    public static Trajectory getTrajectory() {
        return trajectory;
    }
    public static List<Translation2d> getWayPoints(){
        return waypoints;
    }
}
