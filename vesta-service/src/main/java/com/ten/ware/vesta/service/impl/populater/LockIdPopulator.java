package com.ten.ware.vesta.service.impl.populater;

import com.ten.ware.vesta.service.bean.Id;
import com.ten.ware.vesta.service.impl.bean.IdMeta;
import com.ten.ware.vesta.service.impl.timer.Timer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁计算
 */
public class LockIdPopulator extends BasePopulator {

    /**
     * 可重入锁比synchro效率高，适合高并发
     */
    private Lock lock = new ReentrantLock();

    public LockIdPopulator() {
        super();
    }

    @Override
    public void populateId(Timer timer, Id id, IdMeta idMeta) {
        lock.lock();
        try {
            super.populateId(timer, id, idMeta);
        } finally {
            lock.unlock();
        }
    }

}
