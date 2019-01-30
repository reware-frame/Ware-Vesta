package com.ten.ware.vesta.service.impl.populater;

import com.ten.ware.vesta.service.bean.Id;
import com.ten.ware.vesta.service.impl.bean.IdMeta;
import com.ten.ware.vesta.service.impl.timer.Timer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockIdPopulator extends BasePopulator {

    private Lock lock = new ReentrantLock();

    public LockIdPopulator() {
        super();
    }

    public void populateId(Timer timer, Id id, IdMeta idMeta) {
        lock.lock();
        try {
            super.populateId(timer, id, idMeta);
        } finally {
            lock.unlock();
        }
    }

}
