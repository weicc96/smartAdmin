/*
 * 首页api
 *
 * @Author:    weicc
 * @Date:      2022-09-03 21:59:39
 * @Wechat:    wcchen96
 * @Email:     15793730318@163.com
 */
import { getRequest } from '/@/lib/axios';

export const homeApi = {
  /**
   * @description: 首页-金额统计（业绩、收款、订单数等） @author 卓大
   * @param {*}
   * @return {*}
   */
  homeAmountStatistics: () => {
    return getRequest('/home/amount/statistics');
  },
  /**
   * @description: 首页-待办信息 @author 卓大
   * @param {*}
   * @return {*}
   */
  homeWaitHandle: () => {
    return getRequest('home/wait/handle');
  },
};
