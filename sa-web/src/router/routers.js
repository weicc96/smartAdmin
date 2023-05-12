/*
 * 所有路由入口
 *
 * @Author:    weicc
 * @Date:      2022-09-06 20:52:26
 * @Wechat:    wcchen96
 * @Email:     15793730318@163.com
 */
import { homeRouters } from './system/home';
import { loginRouters } from './system/login';
import { helpDocRouters } from './support/help-doc';

export const routerArray = [...loginRouters, ...homeRouters, ...helpDocRouters];
