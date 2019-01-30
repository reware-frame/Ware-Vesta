package com.ten.ware.vesta.service.intf;

import com.ten.ware.vesta.service.bean.Id;

import java.util.Date;

/**
 * 服务API定义
 */
public interface IdService {

    /**
     * 产生ID
     */
    public long genId();

    /**
     * 反解ID
     */
    public Id expId(long id);

    public long makeId(long time, long seq);

    public long makeId(long time, long seq, long machine);

    public long makeId(long genMethod, long time, long seq, long machine);

    public long makeId(long type, long genMethod, long time,
                       long seq, long machine);

    public long makeId(long version, long type, long genMethod,
                       long time, long seq, long machine);

    public Date transTime(long time);
}
