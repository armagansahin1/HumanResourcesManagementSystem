package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@Table(name="JobAdvertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@NotBlank
	@Column(name="description")
	private String description;
	
	@Column(name="minSalary")
	private double minSalary;
	
	@Column(name="maxSalary")
	private double maxSalary;
	
	@Column(name="relaseDate")
	private Date relaseDate;
	
	@Column(name="lastDate")
	private Date lastDate;
	
	@NotNull
	@NotBlank
	@Column(name="numberOfPosition")
	private int numberOfPosition;
	
	@Column(name="advertismentStatus")
	private boolean advertismentStatus;
	
	@NotNull
	@NotBlank
	@ManyToOne
	@JoinColumn(name="cityId")
	private City city;
	
	@ManyToOne
	@JoinColumn(name="employerId")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name="professionId")
	private Profession profession;
}
