package guru.springframework.mongo.model.repository;

import guru.springframework.mongo.model.domain.QuoteHistory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface QuoteHistoryRepository extends ReactiveMongoRepository<QuoteHistory,String> {
}
