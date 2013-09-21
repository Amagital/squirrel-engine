package main;

import main.SENumber3;

public class SEVector {

	public SENumber3 Position;
	public SENumber3 Rotation;
	public SENumber3 Velocity;
	
	public SEVector() {
		// TODO Auto-generated constructor stub
		Position = new SENumber3(0, 0, 0);
		Rotation = new SENumber3(0, 0, 0);
		Velocity = new SENumber3(0, 0, 0);
	}
	
	//Applies the Velocity to the positions
	public void applyVelocity() {
		Position.set(Position.x + Velocity.x, Position.y + Velocity.y, Position.z + Velocity.z);
	}
	
	//moves towards the rotation
	public void moveTowardsRotation(float speed) {
		float rotationX = (float)Math.cos((double)Rotation.x);
		float rotationY = (float)Math.sin((double)Rotation.y);
		float rotationZ = (float)Math.cos((double)Rotation.z);
		
		Position.x = Position.x + rotationX * speed;
		Position.y = Position.y + rotationY * speed;
		Position.z = Position.z + rotationZ * speed;
	}
	
	public void moveTowardsRotation(float speed, boolean x, boolean y, boolean z) {
		float rotationX = (float)Math.cos((double)Rotation.x);
		float rotationY = (float)Math.sin((double)Rotation.y);
		float rotationZ = (float)Math.cos((double)Rotation.z);
		
		if(x)
			Position.x = Position.x + rotationX * speed;
		if(y)
			Position.y = Position.y + rotationY * speed;
		if(z)
			Position.z = Position.z + rotationZ * speed;
	}
	
	//rotate towards:
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
