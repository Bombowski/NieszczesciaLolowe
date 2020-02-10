package nieszczescialolowe.model.pojo;

import java.util.regex.Pattern;

public class Command {

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
}
