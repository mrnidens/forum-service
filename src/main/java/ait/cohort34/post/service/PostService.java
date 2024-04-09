package ait.cohort34.post.service;

import ait.cohort34.post.dto.*;

import javax.swing.text.html.HTML;
import java.util.Collection;
import java.util.Set;

public interface PostService {
    PostDto addNewPost(String author, NewPostDto newPostDto);
    PostDto findPostById(String id);

    PostDto deletePost(String id);
    PostDto updatePost(String id, NewPostDto newPostDto);

    PostDto addComment(String id, String author, NewCommentDto newCommentDto);
    void addLike(String id);



    Iterable<PostDto> findPostsByAuthor(String author);

    Iterable<PostDto> findPostsByTags(Set<String> tags);

    Iterable<PostDto> findPostsByPeriod(DatePeriodDto datePeriodDto);

}
