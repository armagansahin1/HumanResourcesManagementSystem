package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educations","businessExperiences","photos","languageOfCandidates","socialAccountOfCandidates"})
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="profession")
	private String profession;
	
	@OneToOne()
	@JoinColumn(name="userId")
	private User user;
	
	@OneToMany(mappedBy="candidate",fetch = FetchType.LAZY)
	private List<Education> educations;
	
	@OneToMany(mappedBy="candidate",fetch = FetchType.LAZY)
	private List<BusinessExperience> businessExperiences;
	
	@OneToMany(mappedBy="candidate",fetch = FetchType.LAZY)
	private List<Photo> photos;
	
	@OneToMany(mappedBy="candidate",fetch = FetchType.LAZY)
	private List<LanguageOfCandidate> languageOfCandidates;
	
	@OneToMany(mappedBy="candidate",fetch = FetchType.LAZY)
	private List<LanguageOfCandidate> socialAccountOfCandidates;
	
}
