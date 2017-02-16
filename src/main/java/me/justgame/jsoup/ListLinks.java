package me.justgame.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


/**
 * Created by xcl on 2017-02-04.
 */
public class ListLinks {

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        return s.length() > width?s.substring(0, width - 1) + ".":s;
    }

    public static void main(String[] args) throws IOException {
        // Validate.isTrue(args.length == 1, "usage: supply url to fetch");
        // String url = args[0];
        String url = "https://www.baidu.com";
        print("Fetching %s...", url);

        // 下载url并解析成html DOM结构
        Document doc = Jsoup.connect(url).get();
        System.out.println(doc.toString());
        // 使用select方法选择元素，参数是CSS Selector表达式
        Elements links = doc.select("a[href]");

        print("\nLinks: (%d)", links.size());
        for (Element link : links) {
            //使用abs:前缀取绝对url地址
            print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
        }
    }
}
