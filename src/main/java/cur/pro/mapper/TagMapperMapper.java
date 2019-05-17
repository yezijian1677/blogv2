package cur.pro.mapper;

import cur.pro.entity.TagMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagMapperMapper {
    int insert(TagMapper record);

    int insertSelective(TagMapper record);

    List<Integer> selectArticleIdByTag(Integer tag);

    List<Integer> selectTagByArticleId(Integer articleId);

    List<Integer> selectBatchByTags(@Param(value = "tags") List<Integer> tags);
}