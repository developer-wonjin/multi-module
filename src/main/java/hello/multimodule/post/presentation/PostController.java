package hello.multimodule.post.presentation;

import hello.multimodule.post.application.PostService;
import hello.multimodule.post.domain.PostCreate;
import hello.multimodule.post.presentation.response.PostsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/posts")
@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody PostCreate postCreate) {
        postService.save(postCreate);
        return ResponseEntity
                .ok()
                .build();
    }

    @GetMapping
    public ResponseEntity<PostsResponse> getAll() {
        return ResponseEntity
                .ok()
                .body(PostsResponse.from(postService.getAll()));
    }
}
