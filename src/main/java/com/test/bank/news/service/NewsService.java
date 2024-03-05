package com.test.bank.news.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bank.event.domain.EventDTO;
import com.test.bank.news.domain.NewsDTO;
import com.test.bank.news.repository.NewsDAO;

@Service
public class NewsService {

	@Autowired
	private NewsDAO dao;

	public Map<String, String> paging(String solting, String searchStatus, String category, String word, int page,
			int pageSize) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("solting", solting);
		map.put("searchStatus", searchStatus);
		map.put("category", category);
		map.put("word", word);

		int startIndex = (page - 1) * pageSize + 1;
		int endIndex = startIndex + pageSize - 1;

		map.put("startIndex", String.format("%d", startIndex));
		map.put("endIndex", String.format("%d", endIndex));

		int totalPosts = getTotalCount(map);
		int totalPages = (int) Math.ceil((double) totalPosts / pageSize);

		map.put("totalPosts", String.format("%d", totalPosts));
		map.put("totalPages", String.format("%d", totalPages));

		return map;
	}

	public int getTotalCount(Map<String, String> map) {
		return dao.getTotalCount(map);
	}

	public List<NewsDTO> getNewsWithPaging(Map<String, String> map) {
		return dao.getNewsWithPaging(map);
	}

	public List<NewsDTO> getLatestNews() {
		List<NewsDTO> latestNews = dao.getLatestNews();
		for (NewsDTO news : latestNews) {
			String content = news.getContent();
			int firstIndex = content.indexOf("\n");
			if (firstIndex != -1) {
				int secondIndex = content.indexOf("\n", firstIndex + 1);
				if (secondIndex != -1) {
					String trimmedContent = content.substring(0, secondIndex);
					if (trimmedContent.length() > 3) {
						news.setContent(trimmedContent.substring(0, trimmedContent.length() - 3));
					} else {
						news.setContent(trimmedContent);
					}
				}
			}
		}
		return latestNews;
	}

	public NewsDTO getNewsBySeq(int newsSeq) {
		return dao.getNewsBySeq(newsSeq);
	}

}
