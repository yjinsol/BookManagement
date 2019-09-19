package kr.co.mlec.service;

public class UserServiceFactory {
	private static UserService service = null;
	
	public static UserService getInstance() {
		if(service == null)
			service = new UserService();
		return service;
	}
}
