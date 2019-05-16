package cur.pro.mapper;

import cur.pro.entity.Token;

public interface TokenMapper {
    int insert(Token record);

    int insertSelective(Token record);
}