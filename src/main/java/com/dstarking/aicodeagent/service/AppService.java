package com.dstarking.aicodeagent.service;

import com.dstarking.aicodeagent.model.dto.app.AppQueryRequest;
import com.dstarking.aicodeagent.model.vo.AppVO;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.dstarking.aicodeagent.model.entity.App;

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
}
