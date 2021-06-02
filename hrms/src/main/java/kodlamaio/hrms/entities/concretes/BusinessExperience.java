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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="BusinessExperience")
public class BusinessExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="workplaceName")
	private String workplaceName;
	
	@Column(name="position")
	private String position;
	
	@Column(name="enterDate")
	private Date enterDate;
	
	@Column(name="outDate")
	private Date outDate;
	
	@ManyToOne()
	@JoinColumn(name="candidateId")
	private Candidate candidate;
}
