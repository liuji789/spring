package com.java11;

import lombok.SneakyThrows;
import org.junit.Test;

import javax.annotation.Nonnull;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.stream.Stream;

/**
 * @author admin
 *
 * 增加的一些API，httpClient
 * var 类型推断
 *
 */
public class NewCaseTest {
    
    @SneakyThrows
    @Test
    public void test001() {
        String str = "woshidage";

        //判断字符串是空白
        System.out.println("\"  \".isBlank() = " + "  ".isBlank());

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.baidu.com")).build();

        HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString();

        HttpResponse<String> httpResponse = httpClient.send(request, bodyHandler);

        System.out.println(httpResponse);

        String body = httpResponse.body();

        System.out.println("body = " + body);

        var a = 100;

        System.out.println(a);

        var b = "bb";

        System.out.println("b = " + b);

    }

    @Test
    @SneakyThrows
    public void test002() throws Exception {
        String[] arr = { "program", "creek", "is", "a", "java", "site"};
        Stream<String> stream = Stream.of(arr);
        stream.forEach((@Nonnull var x) -> System.out.print(x + "\t"));
    }
}
