package cur.pro.mapper;

import cur.pro.entity.Token;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TokenMapper {
    int insert(Token record);

    int insertSelective(Token record);

    Token selectByToken(String token);

    List<Token> selectByUid(Integer uid);

    Token selectByTokenAndStat(@Param(value = "token")String token, @Param(value = "stat")Byte stat);

    int updateStatByDate(@Param(value = "date") Date date, @Param(value = "stat") Byte stat);

    int updateStatByToken(@Param(value = "stat") Byte stat, @Param(value = "token") String token);
}