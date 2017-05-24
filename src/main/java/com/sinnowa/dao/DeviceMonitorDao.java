package com.sinnowa.dao;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 */
public interface DeviceMonitorDao {
    public List<String> getDeviceName(Date startDate,Date endDate);
}
