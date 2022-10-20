import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpClient;
import java.util.Scanner;

/**
 * EXERCISE: This "joke fetcher" class is currently hard to test.
 * First, extract the HTTP-related code to a new class with a general-purpose interface that this class can use.
 * Second, make this class return values or exceptions rather than print messages to the console directly.
 * Third, write a test for the modified code.
 * Finally, modify App.java so the behavior remains the same as before the changes.
 * <p>
 * (If you have the time, you can try improving this class to explicitly detect "ID not found" errors,
 * and write tests for the error cases)
 */
public final class JokeFetcher {
    /**
     * Prints the joke with the specific ID to the console.
     *
     * @param jokeId e.g., "R7UfaahVfFd"
     */
    public String printJokeText(String jokeId, HttpClient client) throws ConnectException {
        URL url;
        try {
            url = new URL("https://icanhazdadjoke.com/j/" + jokeId);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Bad URL");
        }
        HttpURLConnection connection;
        try {
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            //System.out.println("Cannot connect to jokes server.");
            throw new ConnectException("couldn't connect to jokes server.");
        }
        connection.setRequestProperty("Accept", "text/plain");
        try (var connectionStream = connection.getInputStream();
             var s = new Scanner(connectionStream).useDelimiter("\\A")) {
            //System.out.println(s.next());
            return s.next();
        } catch (IOException e) {
            //System.out.println("Cannot fetch jokes.");
            throw new RuntimeException("Cannot fetch jokes.");
        }
    }
}
