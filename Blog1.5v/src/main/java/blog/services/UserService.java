//package services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import models.User;
//import models.UserDto;
//
//public class UserService implements IUserService {
//	 
//	@Override
//	public User registerNewUserAccount(UserDto accountDto) throws Exception {
//		 
//		User user = new User();    
//        user.setFullName(accountDto.getFirstName() + " " + accountDto.getLastName()); 
//        user.setPasswordHash(accountDto.getPassword()); 
//        user.setRole("ROLE_USER");
//        return repository.save(user);   
//	}
//
//}
