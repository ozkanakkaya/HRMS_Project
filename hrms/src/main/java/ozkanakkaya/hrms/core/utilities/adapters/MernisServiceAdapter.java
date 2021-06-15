package ozkanakkaya.hrms.core.utilities.adapters;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import ozkanakkaya.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements MernisCheckService {

	@Override
	public boolean checkIfRealPerson(JobSeeker jobSeeker) {

//		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
//		boolean result = false;
//		try {
//
//			result = client.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getNationalityId()),
//					jobSeeker.getFirstName().toUpperCase(), jobSeeker.getLastName().toUpperCase(),
//					jobSeeker.getDateOfBirth().getYear());
//
//		} catch (Exception e) {
////			e.printStackTrace();
//			System.out.println("Not a valid person");
//		}

		return true;
	}

}
