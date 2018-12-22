package com.example.simple.service;


import com.example.simple.entity.Danmu;
import com.example.simple.mapper.DanmuRepository;
import com.example.simple.sdk.DouYuClient;
import com.example.simple.sdk.MessageListener;
import com.example.simple.sdk.entity.ChatMsg;
import com.example.simple.utils.Dto2Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class DanmuService {
    private final static Logger logger = LoggerFactory.getLogger(DanmuService.class);

    @Autowired
    private DanmuRepository danmuRepository;


    public void saveDanmu() {
        DouYuClient client = new DouYuClient("openbarrage.douyutv.com", 8601, "156277");

        client.registerMessageListener(new MessageListener<ChatMsg>() {
            @Override
            public void read(ChatMsg message) {
                logger.info(message.toChatStr());
                Danmu danmu = new Danmu();
                danmu.setTime(new Date());

                danmu=(Danmu) Dto2Entity.populate(message,danmu);

                System.out.println(danmu.toString());

                danmuRepository.save(danmu);
            }
        });

        client.login();
        client.sync();
//        client.exit();
    }
}
