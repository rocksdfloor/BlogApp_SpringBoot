package services;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import models.UserDto;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> { 
    
	protected Log logger = LogFactory.getLog(this.getClass());
	
   @Override
   public void initialize(PasswordMatches constraintAnnotation) {       
   }
   @Override
   public boolean isValid(Object obj, ConstraintValidatorContext context){   
       UserDto user = (UserDto) obj;
       logger.debug("Object : " + obj.toString()); 
       System.out.println("Object : " + obj.toString()); 
       return user.getPassword().equals(user.getMatchingPassword());    
   }     
}
