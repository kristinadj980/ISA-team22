package ISA.Team22.Domain.PharmacyWorkflow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoyaltyProgram {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "points",  nullable = false)
	private Integer points;
	
	private UserCategory category;
	
	public LoyaltyProgram() {
		super();
	}

	public LoyaltyProgram(Long id, Integer points, UserCategory category) {
		super();
		this.id = id;
		this.points = points;
		this.category = category;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public UserCategory getCategory() {
		return category;
	}

	public void setCategory(UserCategory category) {
		this.category = category;
	}
	
	
}
