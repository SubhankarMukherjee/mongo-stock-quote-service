package guru.springframework.mongo.service;

import guru.springframework.mongo.model.Quote;
import guru.springframework.mongo.model.domain.QuoteHistory;
import guru.springframework.mongo.model.repository.QuoteHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
@Service
@RequiredArgsConstructor
public class QuoteHistoryServiceImpl implements QuoteHistoryService {
    private final QuoteHistoryRepository repository;

    @Override
    public Mono<QuoteHistory> savedQuoteToMongo(Quote quote) {
        return repository.save(QuoteHistory.builder().ticker(quote.getTicker())
                .price(quote.getPrice()).instant(quote.getInstant()).build());
    }
}
