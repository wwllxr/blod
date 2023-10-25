package blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data   //getter setter toString  hashCode
@AllArgsConstructor  //生成全参的构造方法
@NoArgsConstructor  //生成无参的构造方法
public class Comment {
    // 自增id
    private Integer commentId;

    // 评论的父级ID
    private Integer commentPid;

    // 评论人的名称
    private String commentPname;

    // 被评论的文章的ID
    private Integer commentArticleId;

    // 评论者名称
    private String commentAuthorName;

    // 评论者邮箱
    private String commentAuthorEmail;

    // 评论者的网址
    private String commentAuthorUrl;

    // 评论者的头象地址
    private String commentAuthorAvatar;

    // 评论的内容
    private String commentContent;

    // 评论者的代理服务器
    private String commentAgent;

    // 评论人的IP
    private String commentIp;

    // 论评创建的时间
    private Date commentCreateTime;

    // 论评人的角色(管理员 1, 访客 0)
    private Integer commentRole;

    // 被评论的文章是哪个 非数据库字段
    private Article article;
}
