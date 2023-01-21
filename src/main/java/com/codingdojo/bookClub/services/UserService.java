package com.codingdojo.bookClub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.bookClub.models.LoginUser;
import com.codingdojo.bookClub.models.User;
import com.codingdojo.bookClub.repositories.UserRepository;
    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        // TO-DO: Additional validations!
    	
    	// Reject if password doesn't match confirmation
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
    	// Reject if email is taken (present in database)
    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
    	if(potentialUser.isPresent()) {
    		result.rejectValue("email", "already exists", "email already in use");
    	}
    	
    	// Return null if result has errors
    	if(!result.hasErrors()) {
    		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    		newUser.setPassword(hashed);
    		return this.create(newUser);
    	}
    	
        return null;
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO: Additional validations!
    	Optional<User> user = userRepo.findByEmail(newLoginObject.getEmail());
    	if(user.isEmpty()) {
    		result.rejectValue("password", "Matches", "Login Failed");
    		return null;
    	}
    	if(!BCrypt.checkpw(newLoginObject.getPassword(), user.get().getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	    return null;
    	}
    	else {
    		return user.get();    	}
    	
    }
    public User create(User u) {
    	return userRepo.save(u);
    }
    
    public User getOnebyId(Long id) {
    	Optional<User> potentialUser = userRepo.findById(id);
    	if(potentialUser.isEmpty()) {
    		return null;
    	}
    	return potentialUser.get();
    }
}
