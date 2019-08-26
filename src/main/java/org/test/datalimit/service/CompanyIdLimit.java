package org.test.datalimit.service;

import org.test.datalimit.DataLimited;
import org.test.datalimit.KeyType;

/**
 * @Author: 徐森
 * @CreateDate: 2019/8/1
 * @Description:客户单位id权限校验实现类
 */
@KeyType(type = "companyId")
public class CompanyIdLimit implements DataLimitBase {
    @Override
    public Boolean needDataLimit(DataLimited dataLimited) {
        Boolean need = true;
        /*List<Integer> companyIds = CommonUtils.getCompanyIdsByCurrentUser();
        String value = httpServletRequest.getParameter(dataLimited.paramKey());
        if(StringUtils.isNotBlank(value)){
            Integer companyId = Integer.valueOf(value);
            for (Integer id : companyIds) {
                if(id.equals(companyId)){
                    need = false;
                }
            }
        }*/
        return need;
    }
}
