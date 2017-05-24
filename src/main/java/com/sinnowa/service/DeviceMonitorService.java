package com.sinnowa.service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 */
public interface DeviceMonitorService {
    public List<String> getDeviceNameByTime(Date date);
}
