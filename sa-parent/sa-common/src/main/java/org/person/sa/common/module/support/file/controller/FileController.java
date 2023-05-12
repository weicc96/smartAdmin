package org.person.sa.common.module.support.file.controller;

import cn.hutool.extra.servlet.ServletUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.person.sa.common.common.constant.RequestHeaderConst;
import org.person.sa.common.common.controller.SupportBaseController;
import org.person.sa.common.common.domain.RequestUser;
import org.person.sa.common.common.domain.ResponseDTO;
import org.person.sa.common.common.util.SmartRequestUtil;
import org.person.sa.common.constant.SwaggerTagConst;
import org.person.sa.common.module.support.file.constant.FileFolderTypeEnum;
import org.person.sa.common.module.support.file.domain.form.FileUrlUploadForm;
import org.person.sa.common.module.support.file.domain.vo.FileUploadVO;
import org.person.sa.common.module.support.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 文件服务
 *
 * @Author 1024创新实验室: 罗伊
 * @Date 2019年10月11日 15:34:47
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@RestController
@Api(tags = {SwaggerTagConst.Support.FILE})
public class FileController extends SupportBaseController {

    @Autowired
    private FileService fileService;


    @ApiOperation(value = "文件上传 @author 胡克", notes = FileFolderTypeEnum.INFO)
    @PostMapping("/file/upload")
    public ResponseDTO<FileUploadVO> upload(@RequestParam MultipartFile file,
                                            @RequestParam Integer folder) {
        RequestUser requestUser = SmartRequestUtil.getRequestUser();
        return fileService.fileUpload(file, folder, requestUser);
    }

    @ApiOperation(value = "文件上传，通过url上传 @author 胡克", notes = FileFolderTypeEnum.INFO)
    @PostMapping("/file/upload/url")
    public ResponseDTO<FileUploadVO> uploadByUrl(@RequestBody @Valid FileUrlUploadForm uploadForm) {
        RequestUser requestUser = SmartRequestUtil.getRequestUser();
        return fileService.fileUpload(uploadForm,requestUser);
    }

    @ApiOperation("获取文件URL：根据fileKey @author 胡克")
    @GetMapping("/file/getFileUrl")
    public ResponseDTO<String> getUrl(@RequestParam String fileKey) {
        return fileService.getFileUrl(fileKey);
    }

    @ApiOperation(value = "下载文件流（根据fileKey） @author 胡克")
    @GetMapping("/file/downLoad")
    public ResponseEntity<Object> downLoad(@RequestParam String fileKey, HttpServletRequest request) {
        String userAgent = ServletUtil.getHeaderIgnoreCase(request, RequestHeaderConst.USER_AGENT);
        return fileService.downloadByFileKey(fileKey, userAgent);
    }
}
