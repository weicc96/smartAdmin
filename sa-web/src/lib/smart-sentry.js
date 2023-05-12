/*
 * 错误上报sentry
 *
 * @Author:    weicc
 * @Date:      2022-09-06 20:49:28
 * @Wechat:    wcchen96
 * @Email:     15793730318@163.com
 */

export const smartSentry = {
  /**
   * sentry 主动上报
   */
  captureError: (error) => {
    if (error.config && error.data && error && error.headers && error.request && error.status) {
      return;
    }
    // Sentry.captureException(error);
    console.error(error);
  },
};
