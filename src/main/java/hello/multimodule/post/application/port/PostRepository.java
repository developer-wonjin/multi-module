package hello.multimodule.post.application.port;

import hello.multimodule.post.domain.Post;

public interface PostRepository {
    void save(Post post);
}
