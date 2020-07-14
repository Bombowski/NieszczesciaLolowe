package nieszczescialolowe.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRegExChamp {

	@Test
	public void mostPlayedChamp() {
		assertEquals("Most played champion: Fizz ; with a percentage of 57.89%",
				Tests.runCommand("most played champ"));
	}

	@Test
	public void mostPlayedChampX() {
		assertEquals("Most played champion: Fizz ; with a percentage of 50.0%",
				Tests.runCommand("most played champ 6"));
	}
	
	@Test
	public void averageStatsChamp() {
		fail("Not yet implemented");
	}
	
	@Test
	public void averageStatsChampX() {
		fail("Not yet implemented");
	}
}
