package com.zfx.demo.action;

import com.zfx.demo.result.AjaxResult;
import com.zfx.demo.result.CommonResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: zheng-fx
 * @time: 2020/6/10 0010 23:52
 */
public class File2Action {
    
    private File file;

    public void setFile(File file) {
        this.file = file;
    }

    public String savePersonalInfo() throws FileNotFoundException {

        FileInputStream stream = new FileInputStream(file);

        Map<String, Object> result  = new HashMap<String, Object>();
        if(file!=null){
            result.put("code", 200);
            result.put("msg", "success");
            result.put("error", "没有错误信息");
        }
        
        return  AjaxResult.ajax(result);
    }
}
