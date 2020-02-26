package nieszczescialolowe.model.pojo;

import java.util.regex.Pattern;

/**
 * @author Patryk
 *
 * Class command ktora zapisuje opis komendy, i jej pattern
 */
public class Command implements Comparable<Command> {

	private String description;
	private Pattern pattern;
	
	public Command(String description, String pattern) {
		this.description = description;
		this.pattern = Pattern.compile(pattern);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Pattern getPattern() {
		return pattern;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	@Override
	public int compareTo(Command o) {
		String description = o.getDescription();
		for (int i = 0; i < description.length(); i++) {
			int newChar = description.charAt(i);
			int thisChar = this.description.charAt(i);
			
			if (newChar > thisChar) {
				return -1;
			} else if (newChar < thisChar) {
				return 1;
			}
		}
		
		return 0;
	}
}
