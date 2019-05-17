package cur.pro.mapper;

import cur.pro.entity.Kind;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KindMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Kind record);

    int insertSelective(Kind record);

    Kind selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Kind record);

    int updateByPrimaryKey(Kind record);

    List<Kind> selectAll();

    List<Kind> selectByIds(@Param(value = "ids") List<Integer> ids);

    Kind selectByName(String name);

    List<Integer> selectIdByLikeName(String name);
}