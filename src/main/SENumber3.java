/**
 * 
 */
package main;

/**
 * @author Kevin
 *
 */
public class SENumber3 {
	
	public float x;
	public float y;
	public float z;
	
	public SENumber3(int intX, int intY, int intZ) {
		x = intX;
		y = intY;
		z = intZ;
	}
	
	/*
	 * Simply sets the x, y, z values of the Number3
	 * 
	 * We might want to add methods for individual values
	 */
	public void set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
