package kodlamaio.hrms.entities.concretes;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidates","systemPersonels"})
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@NotNull
	@NotBlank
	@Column(name="firstName")
	private String firstName;
	
	@NotNull
	@NotBlank
	@Column(name="lastName")
	private String lastName;
	
	@NotNull
	@NotBlank
	@Column(name="nationalityId")
	private String nationalityId;
	
	@Column(name="dateOfBirth")
	private Date dateOfBirth;
	
	@Email
	@Column(name="email")
	private String email;
	
	@NotNull
	@NotBlank
	@Column(name="Password")
	private String password;
	
	@Column(name="EmailVerify")
	private boolean emailVerify;
	

	
	@OneToOne(mappedBy = "user")
	private SystemPersonel systemPersonels;
	
}
