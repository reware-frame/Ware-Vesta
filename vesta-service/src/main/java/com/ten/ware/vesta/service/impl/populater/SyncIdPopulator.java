package com.ten.ware.vesta.service.impl.populater;

import com.ten.ware.vesta.service.bean.Id;
import com.ten.ware.vesta.service.impl.bean.IdMeta;
import com.ten.ware.vesta.service.impl.timer.Timer;

public class SyncIdPopulator extends BasePopulator {

    public SyncIdPopulator() {
        super();
    }

    @Override
    public synchronized void populateId(Timer timer, Id id, IdMeta idMeta) {
        super.populateId(timer, id, idMeta);
    }

}
