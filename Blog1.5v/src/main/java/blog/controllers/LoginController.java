package controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
 

@Configuration
@EnableWebSecurity
public class LoginController extends WebSecurityConfigurerAdapter{
	
	
	
	
	 @Bean("authenticationManager")
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	            return super.authenticationManagerBean();
	    }
	 
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        // @formatter:off
	        auth.inMemoryAuthentication()
	            .withUser("user1").password("{noop}u").roles("USER")
	            .and()
	            .withUser("admin1").password("{noop}a").roles("ADMIN");
	        // @formatter:on
	    }
	 
	    @Bean
	    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
	        return new UrlAuthenticationSuccessHandler();
	    }
	    
	    @Override
	    protected void configure(final HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	            .antMatchers("/anonymous*").anonymous()
	            .antMatchers("/", "/home","/registration").permitAll()
	            .antMatchers("/login*").permitAll()
	            .anyRequest().authenticated()
	             
	            .and()
	            .formLogin()
	            .loginPage("/login")
	            .loginProcessingUrl("/login")
	            .successHandler(myAuthenticationSuccessHandler()); 
	    }
	
	
	
	
//	public void addViewControllers(ViewControllerRegistry registry) {
 
    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/", "/home","/registration").permitAll()
//                .anyRequest().authenticated()
//                .and()
//            .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//            .logout()
//                .permitAll().and()
//            .sessionManagement()
//                .maximumSessions(1).sessionRegistry(sessionRegistry());
//    }
//
//    @Bean
//    public SessionRegistry sessionRegistry() {
//        return new SessionRegistryImpl();
//    }
//    
//    @Autowired
//	private SessionRegistry sessionRegistry;
//	 
//	public List<String> getUsersFromSessionRegistry() {
//	    return sessionRegistry.getAllPrincipals().stream()
//	      .filter(u -> !sessionRegistry.getAllSessions(u, false).isEmpty())
//	      .map(Object::toString)
//	      .collect(Collectors.toList());
//	}
//    
//    
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        @SuppressWarnings("deprecation")
//		UserDetails user =
//             User.withDefaultPasswordEncoder()
//                .username("q")
//                .password("q")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
		
		
}
