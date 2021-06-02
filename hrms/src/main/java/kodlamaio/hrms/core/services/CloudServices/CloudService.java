package kodlamaio.hrms.core.services.CloudServices;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface CloudService {
	Map upload(MultipartFile multipartFile) throws IOException;
}
