package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import models.Post;

@Service 
public class PostServiceStubImpl implements PostService {
	 
	private ArrayList<Post> posts = new ArrayList<Post>() {{
//		add(new Post(1L, "First Post", "Body", "Author")); 
	}};

	@Override
	public List<Post> findAll() {
		System.out.println("In findAll() --> " + this.posts);
		return this.posts;
	}  
}
