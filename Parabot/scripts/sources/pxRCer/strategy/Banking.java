package strategy;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Bank;
import org.rev317.api.methods.Inventory;
import org.rev317.api.methods.Players;
import org.rev317.api.methods.SceneObjects;
import org.rev317.api.wrappers.scene.SceneObject;

public class Banking implements Strategy {

	public final int BANK_ID = 953;

	final SceneObject[] banks = SceneObjects.getNearest(BANK_ID);
	final SceneObject bankbooth = banks[0];

	@Override
	public boolean activate() {
		if (bankbooth != null) {
			if (bankbooth.isOnScreen() || Bank.isOpen()
					&& Inventory.getCount(565) == 1
					&& !Players.getLocal().isWalking()
					&& !Players.getLocal().isInCombat()) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute() {
		
		if (bankbooth != null) {
			
			bankbooth.interact("Use-quickly");
			Time.sleep(750);
			
			if (Bank.isOpen()) {
				Bank.depositAll();
				Time.sleep(250);
				
				if(Inventory.isEmpty()){
				Bank.withdraw(1436,28);
				Time.sleep(250);
				}
				if(Inventory.isFull()){
				Bank.close();
				Time.sleep(250);
				}
			else {
				bankbooth.interact("Use-quickly");
				Time.sleep(750);
			}
		}
	}
}
}
