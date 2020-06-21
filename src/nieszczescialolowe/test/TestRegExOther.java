package nieszczescialolowe.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import nieszczescialolowe.model.Log;

public class TestRegExOther {

	@BeforeClass
	public static void init() {
		
	}
	
	@Test
	public void test() {
		Tests.runCommand("help","");
		
		StringBuilder sb = new StringBuilder()
				.append("average champ X - Shows the average statistics of x champion")
				.append("average game - Shows the average statistics from all games") 
				.append("average game X - Shows the average statistics from last X ga") 
				.append("mes")
				.append("average lane X - shows average stats from x lane")
				.append("average lane X Y - shows average stats in x lane from last y") 
				.append(" games")
				.append("clear - Clears the console") 
				.append("help - Lists all commands") 
				.append("list last X - Shows X last games") 
				.append("most played champ - Shows the most played champ in any lane") 
				.append("most played champ x - Shows the most played champ in the las") 
				.append("t x games")
				.append("most played lane - shows the most played lane from all games")
				.append("most played lane X - shows the most played lane from last x ") 
				.append("games");
		
		assertEquals(sb.toString(), Log.getLog());
	}

}
