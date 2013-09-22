package scene;

import main.SENumber3;
import main.SEVector;
import rajawali.lights.SpotLight;

public class SELightSpot extends SpotLight
{
	SEVector Position;
	SENumber3 Target;
	
	public SELightSpot()
	{
		Target = new SENumber3(0, 0, 0);
		Position = new SEVector();
	}
	
	
	//Update the attributes:
	public void updateAttributes()
	{
		
	}
}
