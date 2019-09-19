package kr.co.mlec.service;

public class RentServiceFactory {
	private static RentService service = null;
	
	public static RentService getInstance() {
		if(service == null)
			service = new RentService();
		return service;
	}
}
