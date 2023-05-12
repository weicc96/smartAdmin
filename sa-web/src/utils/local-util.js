/*
 * localStorage 相关操作
 *
 * @Author:    weicc
 * @Date:      2022-09-06 20:58:49
 * @Wechat:    wcchen96
 * @Email:     15793730318@163.com
 */
export const localSave = (key, value) => {
  localStorage.setItem(key, value);
};

export const localRead = (key) => {
  return localStorage.getItem(key) || '';
};

export const localClear = () => {
  localStorage.clear();
};
