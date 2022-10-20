import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public final class WeatherServiceTest {
    @Test
    void example() {
        assertThat(1 + 1, is(2));
    }

    @Test
    void weatherServiceReturnsSunnyWhenSunny(){
        HttpClient fake = new HttpClient() {
            @Override
            public String get(String url) throws IOException {
                return "Sunny";
            }
        };

        WeatherService ws = new WeatherService(fake);
        assertThat(ws.getWeatherToday(), is(Weather.SUNNY));

    }
}
