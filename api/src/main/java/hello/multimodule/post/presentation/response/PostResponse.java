package hello.multimodule.post.presentation.response;

import hello.multimodule.post.Post;

public record PostResponse(Long id, String title, String content) {
    public static PostResponse from(Post post) {
        return new PostResponse(post.id(), post.title(), post.content());
    }
}
