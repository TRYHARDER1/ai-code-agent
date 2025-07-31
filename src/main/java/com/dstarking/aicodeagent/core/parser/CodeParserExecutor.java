package com.dstarking.aicodeagent.core.parser;

import com.dstarking.aicodeagent.exception.BusinessException;
import com.dstarking.aicodeagent.exception.ErrorCode;
import com.dstarking.aicodeagent.model.enums.CodeGenTypeEnum;

public class CodeParserExecutor {
    public static final HtmlCodeParser HTML_CODE_PARSER = new HtmlCodeParser();
    public static final MultiFileCodeParser MULTI_FILE_CODE_PARSER = new MultiFileCodeParser();

    public static Object executeParser(String codeContent, CodeGenTypeEnum codeGenTypeEnum){
        return switch (codeGenTypeEnum) {
            case HTML -> HTML_CODE_PARSER.parseCode(codeContent);
            case MULTI_FILE -> MULTI_FILE_CODE_PARSER.parseCode(codeContent);
            default -> throw new BusinessException(ErrorCode.PARAMS_ERROR, "不支持的代码生成类型: " + codeGenTypeEnum.name());
        };
    }
}
