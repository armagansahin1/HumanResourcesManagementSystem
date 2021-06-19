package kodlamaio.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Users")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employers","candidates","systemPersonels"})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@NotNull
	@NotBlank
	@Column(name="FirstName")
	private String firstName;
	
	@NotNull
	@NotBlank
	@Column(name="LastName")
	private String lastName;
	
	@NotNull
	@NotBlank
	@Column(name="NationalityId")
	private String nationalityId;
	
	@Column(name="dateOfBirth")
	private Date dateOfBirth;
	
	@Email
	@Column(name="Email")
	private String email;
	
	@NotNull
	@NotBlank
	@Column(name="Password")
	private String password;
	
	@Column(name="EmailVerify")
	private boolean emailVerify;
	
	@OneToOne(mappedBy = "user")
	private Employer employers;
	
	@OneToOne(mappedBy = "user")
	private Candidate candidates;
	
	@OneToOne(mappedBy = "user")
	private SystemPersonel systemPersonels;
	
}
