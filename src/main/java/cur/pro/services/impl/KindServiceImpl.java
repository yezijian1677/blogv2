package cur.pro.services.impl;

import cur.pro.entity.Kind;
import cur.pro.mapper.KindMapper;
import cur.pro.services.KindService;
import cur.pro.utils.JsonUtil;
import cur.pro.utils.RedisPoolUtil;
import cur.pro.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KindServiceImpl implements KindService {
    @Autowired
    private KindMapper kindMapper;
    @Autowired
    private JsonUtil jsonUtil;
    @Autowired
    private RedisPoolUtil redisPoolUtil;
    public Result<Kind> getAll() {
        List<Kind> kinds = jsonUtil.string2Obj(redisPoolUtil.get("kinds"), List.class, Kind.class);
        if (kinds == null || kinds.size() == 0) {
            List<Kind> data = kindMapper.selectAll();
            redisPoolUtil.setEx("kinds", jsonUtil.obj2String(data), 60*10);
            return Result.success(data);
        }
        return Result.success(kinds);
    }
}
