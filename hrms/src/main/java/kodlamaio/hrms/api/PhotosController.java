package kodlamaio.hrms.api;



import java.io.IOException;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.core.services.CloudServices.CloudService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Photo;

@RestController
@RequestMapping("/api/photos")
@CrossOrigin
public class PhotosController {
	private PhotoService photoService;
	private CloudService cloudService;
	
	@Autowired
	public PhotosController(PhotoService photoService,CloudService cloudService) {
		this.photoService = photoService;
		this.cloudService =cloudService;
	}
	
	@PostMapping("/upload")
	public Result upload(@RequestParam MultipartFile multipartFile, int candidateId) throws IOException{
		if(!multipartFile.isEmpty()) {
			var uploadResult = this.cloudService.upload(multipartFile);
			Photo photo = new Photo(0,uploadResult.get("url").toString(),
					uploadResult.get("public_id").toString(),new Date(),new Candidate(candidateId,null,null,null,null,null,null,null));
			return this.photoService.add(photo);
		}
		return new ErrorResult("Resim seçmediniz");
		
		
	}
	@GetMapping("/getByCandidateId")
	public DataResult<Photo> getByCandidateId(@RequestParam int candidateId){
		return this.photoService.getByCandidateId(candidateId);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Photo>> getAll(){
		return this.photoService.getAll();
	}

}
