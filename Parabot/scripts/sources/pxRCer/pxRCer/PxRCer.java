package pxRCer;


import java.util.ArrayList;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import strategy.*;


/**
 * Made by: Phlying High
 */

@ScriptManifest(author = "Phlying High", category = Category.RUNECRAFTING, description = "Runecraft", name = "PXrunecrafter", servers = { "UltimateScape" }, version = 1)
public class PxRCer extends Script{
	public final int bankID = 2213;
    public final int altarID = 2480;
   

	 
	private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();
    @Override
    public boolean onExecute() {
    
     	strategies.add(new MakeBloods());
     	strategies.add(new WalkToAubury());
     	strategies.add(new InteractWithAubury());
     	strategies.add(new TeleportHome());
     	strategies.add(new WalkToBank());
     	strategies.add(new Banking());
     	
        provide(strategies);
        return true;
    }

    @Override
    public void onFinish() {

    }
}