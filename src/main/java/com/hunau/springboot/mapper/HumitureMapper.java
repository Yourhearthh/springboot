package com.hunau.springboot.mapper;

import com.hunau.springboot.domain.Humiture;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @author cx
 * @Time 2020/6/28 15:18
 * @Description 温湿度采集 数据层
 */
@Repository
public interface HumitureMapper {
    /**
     * @description 温湿度采集 查询
     *
     * @param
     * @return 温湿度采集 列表
     */
    public List<Humiture> listHumiture();
    /**
     * @description 温湿度采集 存库
     *
     * @param
     * @return 温湿度采集 存库
     */
    public int insertData(Humiture humiture);
}
