package com.ner.controller;

import com.ner.utils.Retns;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.InetAddress;

/**
 * @desc 测试文件上传到指定目录
 * @date 2018/5/7
 */
@Controller
@RequestMapping("/file")
public class FileController {

    private static Logger logger = LoggerFactory.getLogger(FileController.class);

    /*
     *  文件上传地址
     */
    @Value("${filePath}")
    private String filePath;

    /**
     * 跳转文件上传页面
     *
     * @return 页面地址
     */
    @GetMapping("/index")
    public String index() {
        return "fileupd";
    }

    /**
     * 获取上传文件并返回可访问地址
     *
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/upload")
    @ResponseBody
    public Retns upload(MultipartFile file) throws Exception {
        //打印文件信息
        logger.info("文件信息：" + file.getName() + "（类型），" +
                file.getOriginalFilename() + "（文件名），" +
                file.getSize() + "（大小，单位b）");
        try {
            //上传文件
            File localFile = new File(filePath, file.getOriginalFilename());
            file.transferTo(localFile);
            //获取本机（服务器）ip地址
            InetAddress address = InetAddress.getLocalHost();
            String hostAddress = address.getHostAddress();

            String fileName = file.getOriginalFilename();
            return Retns.success("上传成功！", hostAddress + "//" + fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return Retns.fail("上传失败！", null);
        }
    }
}
