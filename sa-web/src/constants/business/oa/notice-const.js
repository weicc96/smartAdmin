/*
 * 通知
 *
 * @Author:    weicc
 * @Date:      2022-09-03 22:07:27
 * @Wechat:    wcchen96
 * @Email:     15793730318@163.com
 */

export const NOTICE_VISIBLE_RANGE_DATA_TYPE_ENUM = {
  EMPLOYEE: {
    value: 1,
    desc: '员工',
  },
  DEPARTMENT: {
    value: 2,
    desc: '部门',
  },
};

export const NOTICE_TYPE_ENUM = {
  ANNOUNCEMENT: {
    value: 1,
    desc: '公告',
  },
  NOTICE: {
    value: 2,
    desc: '通知',
  },
};

export default {
  NOTICE_VISIBLE_RANGE_DATA_TYPE_ENUM,
  NOTICE_TYPE_ENUM,
};
