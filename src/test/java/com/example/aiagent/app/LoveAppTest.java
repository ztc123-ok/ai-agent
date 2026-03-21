package com.example.aiagent.app;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class LoveAppTest {

    @Resource
    private LoveApp loveApp;

    @Test
    void doChat() {
        String chatId = UUID.randomUUID().toString();

        log.info("========== 开始三轮对话测试 ==========");

        // 第一轮对话
        String response1 = loveApp.doChat("你好，我叫小明", chatId);
        log.info("第一轮 - 用户: 你好，我叫小明");
        log.info("第一轮 - AI: {}", response1);

        // 第二轮对话（测试是否记住名字）
        String response2 = loveApp.doChat("我的名字是什么？", chatId);
        log.info("第二轮 - 用户: 我的名字是什么？");
        log.info("第二轮 - AI: {}", response2);

        // 第三轮对话（测试上下文连贯性）
        String response3 = loveApp.doChat("我刚才说了什么？", chatId);
        log.info("第三轮 - 用户: 我刚才说了什么？");
        log.info("第三轮 - AI: {}", response3);

        log.info("========== 三轮对话测试完成 ==========");
    }
}