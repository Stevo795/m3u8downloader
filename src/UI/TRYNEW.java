package UI;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;


public class TRYNEW extends Thread {
//    private Thread t;

    private String threadName;
    private ArrayList<String> DOWNLOAD_URL;
    private File DOWNLOAD_PATH_File;
    private String video_name;
    private int task_per_t;
    private int task_start_index;

    public TRYNEW(String t_name, ArrayList<String> DOWNLOAD_URL, File DOWNLOAD_PATH_File, String video_name, int task_per_t, int task_start_index){



        this.threadName=t_name;
        this.DOWNLOAD_URL=DOWNLOAD_URL;
        this.DOWNLOAD_PATH_File = DOWNLOAD_PATH_File;
        this.video_name = video_name;
        this.task_per_t = task_per_t;
        this.task_start_index = task_start_index;
        System.out.println("creating" + threadName);
        //开启thread


        Thread t = new Thread(this, threadName);


//        SimpleDateFormat Current_date = new SimpleDateFormat("MM-dd_HH"); str + Current_date.format(new Date()).toString()

    }

    @Override
    public void run(){
        System.out.println("running" + threadName);
        for (int i = task_start_index , n = task_start_index+task_per_t; i < n; i ++){
            try{
                //file
                String this_url = DOWNLOAD_URL.get(i);
                String this_video_name = this_url.substring(this_url.lastIndexOf("/")+1);
//                System.out.println("***"+DOWNLOAD_PATH_Thread + this_video_name);

                File VIDEO_FILE = new File(DOWNLOAD_PATH_File.getAbsolutePath()+"\\"+this_video_name);
                //
                //EXCUTE URL DOWNLOADING
                download(DOWNLOAD_URL.get(i), VIDEO_FILE);
                System.out.println("task: " + i + "file: "+this_video_name+" threadname " + threadName);

            }catch (IOException e ){
                System.out.println("Thread : " + threadName + "url retrive failed"+"\n"+DOWNLOAD_URL.get(i));
            }
        }
        System.out.println("Thread" + threadName + "exiting");

    }

    //download method
    public static  void download(String url, File destFile) throws IOException {
        String temp_url = url;
        URL videoUrl = new URL(temp_url);


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


