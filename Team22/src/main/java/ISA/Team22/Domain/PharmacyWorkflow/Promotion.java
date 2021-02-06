package ISA.Team22.Domain.PharmacyWorkflow;

public class Promotion {

	private Period period;
	private String description;
	
	public Promotion() {
		super();
	}

	public Promotion(Period period, String description) {
		super();
		this.period = period;
		this.description = description;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
