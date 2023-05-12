/*
 * loading 组件
 *
 * @Author:    weicc
 * @Date:      2022-07-22 20:33:41
 * @Wechat:    wcchen96
 * @Email:     15793730318@163.com
 */
import { useSpinStore } from "/@/store/modules/system/spin";

export const SmartLoading = {
  show: () => {
    useSpinStore().show();
  },

  hide: () => {
    useSpinStore().hide();
  },
};
