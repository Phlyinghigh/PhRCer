package strategy;

import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Inventory;
import org.rev317.api.methods.Npcs;
import org.rev317.api.methods.Players;
import org.rev317.api.wrappers.interactive.Npc;
import org.rev317.api.wrappers.scene.Tile;
import org.rev317.api.wrappers.walking.TilePath;



public class WalkToAubury implements Strategy {
	private final Npc[] runecraftNpc = Npcs.getNearest(553);
	private Npc aubury = runecraftNpc[0];
	private Tile auburyTile = aubury.getLocation();
	@Override
	public boolean activate() {
		if(Inventory.getCount(1436)==28
			&& auburyTile.distanceTo()<20
			&& Players.getLocal().getAnimation() == -1
			&&!auburyTile.isOnScreen()){
			return true;
		}
		return false;
	}

	@Override
	public void execute() {
		
		
		if(auburyTile.isOnMinimap()){
			auburyTile.clickMM();
		}else{
			Tile playerTile = Players.getLocal().getLocation();
			Tile[] toAubury = { playerTile, auburyTile };
			TilePath auburyPath = new TilePath(toAubury);
			auburyPath.traverse();
			 
		}
		
		
		// TODO Auto-generated method stub
		
	}

}
