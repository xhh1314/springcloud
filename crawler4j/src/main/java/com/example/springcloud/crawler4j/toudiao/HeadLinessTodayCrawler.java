package com.example.springcloud.crawler4j.toudiao;

import com.example.springcloud.crawler4j.dao.ContentDaoImpl;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.regex.Pattern;


@Component
public class HeadLinessTodayCrawler extends WebCrawler {
    private final static Pattern FILTERS = Pattern.compile(".*(\\.(js|css|mp3|mp4|zip|gz))$");
    @Autowired
    private ContentDaoImpl contentDao;

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        return !FILTERS.matcher(href).matches();
    }

    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
        System.out.println("URL: " + url);
        if (!(page.getParseData() instanceof HtmlParseData))
            return;
        HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
        String text = htmlParseData.getText();
        String html = htmlParseData.getHtml();
        Set<WebURL> links = htmlParseData.getOutgoingUrls();
        System.out.println("Text length: " + text);
           /* System.out.println("Html length: " + html.length());
            System.out.println("Number of outgoing links: " + links.size());*/

    }
}
