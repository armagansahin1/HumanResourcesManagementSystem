package kodlamaio.hrms.entities.dtos;

import java.util.Date;
import java.util.List;

import kodlamaio.hrms.entities.concretes.Education;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDetailsDto {
	private int candidateId;
	private String firstName;
	private String lastName;
	private String profession;
	private String email;
	private Date dateOfBirth; 
	
}
