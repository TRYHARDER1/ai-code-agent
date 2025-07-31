package com.dstarking.aicodeagent.service;

import com.dstarking.aicodeagent.model.dto.app.AppQueryRequest;
import com.dstarking.aicodeagent.model.entity.App;
import com.dstarking.aicodeagent.model.entity.User;
import com.dstarking.aicodeagent.model.vo.AppVO;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author dstarking
 * @since 2025-07-31
 */
public interface AppService extends IService<App> {

    AppVO getAppVO(App app);

    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    List<AppVO> getAppVOList(List<App> appList);

    Flux<String> chatToGenCode(Long appId, String message, User loginUser);

    String deployApp(Long appId, User loginUser);
}
