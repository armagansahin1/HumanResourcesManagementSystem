package kodlamaio.hrms.api;

import java.util.List;

import org.apache.axis.AxisFault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;

@RestController
@RequestMapping(name="api/users")
public class UsersControllers {
	private UserService userService;

	@Autowired
	public UsersControllers(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/add")
	Result add(@RequestBody User user){
		
		return userService.add(user);
	}
	
	@GetMapping("/getall")
	DataResult<List<User>> getAll() {
		
		return userService.getAll();
	}
	
	
}
