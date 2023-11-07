package hello.multimodule.mock;

import hello.multimodule.post.application.port.PostRepository;
import hello.multimodule.post.domain.Post;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FakePostRepository implements PostRepository {
    private Long autoIncrement = 0L;
    private List<Post> posts = new ArrayList<>();

    @Override
    public void save(Post post) {
        posts.add(new Post(++autoIncrement, post.title(), post.content()));
    }

    @Override
    public List<Post> getAll() {
        return Collections.unmodifiableList(posts);
    }
}
