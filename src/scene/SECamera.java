/**
 * 
 */

package scene;

import rajawali.Camera;
import main.SENumber3;
import main.SEVector;

/**
 * @author Kevin
 *
 */

public class SECamera {
	
	SEVector Position; //Where the cam is located
	SENumber3 Target; //Where the cam points.
	Camera Cam;       //The  camera object
	
	//Camera attributes
	float FogNear = 0.0f;
	float FogFar = 50.0f;
	boolean Fog = true;
	
	/**
	 * 
	 */
	public SECamera() {
		// TODO Auto-generated constructor stub
		Position = new SEVector();
		Target = new SENumber3(0, 0, 0);
		Cam = new Camera();
	}
	
	//Sets the target of the camera in the direction it is rotated
	public void setTargetToRotation() 
	{
		//Projects points:
		
		//Create a vector to hold the original positions ------MAY WANT TO CHANGE THIS TO CREATING A PROJECTION VECTOR AS OPPOSED TO STORING THE ORIGINAL.
		SEVector OLDPosition = new SEVector();
		OLDPosition.Position.set(this.Position.Position.x, this.Position.Position.y, this.Position.Position.z);
		
		//Move Vector towards it's rotation:
		this.Position.moveTowardsRotation(2);
		this.Target.set(this.Position.Position.x, this.Position.Position.y, this.Position.Position.z);
		
		//Return the Vector to it's original position
		this.Position.Position.set(OLDPosition.Position.x, OLDPosition.Position.y, OLDPosition.Position.z);
	}
	
	//Updates only the position and rotation
	public void updatePosition()
	{
		Cam.setLookAt(Target.x, Target.y, Target.z);
		Cam.setPosition(Position.Position.x, Position.Position.y, Position.Position.z);
	}
	
	//Updates only the attributes
	public void updateAttributes()
	{
		Cam.setFogFar(FogFar);
		Cam.setFogNear(FogNear);
		Cam.setFogEnabled(Fog);
	}
	
	//Updates Attributes and positions(/rotations)
	public void update()
	{
		updatePosition();
		updateAttributes();
	}

}
