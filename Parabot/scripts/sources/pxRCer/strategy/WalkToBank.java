package strategy;

import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Inventory;
import org.rev317.api.methods.Players;
import org.rev317.api.methods.SceneObjects;
import org.rev317.api.wrappers.scene.SceneObject;
import org.rev317.api.wrappers.scene.Tile;
import org.rev317.api.wrappers.walking.TilePath;


public class WalkToBank implements Strategy {
	public final int bankID = 2213;
	final SceneObject[] Banks = SceneObjects.getNearest(bankID);
    final SceneObject bankBooth = Banks[0];
	@Override
	public boolean activate() {
		if(bankBooth.distanceTo()<20
				&& Inventory.getCount(565)==1)//Has blood runes in inventory
			{
			return true;
		}
		return false;
	}

	@Override
	public void execute() {
		if(!bankBooth.isOnScreen()){
			Tile bankTile = bankBooth.getLocation();
			Tile playerTile = Players.getLocal().getLocation();
			Tile[] toBank = { playerTile, bankTile };
			TilePath bankPath = new TilePath(toBank);
			bankPath.traverse();
		}
		
	}

}
