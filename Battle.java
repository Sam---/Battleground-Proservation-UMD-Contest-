import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class SingleBattle {
    String combatant1;
    String combatant2;
    int costOfVictory;

    SingleBattle(String combatant1, String combatant2, int costOfVictory) {
        this.combatant1 = combatant1;
        this.combatant2 = combatant2;
        this.costOfVictory = costOfVictory;
    }
}

class StringAndCost

public class Battle {
	private static List<List<String>> findBattleChains(List<List<String>> chains, SingleBattle battle) {
		List<List<String>> found = new LinkedList<List<String>>();
		for (List<String> chain : chains) {
			if (chain.get(0) == battle.combatant2 || chain.get(chain.size() - 1) == battle.combatant2) {
				found.add(chain);
			}
		}
		return found;
	}

    private static int solveBattle(int numCombatants, ArrayList<SingleBattle> pastBattles, String combatant1, String combatant2) {
    	final int FIGHT = 0, C1WINS = 1, C2WINS = 2;
    	int prevMin = 0, prevMax = 0;
    	List<List<String>> chains = new LinkedList<List<String>>();
    	
    	for (SingleBattle battle : pastBattles) {
    		List<List<String>> foundChains = findBattleChains(chains, battle);
    		if (foundChains == null) {
    			List<String> newChain = new LinkedList<String>();
    			newChain.add(battle.combatant1);
    			newChain.add(battle.combatant2);
    			chains.add(newChain);
    		} else for (List<String> chain : foundChains) {
    			if (chain.get(0) == battle.combatant2) {
    				chain.add(0, battle.combatant1);
    			} else {
    				chain.add(battle.combatant2);
    			}
    		}
    	}
    	
    	for (List<String> chain : chains) {
    		int id1 = chain.indexOf(combatant1);
    		int id2 = chain.indexOf(combatant2);
    		if (id1 > 0 && id2 > 0) {
    			int diff = id2 - id1;
    			int totalCost = 0;
    			for (String : chain)
    			if (diff < 0) {
    				
    			}
    			prevMin = Math.min(prevMin, diff);
    			prevMax = Math.max(prevMax, diff);
    		}
    	}
    	
    	if (prevMin < 0 && prevMax > 0) {
    		return FIGHT;
    	} else if (prevMin < 0) {
    		return C2WINS;
    	} else if (prevMax > 0) {
    		return C1WINS;
    	} else {
    		return FIGHT;
    	}
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCases = sc.nextInt();

        for(int ii = 0; ii < numCases; ii++) {

            int numCombatants = sc.nextInt();

            int numOfBattles = sc.nextInt();

            ArrayList<SingleBattle> pastBattles = new ArrayList<SingleBattle>();

            for (int i=0; i<numOfBattles; i++)
                pastBattles.add(new SingleBattle(sc.next(), sc.next(), sc.nextInt()));

            /* Read the new battle participants, and call subroutine. */
            String combatant1 = sc.next();
            String combatant2 = sc.next();
            int ret = solveBattle(numCombatants, pastBattles, combatant1, combatant2);

            if (ret == 0) 
                System.out.println("FIGHT!");
            else {
                if (ret == 1)
                    System.out.println(combatant1);
                else
                    System.out.println(combatant2);
            }
        }
    }
}
