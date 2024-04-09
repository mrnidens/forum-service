package ait.cohort34.post.dao;

import ait.cohort34.post.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByAuthor(String author);

    List<Post> findByTagsIn(Collection<String> tags);
    List<Post> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);
}
