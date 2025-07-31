package com.dstarking.aicodeagent.core;

import com.dstarking.aicodeagent.model.enums.CodeGenTypeEnum;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.io.File;
import java.util.List;

@SpringBootTest
class AiCodeGeneratorFacadeTest {

    @Resource
    private AiCodeGeneratorFacade aiCodeGeneratorFacade;

    @Test
    void generateAndSaveCode() {
        File file = aiCodeGeneratorFacade.generateAndSaveCode("生成一个简单的HTML页面", CodeGenTypeEnum.HTML);
        Assertions.assertNotNull(file, "生成的文件不应为null");
    }

    @Test
    void generateAndSaveCodeStream() {
        Flux<String> codeStream = aiCodeGeneratorFacade.generateAndSaveCodeStream("生成一个简单的HTML页面", CodeGenTypeEnum.HTML);
        List<String> block = codeStream.collectList().block();
        Assertions.assertNotNull(block, "代码流不应为null");
        String completeContent = String.join("", block);
        Assertions.assertFalse(completeContent.isEmpty(), "生成的代码内容不应为空");
    }
}
