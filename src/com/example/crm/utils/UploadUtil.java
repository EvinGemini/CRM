package com.example.crm.utils;

import java.util.UUID;

public class UploadUtil {
    /**
     * 得到随机文件名
     * @param uploadFileName
     * @return
     */
    public static String getUuidFileName(String uploadFileName){
        int index = uploadFileName.lastIndexOf(".");
        String extension = uploadFileName.substring(index);
        return UUID.randomUUID().toString().replace("-","") + extension;
    }

    public static String getPath(String uuidFileName) {
        int code1 = uuidFileName.hashCode();
        int d1 = code1 & 0xf;
        int code2 = code1 >> 4;
        int d2 = code2 & 0xf;
        return "/" + d1 + "/" + d2;
    }
}
