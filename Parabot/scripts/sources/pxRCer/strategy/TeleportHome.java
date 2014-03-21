package strategy;

import java.awt.Point;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Mouse;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Inventory;
import org.rev317.api.methods.SceneObjects;
import org.rev317.api.wrappers.hud.Tab;
import org.rev317.api.wrappers.scene.SceneObject;


public class TeleportHome implements Strategy {

	@Override
	public boolean activate() {
		        for (SceneObject i : SceneObjects.getNearest(2490)) {
		            if (i.isOnScreen() //Next to Alter
		                && Inventory.getCount(565)==1)//Has blood runes in inventory
		            	{
		                return true;
		            }
		        }
		       return false;
		    }

	@Override
	public void execute() {
		hometele();
		
		
	}
	
	 public void hometele(){

	        Tab.open("MAGIC");
	        Point HOME_TELE = new Point (577, 267);
	        Time.sleep(400);
	        Mouse.getInstance().click(HOME_TELE);
	    }

}
