package org.person.sa.admin.module.business.oa.notice.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 通知公告类型
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-08-12 21:40:39
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Data
@TableName("t_notice_type")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeTypeEntity {

    @TableId(type = IdType.AUTO)
    private Long noticeTypeId;

    /**
     * 名称
     */
    private String noticeTypeName;


    private LocalDateTime updateTime;

    private LocalDateTime createTime;
}
