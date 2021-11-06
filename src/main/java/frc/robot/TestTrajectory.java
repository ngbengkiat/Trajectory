package frc.robot;
import java.util.List;

import edu.wpi.first.wpilibj.controller.HolonomicDriveController;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.constraint.CentripetalAccelerationConstraint;

//Create the necessary waypoints to test
//Integrate with A* ????????????????????????????????????
public class TestTrajectory {
  HolonomicDriveController m;
    private CentripetalAccelerationConstraint curveConstraint = new CentripetalAccelerationConstraint(1.0);
    private TrajectoryConfig config = new TrajectoryConfig(0.5, 0.5).addConstraint(curveConstraint);
    //Different waypoints for testing
    private List<Translation2d> waypoints = List.of(
      new Translation2d(0.5, 0.0), //start
      new Translation2d(0.5, 0.5), 
      new Translation2d(1.0, 0.5)
      // new Translation2d(1.0, 0.5), 
      // new Translation2d(1.0, 1.0), 
      // new Translation2d(0.0, 1.0)
  
    );
    private List<Translation2d> waypoints2 = List.of(
      new Translation2d(0.5, 0.5), //start
      new Translation2d(1.0, 0.5), 
      new Translation2d(1.0, 1.0),
      new Translation2d(0.5, 1.0),
      new Translation2d(0.25, 0.75),
      new Translation2d(0.25, 0.5),
      new Translation2d(0.5, 0.25),
      new Translation2d(1.0, 0.25),
      new Translation2d(1.25, 0.5),
      new Translation2d(1.25, 1.0),
      new Translation2d(1.0, 1.25),
      new Translation2d(0.75, 1.25),
      new Translation2d(0.75, 0.75) //end
  
    );
    private List<Translation2d> waypoints3 = List.of(
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

    private MyGenerateTrajectory myGenerateTrajectory = new MyGenerateTrajectory();
    private Trajectory trajectory =
    myGenerateTrajectory.generateTrajectoryClampedCubic(waypoints2, config, 0.04);
    //myGenerateTrajectory.generateTrajectoryQuinticHermite(waypoints2, config, 0.05);
    private List<Translation2d> myIntermediateWP = myGenerateTrajectory.getIntermediateWP();
    public Trajectory getTrajectory() {
        return trajectory;
    }
    public List<Translation2d> getWayPoints(){
      return waypoints2;
  }
  public List<Translation2d> getIntermediateWP(){
    return myIntermediateWP;
}
}
