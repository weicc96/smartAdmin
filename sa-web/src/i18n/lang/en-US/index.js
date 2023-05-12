/*
 * 英文国际化
 *
 * @Author:    weicc
 * @Date:      2022-09-06 20:00:57
 * @Wechat:    wcchen96
 * @Email:     15793730318@163.com
 */
import antd from 'ant-design-vue/es/locale-provider/en_US';
import dayjs from 'dayjs/locale/eu';

export default {
  antdLocale: antd,
  dayjsLocale: dayjs,
  'setting.title': 'Setting',
  'setting.menu.layout': 'Menu Layout',
  'setting.menu.width': 'Menu Width',
  'setting.menu.theme': 'Menu Theme',
  'setting.bread': 'Show Bread',
  'setting.pagetag': 'Show PageTag',
  'setting.footer': 'Show Footer',
  'setting.helpdoc': 'Show Helpdoc',
};
