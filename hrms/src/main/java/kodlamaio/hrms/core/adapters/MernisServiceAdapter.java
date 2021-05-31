package kodlamaio.hrms.core.adapters;

import java.rmi.RemoteException;
import java.util.Locale;

import kodlamaio.hrms.entities.concretes.User;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements IdentityVerificatonBase{

public boolean verify(User user) {
		
		KPSPublicSoapProxy service=new KPSPublicSoapProxy();
		try {
		return	service.TCKimlikNoDogrula(Long.parseLong(user.getNationalityId()), user.getFirstName().toUpperCase(new Locale("tr")), 
				user.getLastName().toUpperCase(new Locale("tr")), user.getBirthOfDate().getYear());
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		return false;
	}
}
