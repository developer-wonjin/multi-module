package hello.multimodule.post.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PostTest {
    @Test
    void PostCreate로_Post가_생성된다() {
        // given
        PostCreate postCreate = new PostCreate("title", "content");

        // when
        Post post = Post.from(postCreate);

        // then
        assertThat(post.title()).isEqualTo("title");
        assertThat(post.content()).isEqualTo("content");
    }

    @ParameterizedTest(name = "value = {0}")
    @NullAndEmptySource
    void title이_빈_값이거나_null이면_예외가_발생한다(String title) {
        // given
        PostCreate postCreate = new PostCreate(title, "content");

        // when & then
        assertThatThrownBy(() -> Post.from(postCreate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("title must not be null or blank");
    }
}