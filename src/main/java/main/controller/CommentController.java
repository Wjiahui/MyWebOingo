package main.controller;

import main.model.Comment;
import main.service.CommentService;
import main.util.CommonUtil;
import main.util.TimeConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/*在类上使用@RequestMapping注解
* 作用：Controller负责处理的根目录下的URL，
* /comment/*下所有的路径都会被controller所拦截*/
@RestController
@RequestMapping("comment")
public class CommentController {
    static final Logger logger = LoggerFactory.getLogger(CommentController.class);
    @Autowired
    private CommentService commentService;

    /*在方法上使用@RequestMapping，该方法负责处理/comment/addComment这个url*/
    @GetMapping(value = "addComment")
    public Map<String, Object> addComment(HttpServletRequest request) {
        Map<String, Object> result = CommonUtil.getResult();
        /*request.getParameter() 它是一种取参数的方法，把表单中的数据读取到出来，然后就可以封装利用起来*/
        int nid = Integer.parseInt(request.getParameter("nid"));
        String content = request.getParameter("content");

        Comment comment = new Comment(0, nid, TimeConvert.getTimeNow(), content);
        commentService.addComment(comment);
        return result;
    }

    @GetMapping(value = "deleteComment")
    public Map<String, Object> deleteComment(HttpServletRequest request) {
        Map<String, Object> result = CommonUtil.getResult();
        int cid = Integer.parseInt(request.getParameter("cid"));
        commentService.deleteComment(cid);
        return result;
    }

    @GetMapping(value = "listComment")
    public List<Comment> listComment(HttpServletRequest request) {
        int nid = Integer.parseInt(request.getParameter("nid"));
        return commentService.getComment(nid);
    }

}
