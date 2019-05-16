package cur.pro.mapper;

import cur.pro.entity.Kind;

public interface KindMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Kind record);

    int insertSelective(Kind record);

    Kind selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Kind record);

    int updateByPrimaryKey(Kind record);
}