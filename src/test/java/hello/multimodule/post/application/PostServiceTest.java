package hello.multimodule.post.application;

import hello.multimodule.mock.FakePostRepository;
import hello.multimodule.post.application.port.PostRepository;
import hello.multimodule.post.domain.Post;
import hello.multimodule.post.domain.PostCreate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class PostServiceTest {
    private PostService postService;
    private PostRepository postRepository;

    @BeforeEach
    void setUp() {
        postRepository = new FakePostRepository();
        postService = new PostService(postRepository);
    }

    @Test
    void PostCreate를_받고_Post를_저장한다() {
        // given
        PostCreate postCreate = new PostCreate("title", "content");

        // when
        postService.save(postCreate);

        // then
        Post post = postRepository.getAll().get(0);
        assertThat(post.id()).isEqualTo(1L);
        assertThat(post.title()).isEqualTo("title");
        assertThat(post.content()).isEqualTo("content");
    }

    @Test
    void 저장된_모든_Post_목록을_반환한다() {
        // given
        IntStream.rangeClosed(1, 10)
                .forEach(i -> postService.save(new PostCreate("title" + i, "content" + i)));

        // when
        List<Post> posts = postService.getAll();

        // then
        assertThat(posts).hasSize(10);
    }
}