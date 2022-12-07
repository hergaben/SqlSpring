package com.sqlspring;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URL;

@SpringBootApplication
public class SqlSpringApplication {

	private static Document getPage() throws IOException {
		String url = "https://steam250.com/2022";
		Document page = Jsoup.parse(new URL(url), 5000);
		return page;
	}


	public static void main(String[] args) throws IOException {
		Document page = getPage();
		Elements elements = page.getElementsByClass("col1 main ranking");
		for (Element element:elements) {
			String name1 = page.getElementsByClass("title").get(1).text();
			String name2 = page.getElementsByClass("title").get(2).text();
			String name3 = page.getElementsByClass("title").get(3).text();
			String name4 = page.getElementsByClass("title").get(4).text();
			String name5 = page.getElementsByClass("title").get(5).text();

			Element img1 = page.select("img[data-src]").get(0);
			Element img2 = page.select("img[data-src]").get(1);
			Element img3 = page.select("img[data-src]").get(2);
			Element img4 = page.select("img[data-src]").get(3);
			Element img5 = page.select("img[data-src]").get(4);
			String im1 = img1.attributes().get("data-src");
			String im2 = img2.attributes().get("data-src");
			String im3 = img3.attributes().get("data-src");
			String im4 = img4.attributes().get("data-src");
			String im5 = img5.attributes().get("data-src");

			String score1 = page.getElementsByClass("score").get(0).text();
			String score2 = page.getElementsByClass("score").get(1).text();
			String score3 = page.getElementsByClass("score").get(2).text();
			String score4 = page.getElementsByClass("score").get(3).text();
			String score5 = page.getElementsByClass("score").get(4).text();
			System.out.println(name1 +" "+ im1 +" "+ score1 +"\n" + name2 +" "+ im2 +" "+ score2 +"\n" + name3 +" "
					+ im3 +" "+ score3 +"\n" + name4 +" "+ im4 +" "+ score4 +"\n" + name5 +" "+ im5 +" "+ score5);
			SpringApplication.run(SqlSpringApplication.class, args);
		}
	}
}
