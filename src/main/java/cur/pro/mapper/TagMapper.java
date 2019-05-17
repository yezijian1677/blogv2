package cur.pro.mapper;

import cur.pro.entity.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    List<Tag> selectByIds(@Param(value = "ids") List<Integer> ids);

    List<Integer> selectIdByLikeName(String info);

    List<Tag> selectAll();
}