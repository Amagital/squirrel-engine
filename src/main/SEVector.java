package main;

import main.SENumber3;

public class SEVector {

	public SENumber3 Position;
	public SENumber3 Rotation;
	public SENumber3 Velocity;
	
	public SEVector() {
		//Create the Zero Vector
		Position = new SENumber3(0, 0, 0);
		Rotation = new SENumber3(0, 0, 0);
		Velocity = new SENumber3(0, 0, 0);
	}
	
	//Applies the Velocity to the positions
	public void applyVelocity() {
		Position.set(Position.x + Velocity.x, Position.y + Velocity.y, Position.z + Velocity.z);
	}
	
	//moves towards the rotation
	/*
	 * Two move towards rotation functions
	 * The second one supports moving on only some axes 
	 * (by flagging the axis as true that you want to move on)
	 */
	public void moveTowardsRotation(float speed) {
		float rotationX = (float)Math.cos((double)Rotation.x);
		float rotationY = (float)Math.sin((double)Rotation.y);
		float rotationZ = (float)Math.cos((double)Rotation.z);
		
		Position.x = Position.x + rotationX * speed;
		Position.y = Position.y + rotationY * speed;
		Position.z = Position.z + rotationZ * speed;
	}
	
	public void moveTowardsRotation(float speed, boolean moveX, boolean moveY, boolean moveZ) {
		float rotationX = (float)Math.cos((double)Rotation.x);
		float rotationY = (float)Math.sin((double)Rotation.y);
		float rotationZ = (float)Math.cos((double)Rotation.z);
		
		if(moveX)
			Position.x = Position.x + rotationX * speed;
		if(moveY)
			Position.y = Position.y + rotationY * speed;
		if(moveZ)
			Position.z = Position.z + rotationZ * speed;
	}
	
	//rotate towards
	/*
	 * Accepts Two different arguments
	 * a SENumber3 or a SEVector
	 * This will be useful later so that we can simply rotate an object towards another easily. 
	 */
	public void rotateTowards(SENumber3 position) {
		//We need the three rotations: (y2 - y1 / z2 - z1), (z2 - z1 / x2 - x1), (y2 - y1, x2 - x1)
		float rotationX = (float)Math.atan2(position.y - this.Position.y, position.z - this.Position.z);
		float rotationY = (float)Math.atan2(position.z - this.Position.z, position.x - this.Position.x);
		float rotationZ = (float)Math.atan2(position.y - this.Position.y, position.x - this.Position.x);
		
		Rotation.set(rotationX, rotationY, rotationZ);
	}
	
	public void rotateTowards(SEVector position) {
		//We need the three rotations: (y2 - y1 / z2 - z1), (z2 - z1 / x2 - x1), (y2 - y1, x2 - x1)
		float rotationX = (float)Math.atan2(position.Position.y - this.Position.y, position.Position.z - this.Position.z);
		float rotationY = (float)Math.atan2(position.Position.z - this.Position.z, position.Position.x - this.Position.x);
		float rotationZ = (float)Math.atan2(position.Position.y - this.Position.y, position.Position.x - this.Position.x);
				
		Rotation.set(rotationX, rotationY, rotationZ);
	}
}
