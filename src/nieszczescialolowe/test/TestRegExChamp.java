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
		assertEquals(
				new StringBuilder()
					.append("Average KDACss - 10/6/15/295\n")
					.append("Most played lane - Mid\n")
					.append("Most played lane % - 100.0\n")
					.append("Win ratio % - 81.82\n")
					.append("Average game time - 0:46:29\n")
					.append("Most often grade - S\n")
					.append("Most often grade % - 54.55\n")
					.append("Average afk's - 0.0\n")
					.toString(),
				Tests.runCommand("average stats champ Fizz"));
	}
	
	@Test
	public void averageStatsChampX() {
		assertEquals(
				new StringBuilder()
					.append("Average KDACss - 6/6/9/190\n")
					.append("Most played lane - Top\n")
					.append("Most played lane % - 66.67\n")
					.append("Win ratio % - 66.67\n")
					.append("Average game time - 0:37:05\n")
					.append("Most often grade - A\n")
					.append("Most often grade % - 33.33\n")
					.append("Average afk's - 2.0\n")
					.toString(),
				Tests.runCommand("average stats champ Pantheon 3"));
	}
}
