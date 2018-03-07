package testPackage;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.piaoling.entity.Comments;
import com.piaoling.service.CommentsService;

public class CommentsServiceImplTest extends BaseJunit{

	@Autowired
	private CommentsService CommentService;
	@Test
	public void saveComments(){
		Comments comments = new Comments();
		comments.setComId("1");
		comments.setComToId("123");
		int i=CommentService.saveComments(comments);
	}
}
