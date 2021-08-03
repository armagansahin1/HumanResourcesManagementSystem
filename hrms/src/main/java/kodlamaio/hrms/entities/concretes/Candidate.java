package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="Candidates")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educations","businessExperiences","photos","languageOfCandidates","socialAccountOfCandidates"})
public class Candidate extends User{
	

	
	@Column(name="profession")
	private String profession;
	
	
	@OneToMany(mappedBy="candidate")
	private List<Education> educations;
	
	@OneToMany(mappedBy="candidate")
	private List<BusinessExperience> businessExperiences;
	
	@OneToMany(mappedBy="candidate")
	private List<Photo> photos;
	
	@OneToMany(mappedBy="candidate")
	private List<LanguageOfCandidate> languageOfCandidates;
	
	@OneToMany(mappedBy="candidate")
	private List<SocialAccountOfCandidate> socialAccountOfCandidates;
	
}
