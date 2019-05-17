package cur.pro.mapper;

import cur.pro.entity.TagMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagMapperMapper {
    int insert(TagMapper record);

    int insertSelective(TagMapper record);

    List<Integer> selectArticleIdByTag(Integer tag);

    List<Integer> selectTagByArticleId(Integer articleId);

    List<Integer> selectBatchByTags(@Param(value = "tags") List<Integer> tags);
}