package org.person.sa.admin.module.business.oa.notice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import org.person.sa.admin.module.business.oa.notice.constant.NoticeVisibleRangeDataTypeEnum;
import org.person.sa.admin.module.business.oa.notice.dao.NoticeDao;
import org.person.sa.admin.module.business.oa.notice.domain.form.NoticeEmployeeQueryForm;
import org.person.sa.admin.module.business.oa.notice.domain.form.NoticeViewRecordQueryForm;
import org.person.sa.admin.module.business.oa.notice.domain.vo.*;
import org.person.sa.admin.module.system.department.service.DepartmentService;
import org.person.sa.admin.module.system.employee.domain.entity.EmployeeEntity;
import org.person.sa.admin.module.system.employee.service.EmployeeService;
import org.person.sa.common.common.domain.PageResult;
import org.person.sa.common.common.domain.ResponseDTO;
import org.person.sa.common.common.util.SmartBeanUtil;
import org.person.sa.common.common.util.SmartPageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * 员工查看 通知。公告
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-08-12 21:40:39
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Service
public class NoticeEmployeeService {

    @Autowired
    private NoticeDao noticeDao;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    /**
     * 查询我的 通知、公告清单
     *
     * @return
     */
    public ResponseDTO<PageResult<NoticeEmployeeVO>> queryList(Long requestEmployeeId, NoticeEmployeeQueryForm noticeEmployeeQueryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(noticeEmployeeQueryForm);

        //获取请求人的 部门及其子部门
        List<Long> employeeDepartmentIdList = Lists.newArrayList();
        EmployeeEntity employeeEntity = employeeService.getById(requestEmployeeId);
        if (employeeEntity.getDepartmentId() != null) {
            employeeDepartmentIdList = departmentService.selfAndChildrenIdList(employeeEntity.getDepartmentId());
        }

        List<NoticeEmployeeVO> noticeList = null;
        //只查询未读的
        if (noticeEmployeeQueryForm.getNotViewFlag() != null && noticeEmployeeQueryForm.getNotViewFlag()) {
            noticeList = noticeDao.queryEmployeeNotViewNotice(page,
                    requestEmployeeId,
                    noticeEmployeeQueryForm,
                    employeeDepartmentIdList,
                    false,
                    employeeEntity.getAdministratorFlag(),
                    NoticeVisibleRangeDataTypeEnum.DEPARTMENT.getValue(),
                    NoticeVisibleRangeDataTypeEnum.EMPLOYEE.getValue());
        } else {
            // 查询全部
            noticeList = noticeDao.queryEmployeeNotice(page,
                    requestEmployeeId,
                    noticeEmployeeQueryForm,
                    employeeDepartmentIdList,
                    false,
                    employeeEntity.getAdministratorFlag(),
                    NoticeVisibleRangeDataTypeEnum.DEPARTMENT.getValue(),
                    NoticeVisibleRangeDataTypeEnum.EMPLOYEE.getValue());
        }
        // 设置发布日期
        noticeList.forEach(notice -> notice.setPublishDate(notice.getPublishTime().toLocalDate()));

        return ResponseDTO.ok(SmartPageUtil.convert2PageResult(page, noticeList));
    }


    /**
     * 查询我的 待查看的 通知、公告清单
     *
     * @return
     */
    public ResponseDTO<NoticeDetailVO> view(Long requestEmployeeId, Long noticeId, String ip, String userAgent) {
        NoticeUpdateFormVO updateFormVO = noticeService.getUpdateFormVO(noticeId);
        if (updateFormVO == null || Boolean.TRUE.equals(updateFormVO.getDeletedFlag())) {
            return ResponseDTO.userErrorParam("通知公告不存在");
        }

        EmployeeEntity employeeEntity = employeeService.getById(requestEmployeeId);
        if (!updateFormVO.getAllVisibleFlag() && !checkVisibleRange(updateFormVO.getVisibleRangeList(), requestEmployeeId, employeeEntity.getDepartmentId())) {
            return ResponseDTO.userErrorParam("对不起，您没有权限查看内容");
        }

        NoticeDetailVO noticeDetailVO = SmartBeanUtil.copy(updateFormVO, NoticeDetailVO.class);
        long viewCount = noticeDao.viewRecordCount(noticeId, requestEmployeeId);
        if (viewCount == 0) {
            noticeDao.insertViewRecord(noticeId, requestEmployeeId, ip, userAgent, 1);
        } else {
            noticeDao.updateViewRecord(noticeId, requestEmployeeId, ip, userAgent);
        }

        return ResponseDTO.ok(noticeDetailVO);
    }

    /**
     * 校验是否有查看权限的范围
     *
     * @param visibleRangeList
     * @param employeeId
     * @param departmentId
     * @return
     */
    public boolean checkVisibleRange(List<NoticeVisibleRangeVO> visibleRangeList, Long employeeId, Long departmentId) {
        // 员工范围
        boolean anyMatch = visibleRangeList.stream().anyMatch(e -> NoticeVisibleRangeDataTypeEnum.EMPLOYEE.equalsValue(e.getDataType()) && Objects.equals(e.getDataId(), employeeId));
        if (anyMatch) {
            return true;
        }

        //部门范围
        List<Long> visibleDepartmentIdList = visibleRangeList.stream().filter(e -> NoticeVisibleRangeDataTypeEnum.DEPARTMENT.equalsValue(e.getDataType()))
                .map(NoticeVisibleRangeVO::getDataId).collect(Collectors.toList());

        for (Long visibleDepartmentId : visibleDepartmentIdList) {
            List<Long> departmentIdList = departmentService.selfAndChildrenIdList(visibleDepartmentId);
            if (departmentIdList.contains(departmentId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 分页查询  查看记录
     *
     * @param noticeViewRecordQueryForm
     * @return
     */
    public PageResult<NoticeViewRecordVO> queryViewRecord(NoticeViewRecordQueryForm noticeViewRecordQueryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(noticeViewRecordQueryForm);
        List<NoticeViewRecordVO> noticeViewRecordVOS = noticeDao.queryNoticeViewRecordList(page, noticeViewRecordQueryForm);
        return SmartPageUtil.convert2PageResult(page, noticeViewRecordVOS);
    }
}
