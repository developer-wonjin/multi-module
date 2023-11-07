package hello.multimodule.post.infra;

import hello.multimodule.post.application.port.PostRepository;
import hello.multimodule.post.domain.Post;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepositoryImpl implements PostRepository {
    private final PostEntityRepository postEntityRepository;

    public PostRepositoryImpl(PostEntityRepository postEntityRepository) {
        this.postEntityRepository = postEntityRepository;
    }

    @Override
    public void save(Post post) {
        postEntityRepository.save(PostEntity.from(post));
    }
}
