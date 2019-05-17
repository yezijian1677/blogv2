package cur.pro.mapper;

import cur.pro.entity.Img;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImgMapper {
    int insert(Img record);

    int insertSelective(Img record);

    int insertBatch(@Param(value = "articleId") Integer articleId,
                    @Param(value = "imgs")List<String> imgs);

    List<String> selectByArticleId(Integer articleId);
}