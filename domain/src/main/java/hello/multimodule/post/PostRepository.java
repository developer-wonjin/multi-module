package hello.multimodule.post;

import java.util.List;

public interface PostRepository {
    void save(Post post);

    List<Post> getAll();
}
