package blog.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor
public class Tag {
    private Integer tagId;
    private String tagName;
    private String tagDescription;
    //文章数量(不是数据库字段)
    private Integer articleCount;

    public Tag(int parseInt) {
        this.tagId=parseInt;
    }
}
