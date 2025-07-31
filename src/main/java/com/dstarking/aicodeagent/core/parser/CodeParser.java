package com.dstarking.aicodeagent.core.parser;

public interface CodeParser<T> {

    T parseCode(String codeContent);
}
