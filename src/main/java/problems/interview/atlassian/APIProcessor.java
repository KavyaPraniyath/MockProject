package problems.interview.atlassian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APIProcessor {
    /**
     * Write the code that, given the list of URLs, will return the corresponding response bodies for GET requests to these URLs. Please feel free to use an HTTP client library, either included with your programming language of choice or a third-party one.
     */
    public static int getBody(String url) {
        return url.length();
    }

    public static void getBody(List<String> urls) {
        Map<String, Integer> body = new HashMap<>();
        for (String url : urls) {
            if (body.containsKey(url)) {
                System.out.println("Inside map");
                System.out.println(url + " " + body.get(url));
            } else {
                body.put(url, getBody(url));
                System.out.println(url + " " + body.get(url));
            }

        }
    }

    public static void main(String[] args) {
        List<String> urls = new ArrayList<>();;
        urls.add("https://www.baidu.com");
        urls.add("https://www.baidu.com");
        urls.add("https://www.baidu1.com");
        getBody(urls);
    }

}