import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import java.io.FileNotFoundException;
import java.util.List;


public class Main {

    public static void main(String ... args) throws FileNotFoundException {

        Object document = Configuration.defaultConfiguration()
                .jsonProvider().parse(Main.class.getResourceAsStream("data.json"), "UTF-8");

        List<String> bookTiles = JsonPath.read(document, "$..book[?(@.category == 'fiction')].title");

        System.out.println(bookTiles);

    }
}
