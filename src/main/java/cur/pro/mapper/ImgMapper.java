package cur.pro.mapper;

import cur.pro.entity.Img;

public interface ImgMapper {
    int insert(Img record);

    int insertSelective(Img record);
}