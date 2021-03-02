package ISA.Team22.Domain.Users;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "streetName",  nullable = false)
	private String streetName;
	
	@Column(name = "streetNumber",  nullable = false)
	private String streetNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
	private City city;
	
	public Address() {
		super();
	}
	
	public Address(Long id, String streetName, String streetNumber, City city) {
		super();
		this.id = id;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.city = city;
	}
	
	public Address(String streetName, String streetNumber, City city) {
		super();
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.city = city;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
}
