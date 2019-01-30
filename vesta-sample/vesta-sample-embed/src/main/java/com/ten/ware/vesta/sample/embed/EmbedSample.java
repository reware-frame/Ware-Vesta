package com.ten.ware.vesta.sample.embed;

import com.ten.ware.vesta.service.bean.Id;
import com.ten.ware.vesta.service.intf.IdService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmbedSample {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring/vesta-service-sample.xml");
        IdService idService = (IdService) ac.getBean("idService");

        long id = idService.genId();
        Id ido = idService.expId(id);

        System.out.println(id + ":" + ido);
    }
}
