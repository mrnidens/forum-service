package ait.cohort34.accounting.dao;

import ait.cohort34.accounting.model.UserAccount;
import ait.cohort34.post.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<UserAccount, String> {
}
