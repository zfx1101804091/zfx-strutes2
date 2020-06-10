package com.zfx.demo.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;

/**
 * @description:  操作
 * @author: zheng-fx
 * @time: 2020/6/4 0004 21:49
 */
public class FileAction extends ActionSupport {
    /*主要是struts2 文件上传需要这3个属性*/
    private File upload;
    private String uploadContentType;
    private String uploadFileName;
    
    private String result;

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String execute() throws Exception {

        String path = ServletActionContext.getServletContext().getRealPath("/images");
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        FileUtils.copyFile(upload,new File(file,uploadFileName));
        
        result="上传成功";
        return SUCCESS;
    }
}
