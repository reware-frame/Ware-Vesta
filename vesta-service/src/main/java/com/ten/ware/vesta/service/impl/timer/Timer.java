package com.ten.ware.vesta.service.impl.timer;

import com.ten.ware.vesta.service.impl.bean.IdMeta;
import com.ten.ware.vesta.service.impl.bean.IdType;

import java.util.Date;

public interface Timer {
    long EPOCH = 1514736000000L;

    void init(IdMeta idMeta, IdType idType);

    Date transTime(long time);

    void validateTimestamp(long lastTimestamp, long timestamp);

    long tillNextTimeUnit(long lastTimestamp);

    long genTime();

}
