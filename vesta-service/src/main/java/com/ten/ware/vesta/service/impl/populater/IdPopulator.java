package com.ten.ware.vesta.service.impl.populater;

import com.ten.ware.vesta.service.bean.Id;
import com.ten.ware.vesta.service.impl.bean.IdMeta;
import com.ten.ware.vesta.service.impl.timer.Timer;

public interface IdPopulator {

    void populateId(Timer timer, Id id, IdMeta idMeta);

}
