package king.arthur.assess;

import sir.gawain.figure.Gawain;
import sir.lancelot.figure.Lancelot;
import sir.perceval.figure.Perceval;
import sir.perceval.strategy.HttpPike;
import sir.perceval.strategy.Pike;
import king.arthur.figure.KingArthur;
import king.arthur.figure.KingRole;
import king.arthur.model.Crown;

public class TotalAssessment {

	public static void main(String[] args) throws Exception {
		
		final Crown crown = Crown.of();
		final KingArthur king = KingArthur.of(crown);
		final Lancelot lancelot = Lancelot.of();
		final Gawain gawain = Gawain.of();
		final Perceval perceval = Perceval.of();
		
		final Pike httpPike = HttpPike.of();
		
		gawain.becomeServant(king);
		lancelot.becomeServant(king);
		perceval.becomeServant(king);
		
		System.out.println(king.name() + ", health: " + king.health());
		System.out.println(lancelot.name() + ", health: " + lancelot.health());
		System.out.println(gawain.name() + ", health: " + gawain.health());
		System.out.println(perceval.name() + ", health: " + perceval.health());
		System.out.println("isKing: " + (king.role() instanceof KingRole));
		System.out.println("isKing: " + (gawain.role() instanceof KingRole));
		
		perceval.arm(httpPike);
		
		System.out.println("King is crusading...");
		king.crusade();
		
		System.out.println("About to quit...");
		System.exit(0);
	}

}
