package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Candidate")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educations","businessExperiences","photos","languageOfCandidates"})
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	
	@ManyToOne()
	@JoinColumn(name="userId")
	private User user;
	
	@OneToMany(mappedBy="candidate")
	private List<Education> educations;
	
	@OneToMany(mappedBy="candidate")
	private List<BusinessExperience> businessExperiences;
	
	@OneToMany(mappedBy="candidate")
	private List<Photo> photos;
	
	@OneToMany(mappedBy="languageOfCandidates")
	private List<LanguageOfCandidate> languageOfCandidates;
	
}
