package ISA.Team22.Domain.PharmacyWorkflow;

public class LoyaltyProgram {
	
	private int points;
	private UserCategory category;
	
	public LoyaltyProgram() {
		super();
	}

	public LoyaltyProgram(int points, UserCategory category) {
		super();
		this.points = points;
		this.category = category;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public UserCategory getCategory() {
		return category;
	}

	public void setCategory(UserCategory category) {
		this.category = category;
	}
	
	
}
