package testPackage;



import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.Jedis;

import com.piaoling.entity.News;
import com.piaoling.service.NewsService;
import com.piaoling.util.RedisUtil;
 
public class NewsServiceImplTest extends BaseJunit{

	@Autowired
	private NewsService newsService;
	@Autowired
    private RedisUtil redisUtil;  
	@Test
	public void getNewsByPrimaryKey()  {
		/*News news =new News();
		news.setNewsId("3");
		news.setKeywords("爱国");
		news.setNewsContent("我是中国人范德萨发打谁范德萨范德萨发");
		int t;
		try {
			t = newsService.saveNews(news);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		News  news1=newsService.getNewsByPrimaryKey("3");*/
		//System.out.println(t+"测试类：：==========="+news1.getNewsContent());
		
		//2.测试redis
		redisUtil.set("name", "张三");
		System.out.println("用户名"+redisUtil.get("name"));
	}
}
