package me.justgame.fileupload.action;

import com.alibaba.fastjson.JSONObject;
import me.justgame.dao.AllDao;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xcl on 2017-03-03.
 */
@Controller
public class UploadFileAct {
    @Resource
    AllDao dao;

    @RequestMapping("/uploadPage.do")
    public String uploadPage() throws Exception {
        System.out.println("...");
        return "fileupload/upload";
    }

    @RequestMapping("/kindeditor.do")
    public ModelAndView kindeditor(String content) throws Exception {
        ModelAndView modelAndView = new ModelAndView("fileupload/upload");
        dao.addKindeditor(content);
        List<String> list = dao.getAllKindeditor();
        String result = list.get(list.size() - 1);
        modelAndView.addObject("result", result);

        return modelAndView;
    }

    @RequestMapping("/springUpload.do")
    public @ResponseBody void springUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long startTime = System.currentTimeMillis();
        PrintWriter out = response.getWriter();


        // 文件保存目录路径
        String savePath = request.getServletContext().getRealPath("/") + "attached/";
        //文件保存目录URL
        String saveUrl  = request.getContextPath() + "/attached/";
        System.out.println(savePath);
        System.out.println(saveUrl);

        //创建文件夹
        File saveDirFile = new File(savePath);
        if (!saveDirFile.exists()) {
            saveDirFile.mkdirs();
        }

        //定义允许上传的文件扩展名
        HashMap<String, String> extMap = new HashMap<>();
        extMap.put("image", "gif,jpg,jpeg,png,bmp");
        extMap.put("flash", "swf,flv");
        extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
        extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

        response.setContentType("text/html; charset=UTF-8");

        if(!ServletFileUpload.isMultipartContent(request)){
            JSONObject obj = new JSONObject();
            obj.put("error", 1);
            obj.put("message", "请选择文件。");
            out.print(obj.toString());
            return;
        }
        //检查目录
        File uploadDir = new File(savePath);
        if(!uploadDir.isDirectory()){
            JSONObject obj = new JSONObject();
            obj.put("error", 1);
            obj.put("message", "上传目录不存在。");
            out.print(obj.toString());
            return;
        }
        //检查目录写权限
        if(!uploadDir.canWrite()){
            JSONObject obj = new JSONObject();
            obj.put("error", 1);
            obj.put("message", "上传目录没有写权限。");
            out.print(obj.toString());
            return;
        }

        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();

            while (iter.hasNext()) {

                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                if (file != null) {
                    String name = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf("."));
                    String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                    String path = name + "_" + System.currentTimeMillis() + suffix;
                    //上传
                    file.transferTo(new File(savePath + path));
                    saveUrl += path;
                }

            }

        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法三的运行时间：" + String.valueOf(endTime - startTime) + "ms");

        JSONObject obj = new JSONObject();
        obj.put("error", 0);
        obj.put("url", saveUrl);
        out.println(obj.toString());
    }

}
