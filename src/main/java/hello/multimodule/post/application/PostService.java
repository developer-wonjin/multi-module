package hello.multimodule.post.application;

import hello.multimodule.post.application.port.PostRepository;
import hello.multimodule.post.domain.Post;
import hello.multimodule.post.domain.PostCreate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void save(PostCreate postCreate) {
        Post post = Post.from(postCreate);
        postRepository.save(post);
    }

    public List<Post> getAll() {
        return postRepository.getAll();
    }
}
