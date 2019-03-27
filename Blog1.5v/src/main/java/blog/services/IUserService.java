package services;

import models.User;
import models.UserDto;

public interface IUserService {
	User registerNewUserAccount(UserDto accountDto)     
		      throws Exception;
}
