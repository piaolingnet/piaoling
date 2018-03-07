package com.piaoling.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.channels.FileChannel;
import java.util.*;

/**
 * 分片上传和mvc上传
 * Created by Mr-Wang on 2017/9/10.
 */
@Controller
@RequestMapping("/file")
public class UploadVideo {

    /**
     * 跳转到mvc文件上传页面
     * @return
     */
    @RequestMapping("/toMvcUpload")
    public ModelAndView toMvcUpload(){
        ModelAndView modelAndView = new ModelAndView("webUploadFile");
        return modelAndView;
    }

    /**
     * 跳转到分片上传页面
     * @param request
     * @return
     */
    @RequestMapping("/getTest")
    @ResponseBody
    public ModelAndView getTest(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("testFile");
        return modelAndView;
    }
    /**
     * mvc多部分解析器上传
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/mvcUpload")
    @ResponseBody
    public ActionResult mvcUpload(HttpServletRequest request,HttpServletResponse response)  {
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        String savePath = request.getSession().getServletContext().getRealPath("/");
        String folad = "uploads";
        savePath = savePath + "\\"+folad+"\\";
        //判断 request 是否有文件上传,即多部分请求
        try {
            if(multipartResolver.isMultipart(request)){
                //转换成多部分request
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
                //取得request中的所有文件名
                Iterator<String> iter = multiRequest.getFileNames();
                while(iter.hasNext()){
                    //记录上传过程起始时的时间，用来计算上传时间
                    int pre = (int) System.currentTimeMillis();
                    //取得上传文件
                    MultipartFile file = multiRequest.getFile(iter.next());
                    if(file != null){
                        //取得当前上传文件的文件名称
                        String myFileName = file.getOriginalFilename();
                        //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                        if(myFileName.trim() !=""){
                            System.out.println(myFileName);
                            //重命名上传后的文件名
                            String fileName = "demoUpload" + file.getOriginalFilename();
                            //定义上传路径
                            String path =savePath +"/"+ fileName;
                            File localFile = new File(savePath);
                            if(!localFile.exists()){
                                localFile.mkdir();
                            }
                            File files = new File(path);
                            file.transferTo(files);
                        }
                    }
                    //记录上传该文件后的时间
                    int finaltime = (int) System.currentTimeMillis();
                    System.out.println("上传时间："+(finaltime - pre)+"ms");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ActionResult.New(1,"");
    }

    /**
     * fileUpload上传文件
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/uploadVideo")
    @ResponseBody
    public ActionResult UploadVideo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);
        sfu.setHeaderEncoding("utf-8");

        String savePath = request.getSession().getServletContext().getRealPath("/");
        String folad = "uploads";
        savePath = savePath + "\\"+folad+"\\";

        String fileMd5 = null;
        String chunk = null;

        try {
            List<FileItem> items = sfu.parseRequest(request);

            for(FileItem item:items){
                if(item.isFormField()){
                    String fieldName = item.getFieldName();
                    if(fieldName.equals("fileMd5")){
                        fileMd5 = item.getString("utf-8");
                    }
                    if(fieldName.equals("chunk")){
                        chunk = item.getString("utf-8");
                    }
                }else{
                    File file = new File(savePath+"/"+fileMd5);
                    if(!file.exists()){
                        file.mkdir();
                    }
                    File chunkFile = new File(savePath+"/"+fileMd5+"/"+chunk);
                    FileUtils.copyInputStreamToFile(item.getInputStream(), chunkFile);

                }
            }

        } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ActionResult.New(1,"");
    }

    /**
     * 分块上传
     * @param request
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/testVideo")
    @ResponseBody
    public ActionResult testVideo(HttpServletRequest request)
            throws ServletException, IOException {
        String savePath = request.getSession().getServletContext().getRealPath("/");
        String folad = "uploads";
        savePath = savePath + "\\"+folad+"\\";

        String action = request.getParameter("action");
        JSONObject jsonObject = new JSONObject();
        if(action.equals("mergeChunks")){
            //合并文件
            //需要合并的文件的目录标记
            String fileMd5 = request.getParameter("fileMd5");

            //读取目录里的所有文件
            File f = new File(savePath+"/"+fileMd5);
            File[] fileArray = f.listFiles(new FileFilter(){
                //排除目录只要文件
                @Override
                public boolean accept(File pathname) {
                    // TODO Auto-generated method stub
                    if(pathname.isDirectory()){
                        return false;
                    }
                    return true;
                }
            });

            //转成集合，便于排序
            List<File> fileList = new ArrayList<File>(Arrays.asList(fileArray));
            Collections.sort(fileList,new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    // TODO Auto-generated method stub
                    if(Integer.parseInt(o1.getName()) < Integer.parseInt(o2.getName())){
                        return -1;
                    }
                    return 1;
                }
            });
            //UUID.randomUUID().toString()-->随机名
            File outputFile = new File(savePath+"/"+fileMd5+".mp4");
            //创建文件
            outputFile.createNewFile();
            //输出流
            FileChannel outChnnel = new FileOutputStream(outputFile).getChannel();
            //合并
            FileChannel inChannel;
            for(File file : fileList){
                inChannel = new FileInputStream(file).getChannel();
                inChannel.transferTo(0, inChannel.size(), outChnnel);
                inChannel.close();
                //删除分片
                file.delete();
            }
            outChnnel.close();
            //清除文件夹
            File tempFile = new File(savePath+"/"+fileMd5);
            if(tempFile.isDirectory() && tempFile.exists()){
                tempFile.delete();
            }
            System.out.println("合并成功");
        }else if(action.equals("checkChunk")){
            //检查当前分块是否上传成功
            String fileMd5 = request.getParameter("fileMd5");
            String chunk = request.getParameter("chunk");
            String chunkSize = request.getParameter("chunkSize");

            File checkFile = new File(savePath+"/"+fileMd5+"/"+chunk);

            //response.setContentType("text/html;charset=utf-8");

            //检查文件是否存在，且大小是否一致
            if(checkFile.exists() && checkFile.length()==Integer.parseInt(chunkSize)){
                //上传过
                jsonObject.put("ifExist",1);
                //response.getWriter().write("{\"ifExist\":1}");
            }else{
                //没有上传过
                jsonObject.put("ifExist",0);
                //response.getWriter().write("{\"ifExist\":0}");
            }
        }
        return ActionResult.New(jsonObject);
    }
}
