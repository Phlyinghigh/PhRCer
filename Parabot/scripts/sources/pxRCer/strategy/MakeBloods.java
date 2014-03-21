package strategy;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Inventory;
import org.rev317.api.methods.Players;
import org.rev317.api.methods.SceneObjects;
import org.rev317.api.wrappers.scene.SceneObject;



public class MakeBloods implements Strategy {
	public int essUsed= 0;

    @Override
    public boolean activate() {
    	
        for (SceneObject i : SceneObjects.getNearest(2490)) {
            if (i.isOnScreen()
                    && !Players.getLocal().isWalking()
                    && !Players.getLocal().isInCombat()
                    && Players.getLocal().getAnimation() == -1
                    && Inventory.getCount(1436)==28) {
                return true;
            }
        }
       return false;
    }

    @Override
    public void execute() {
    	
        for (SceneObject i : SceneObjects.getNearest(2490)) {
        	if(i.isOnScreen()){
            i.interact("Search");
            essUsed = essUsed+28;
            Time.sleep(200);
        	}
        	
            
        }
        
    }
}
    