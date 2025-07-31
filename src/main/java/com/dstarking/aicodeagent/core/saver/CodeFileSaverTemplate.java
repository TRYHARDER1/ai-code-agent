package com.dstarking.aicodeagent.core.saver;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.dstarking.aicodeagent.exception.BusinessException;
import com.dstarking.aicodeagent.exception.ErrorCode;
import com.dstarking.aicodeagent.model.enums.CodeGenTypeEnum;

import java.io.File;
import java.nio.charset.StandardCharsets;

public abstract class CodeFileSaverTemplate<T> {
    //文件保存路径
    private static final String FILE_SAVE_ROOT_DIR = System.getProperty("user.dir") + "/tmp/code_output/";



    public final File saveCode(T result){
        //验证输入
        validateInput(result);
        //构建唯一目录
        String baseDirPath = buildUniqueDir();
        //保存文件
        saveFiles(result, baseDirPath);
        //返回文件目录对象
        return new File(baseDirPath);
    }

    public final void writeToFile(String dirPath, String fileName, String content) {
        if (StrUtil.isNotBlank(content)){
            String filePath = dirPath + File.separator + fileName;
            FileUtil.writeString(content, filePath, StandardCharsets.UTF_8);
        }

    }

    protected void validateInput(T result) {
        if (result == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "输入结果不能为空");
        }
    }

    private String buildUniqueDir(){
        String codeType = getCodeType().getValue();
        String uniqueDirName = StrUtil.format("{}_{}", codeType, IdUtil.getSnowflakeNextIdStr());
        String dirPath = FILE_SAVE_ROOT_DIR + File.separator + uniqueDirName;
        FileUtil.mkdir(dirPath);
        return dirPath;
    }

    protected abstract void saveFiles(T result, String baseDirPath);

    protected abstract CodeGenTypeEnum getCodeType();
}
