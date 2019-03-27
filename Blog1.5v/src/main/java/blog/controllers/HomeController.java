package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import models.Post;
import models.User;
import models.UserDto;
import services.PostService;

@Controller 
public class HomeController { 


	protected Log logger = LogFactory.getLog(this.getClass());

	List<Post> allPost=new ArrayList<Post>();

	@Autowired 
	private PostService postService;

	private long idCounter=1;

	@GetMapping("/")
	public ModelAndView passParametersWithModelAndView() {
		ModelAndView modelAndView = new ModelAndView("index"); ; 
		modelAndView.addObject("allPost", allPost);
		System.out.println("In passParametersWithModelAndView()");
		return modelAndView;

	} 

	@GetMapping("/{id}")
	public ModelAndView deleteUser(@PathVariable("id") long id,Model model,HttpServletResponse response) { 
		try {
			String idPost=String.valueOf(id);
			Post p = allPost.stream()
					.filter(post -> idPost.equals(String.valueOf(post.getId())))
					.findAny()
					.orElse(null);
			allPost.remove(p);
			ModelAndView modelAndView = new ModelAndView("index");  
			modelAndView.addObject("allPost", allPost); 
			return modelAndView;
		}
		catch (Exception exc) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Info Not Found", exc);
		}
	}
	
	@PostMapping("/")
	public String postRegistration(@ModelAttribute User user) {
		System.out.println(user);
		return "result";
	}

	@GetMapping("/post")
	public String postCreate(Model model) {
		model.addAttribute("post", new Post());
		return "post";
	}

	@PostMapping("/post")
	public String postSubmit(@ModelAttribute Post post) {
		post.setId(idCounter++);
		allPost.add(post);
		logger.debug("\nPost details --------> " + post); 
		return "result";
	}

	@GetMapping("/updatePost/{id}")
	public String updateUser(@PathVariable("id") long id,Model model) {
		String idPost=String.valueOf(id);
		Post p = allPost.stream()
				.filter(post -> idPost.equals(String.valueOf(post.getId())))
				.findAny()
				.orElse(null);
		model.addAttribute("post", p); 
		allPost.remove(p);
		return "updatePost";         
	}

	@PostMapping("/updatePost")
	public String postSubmitAfterEdit(@ModelAttribute Post post) { 
		allPost.add(post);  
		return "result";
	}


	@GetMapping(value = "/login")
	public ModelAndView login(Model model, String error, String logout) {
		ModelAndView modelAndView = new ModelAndView("login");
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		logger.debug(model);
		return modelAndView;
	}


	@GetMapping(value = "/registration")
	public String showRegistrationForm(WebRequest request, Model model) {
		UserDto userDto = new UserDto();
		model.addAttribute("user", userDto);
		return "registration";
	}

	@PostMapping(value = "/registration")
	public ModelAndView registerUserAccount(
			@ModelAttribute("user") @Valid UserDto accountDto, 
			BindingResult result, 
			WebRequest request, 
			Errors errors) {
		logger.debug("Registration Post registerUserAccount() method " );
//		System.out.println(result);
		if (result.hasErrors()) {
			ModelAndView mv=new ModelAndView("registration", "user", accountDto); 
			return mv;
		} 
		else {
			ModelAndView mv=new ModelAndView("index", "user", accountDto);
			logger.debug(mv);
			return mv;
		}
	} 
}