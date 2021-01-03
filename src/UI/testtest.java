package UI;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testtest {

    public static void main(String[] args) throws IOException, InterruptedException {
//        String url1="https://streaming.azure.queensu.ca/ensemble/_definst_/smil:JamesStewartstewartjqueensu.ca/8L9Ai4nvH0-4l1E7ANbseQ.smil/media_w1291059718_b834088_0.ts";
//        String DOWNLOAD_PATH = "C:\\Users\\STEVO\\Desktop\\java_project\\Blob\\";
//        String vedioname = "test download";
////        File down_file = new File(DOWNLOAD_PATH + vedioname+".ts");
//        File down_file = new File("C:\\Users\\STEVO\\Desktop\\download\\testtest.ts");


        SimpleDateFormat Current_date = new SimpleDateFormat("MMddHHmmSS");

        String url1 = "https://streaming.azure.queensu.ca/ensemble/_definst_/smil:JamesStewartstewartjqueensu.ca/GHOolt_gRUSwDFLssR7F4A.smil/media_w247243001_b4298136_76.ts";
        System.out.println(url1.lastIndexOf("/")+"---"+url1.substring(url1.lastIndexOf("/")+1));
        System.out.println(url1.charAt(url1.lastIndexOf("/"))+"==="+url1.charAt(1));
        String download_file = "C:\\Users\\STEVO\\Desktop\\download\\" + "download_"+Current_date.format(new Date());
        File DOWNLOAD_FILE = new File(download_file);
        if (!DOWNLOAD_FILE.exists()){
            DOWNLOAD_FILE.mkdirs();
        }
        String video_name = "media_w247243001_b4298136_76.ts";
        File VIDEO_FILE = new File(DOWNLOAD_FILE.getAbsolutePath()+"\\"+video_name);


        System.out.println(DOWNLOAD_FILE.getAbsolutePath()+video_name);
//        if (!down_file.exists()){
//            Process cmd_process = Runtime.getRuntime().exec("cmd.exe /C C: && mkdir "+F);
//            cmd_process.waitFor();
//            cmd_process.exitValue();
//        }
        System.out.println("333333333");




        download(url1, VIDEO_FILE);
    }

    public static void download(String url, File destFile) throws IOException {
        URL videoUrl = new URL(url);

        InputStream is = videoUrl.openStream();
        FileOutputStream fos = new FileOutputStream(destFile);

        int len = 0;
        byte[] buffer = new byte[1024];
        while ((-1) != (len = is.read(buffer))) {
            fos.write(buffer, 0, len);
        }
        fos.flush();

        if (null != fos) {
            fos.close();
        }

        if (null != is) {
            is.close();
        }
    }
}
