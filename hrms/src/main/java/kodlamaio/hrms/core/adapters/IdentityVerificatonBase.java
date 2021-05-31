package kodlamaio.hrms.core.adapters;

import kodlamaio.hrms.entities.concretes.User;

public interface IdentityVerificatonBase {

	boolean verify(User user);
}
