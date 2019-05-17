package cur.pro.mapper;

import cur.pro.entity.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    Article selectById(Integer id);

    List<Article> selectAll();

    List<Article> selectByIds(@Param(value = "ids") List<Integer> ids);

    List<Article> selectByYearOrderByDate(Integer year);

    List<Article> selectAllOrderByDate();

    List<Article> selectByIdsAndInfo(@Param(value = "ids")List<Integer> ids,
                                     @Param(value = "info")String info);

    List<Article> selectByInfo(String info);
}