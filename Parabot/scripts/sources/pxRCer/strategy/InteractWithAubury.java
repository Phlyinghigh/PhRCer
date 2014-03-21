package strategy;

import java.awt.Point;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Inventory;
import org.rev317.api.methods.Menu;
import org.rev317.api.methods.Npcs;
import org.rev317.api.wrappers.interactive.Npc;


public class InteractWithAubury implements Strategy {
	
	private final Npc[] runecraftNpc = Npcs.getNearest(553);
	private Npc aubury = runecraftNpc[0];
	@Override
	public boolean activate() {
		if(aubury.isOnScreen()
				&& Inventory.getCount(1436)==28
				&& !Menu.isOpen()){
			return true;
		}
		return false;
	}

	@Override
	public void execute() {
		
		aubury.interact("Teleport");
		Time.sleep(200,500);
		
		if(!Menu.isOpen()){
			Time.sleep(500,1000);
		}
		while(Menu.isOpen()){
		int bloodIndex = Menu.getActionIndex("Blood");
		int nextIndex = Menu.getActionIndex("Next");
		
		if(nextIndex>0){
			Point nextPoint = Menu.getPointFromIndex(nextIndex);
			Menu.interact("Next", nextPoint);
			Time.sleep(200,500);
		}
		else if(bloodIndex>0){
			Point bloodPoint = Menu.getPointFromIndex(bloodIndex);
			Menu.interact("Blood", bloodPoint);
			Time.sleep(200,500);
		}
		
		}
		
		// TODO Auto-generated method stub
		
	}

}