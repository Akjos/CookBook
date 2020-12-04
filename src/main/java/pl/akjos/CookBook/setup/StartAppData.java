package pl.akjos.CookBook.setup;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartAppData implements ApplicationRunner {

    private final StartingDataService startingDataService;

    @Override
    public void run(ApplicationArguments args) {
        startingDataService.start();
    }
}
