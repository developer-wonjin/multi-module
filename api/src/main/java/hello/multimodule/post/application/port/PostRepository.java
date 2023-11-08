package hello.multimodule.post.application.port;

import hello.multimodule.post.domain.Post;

import java.util.List;

public interface PostRepository {
    void save(Post post);

    List<Post> getAll();
}
