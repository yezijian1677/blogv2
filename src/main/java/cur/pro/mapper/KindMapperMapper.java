package cur.pro.mapper;

import cur.pro.entity.KindMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KindMapperMapper {
    int insert(KindMapper record);

    int insertSelective(KindMapper record);

    int insertKindBatch(@Param(value = "articleId") Integer articleId,
                        @Param(value = "kinds") List<Integer> kinds);

    int insertArticleBatch(@Param(value = "kind") Integer kind,
                           @Param(value = "articleIds") List<Integer> articleIds);

    List<Integer> selectArticleByKind(Integer kind);

    List<Integer> selectKindByArticleId(Integer articleId);

    List<Integer> selectBatchByKinds(@Param(value = "kinds") List<Integer> kinds);

    int deleteByArticleId(Integer articleId);

    int deleteByKind(Integer kind);
}