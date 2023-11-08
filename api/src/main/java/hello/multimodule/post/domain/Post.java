package hello.multimodule.post.domain;

public record Post(Long id, String title, String content) {
    public Post {
        validateTitle(title);
    }

    private void validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title must not be null or blank");
        }
    }

    public static Post from(PostCreate postCreate) {
        return new Post(null, postCreate.title(), postCreate.content());
    }
}
