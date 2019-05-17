package cur.pro.mapper;

import cur.pro.entity.Img;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImgMapper {
    int insert(Img record);

    int insertSelective(Img record);

    int insertBatch(@Param(value = "articleId") Integer articleId,
                    @Param(value = "imgs")List<String> imgs);

    List<String> selectByArticleId(Integer articleId);
}