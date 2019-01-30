package com.ten.ware.vesta.service.impl.converter;

import com.ten.ware.vesta.service.bean.Id;
import com.ten.ware.vesta.service.impl.bean.IdMeta;

public interface IdConverter {

    long convert(Id id, IdMeta idMeta);

    Id convert(long id, IdMeta idMeta);

}
