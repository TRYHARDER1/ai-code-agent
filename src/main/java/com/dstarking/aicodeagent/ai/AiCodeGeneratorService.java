package com.dstarking.aicodeagent.ai;

import com.dstarking.aicodeagent.ai.model.HtmlCodeResult;
import com.dstarking.aicodeagent.ai.model.MultiFileCodeResult;
import dev.langchain4j.service.SystemMessage;
import reactor.core.publisher.Flux;

public interface AiCodeGeneratorService {

    @SystemMessage(fromResource = "prompt/codegen-html-system-prompt.txt")
    HtmlCodeResult generateHtmlCode(String userMessage);

    @SystemMessage(fromResource = "prompt/codegen-multi-file-system-prompt.txt")
    MultiFileCodeResult generateMultiFileCode(String userMessage);


    @SystemMessage(fromResource = "prompt/codegen-html-system-prompt.txt")
    Flux<String> generateHtmlCodeStream(String userMessage);

    @SystemMessage(fromResource = "prompt/codegen-multi-file-system-prompt.txt")
    Flux<String> generateMultiFileCodeStream(String userMessage);
}
