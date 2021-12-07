package guru.springframework.mongo.service;

import guru.springframework.mongo.model.domain.QuoteHistory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@RequiredArgsConstructor
@Slf4j
public class QuoteRunner implements CommandLineRunner {
    private final QuoteGeneratorService service;
    private final QuoteHistoryService historyService;
    @Override
    public void run(String... args) throws Exception {
        service.fetchQuoteStream(Duration.ofMillis(100l))
                .take(50)
                .log("Get Quote:")
                .flatMap(quote -> {
                   return historyService.savedQuoteToMongo(quote);
                })
                .subscribe(savedQuote->{
                    log.debug("Saved Quote with id"+ savedQuote.getId());
                },throwable -> {
                    // if error happen handle it here
                    log.error(throwable.getMessage());
                },()->{
          log.debug("All Done!!!");
        });
    }
}
