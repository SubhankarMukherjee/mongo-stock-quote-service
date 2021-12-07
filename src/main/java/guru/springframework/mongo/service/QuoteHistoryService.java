package guru.springframework.mongo.service;

import guru.springframework.mongo.model.Quote;
import guru.springframework.mongo.model.domain.QuoteHistory;
import reactor.core.publisher.Mono;

public interface QuoteHistoryService {

    Mono<QuoteHistory> savedQuoteToMongo(Quote quote);
}
