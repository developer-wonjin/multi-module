package hello.multimodule.post.presentation.response;

import hello.multimodule.post.Post;
import java.util.List;

public record PostsResponse(List<PostResponse> posts) {
    public static PostsResponse from(List<Post> posts) {
        List<PostResponse> postResponses = posts.stream()
                .map(PostResponse::from)
                .toList();

        return new PostsResponse(postResponses);
    }
}
