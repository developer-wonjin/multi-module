package hello.multimodule.post.presentation.response;

import hello.multimodule.post.domain.Post;
import lombok.Getter;

import java.util.List;

@Getter
public class PostsResponse {
    private final List<PostResponse> posts;

    private PostsResponse(List<PostResponse> posts) {
        this.posts = posts;
    }

    public static PostsResponse from(List<Post> posts) {
        List<PostResponse> postResponses = posts.stream()
                .map(PostResponse::from)
                .toList();

        return new PostsResponse(postResponses);
    }
}
