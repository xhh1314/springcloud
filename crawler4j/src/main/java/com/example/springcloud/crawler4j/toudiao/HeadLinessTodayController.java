/*
package com.example.springcloud.crawler4j.toudiao;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.springframework.stereotype.Service;

public class HeadLinessTodayController {
    public static void main(String[] args) throws Exception {
        String crawlStorageFolder = "d:/crawler/toutiao";
        int numberOfCrawlers = 4;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);

        */
/*
         * Instantiate the controller for this crawl.
         *//*

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        */
/*
         * For each crawl, you need to add some seed urls. These are the first
         * URLs that are fetched and then the crawler starts following links
         * which are found in these pages
         *//*

       // controller.addSeed("https://www.toutiao.com/a6512307262168498692/");
       // controller.addSeed("https://www.toutiao.com/a6512555192825676291/");
       // controller.addSeed("https://www.toutiao.com/a6508915375416017412/");
       // controller.addSeed("https://www.toutiao.com/");
        controller.addSeed("http://finance.people.com.cn/n1/2018/0119/c1004-29773780.html");

        */
/*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         *//*

        controller.start(HeadLinessTodayCrawler.class, numberOfCrawlers);
    }
}
*/
