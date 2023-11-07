package hello.multimodule.post.presentation;

import hello.multimodule.post.application.PostService;
import hello.multimodule.post.domain.PostCreate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
