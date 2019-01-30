package com.ten.ware.vesta.client;

import com.ten.ware.vesta.service.bean.Id;
import com.ten.ware.vesta.service.impl.bean.IdMeta;
import com.ten.ware.vesta.service.impl.bean.IdMetaFactory;
import com.ten.ware.vesta.service.impl.bean.IdType;
import com.ten.ware.vesta.service.impl.converter.IdConverter;
import com.ten.ware.vesta.service.impl.converter.IdConverterImpl;
import com.ten.ware.vesta.service.intf.IdService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

@ContextConfiguration(locations = "/spring/vesta-client-test.xml")
public class VestaClientTest extends AbstractTestNGSpringContextTests {

    @Test(groups = {"idServiceClient"})
    public void testSimple() {
        IdService idService = (IdService) applicationContext
                .getBean("idService");
        long id = idService.genId();
        Id ido = idService.expId(id);

        IdMeta idMeta = IdMetaFactory.getIdMeta(IdType.SECONDS);
        IdConverter idConverter = new IdConverterImpl();
        long id1 = idConverter.convert(ido, idMeta);

        AssertJUnit.assertEquals(id, id1);

        System.out.println(id);
        System.out.println(id1);
    }
}
