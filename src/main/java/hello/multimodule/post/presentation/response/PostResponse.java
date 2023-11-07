package hello.multimodule.post.presentation.response;

import hello.multimodule.post.domain.Post;
import lombok.Getter;

@Getter
public class PostResponse {
    private final Long id;
    private final String title;
    private final String content;

    private PostResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static PostResponse from(Post post) {
        return new PostResponse(post.id(), post.title(), post.content());
    }
}
