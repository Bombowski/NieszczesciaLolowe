package nieszczescialolowe.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestRegExOther {

	@BeforeClass
	public static void init() {

	}

	@Test
	public void test() {

		assertEquals(
				new StringBuilder()
					.append("average champ X - Shows the average statistics of x champion\n\n")
					.append("average game - Shows the average statistics from all games\n")
					.append("average game X - Shows the average statistics from last X ga\n")
					.append("mes\n")
					.append("average lane X - shows average stats from x lane\n")
					.append("average lane X Y - shows average stats in x lane from last y\n")
					.append(" games\nclear - Clears the console\nhelp - Lists all commands\n")
					.append("list last X - Shows X last games\n")
					.append("most played champ - Shows the most played champ in any lane\n")
					.append("most played champ x - Shows the most played champ in the las\n")
					.append("t x games\n")
					.append("most played lane - shows the most played lane from all games\n\n")
					.append("most played lane X - shows the most played lane from last x \n")
					.append("games")
					.toString(), 
				Tests.runCommand("help"));
	}

	@Test
	public void clear() {
		assertEquals("", Tests.runCommand("clear"));
	}

	@Test
	public void listLastX() {
		assertEquals(
				new StringBuilder()
					.append("[kda/css: 5/6/6/253 ; champion: Maokai ; lane: Top ; time: 0\n     ")
					.append(":33:05 ; win/lose: L ; afks: 2 ; grade: B]\n")
					.append("     [kda/css: 8/5/8/363 ; champion: Maokai ; lane: Top ; time: 0\n     ")
					.append(":41:05 ; win/lose: L ; afks: 1 ; grade: C]\n")
					.append("     [kda/css: 9/3/5/294 ; champion: Fizz ; lane: Mid ; time: 0:3\n     ")
					.append("7:05 ; win/lose: W ; afks: 0 ; grade: S]\n")
					.append("     [kda/css: 14/4/7/256 ; champion: Fizz ; lane: Mid ; time: 0:\n     ")
					.append("52:55 ; win/lose: W ; afks: 0 ; grade: S]\n")
					.append("     [kda/css: 11/4/13/463 ; champion: Fizz ; lane: Mid ; time: 1\n     ")
					.append(":01:05 ; win/lose: W ; afks: 0 ; grade: S]")
					.toString(), 
				Tests.runCommand("list last 5"));
	}

	@Test
	public void averageStatsX() {
		assertEquals(
				new StringBuilder()
					.append("Average KDACss - 8/6/12/260\n     Most played champion - Fizz\n     Most played champion pickrate - 57.89\n     ")
					.append("Most played lane - Mid\n     Most played lane % - 63.16\n     Win ratio - 63.16\n     Average game time - 0:41:25\n     ")
					.append("Most often grade - S\n     Most often grade % - 31.58\n     Average afk's - 0.63").toString(),
				Tests.runCommand("average game 20"));
	}

	@Test
	public void averageStats() {

	}
}
