package UI;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class M3U8DOWNLOADER {
    public M3U8DOWNLOADER(String m3u8_url, String DOWNLOAD_PATH) throws IOException, InterruptedException {

//        String m3u8_og ="https://streaming.azure.queensu.ca/ensemble/_definst_/smil:JamesStewartstewartjqueensu.ca/GHOolt_gRUSwDFLssR7F4A.smil/playlist.m3u8";
        ArrayList<String> ts_fregmetns_list = new SECONDLAYER_URL().SECONDLAYER_URL(m3u8_url);

        //下载地址
//        String DOWNLOAD_PATH = "C:\\Users\\STEVO\\Desktop\\java_project\\Blob\\t5\\";
        //thread

        //设置时间格式
        SimpleDateFormat Current_date = new SimpleDateFormat("MMddHHmmSS");
        //下载路径
        String Org_Download_Path = DOWNLOAD_PATH;
        DOWNLOAD_PATH += "\\download"+Current_date.format(new Date());
        File DOWNLOAD_PATH_FILE = new File(DOWNLOAD_PATH);
        if (!DOWNLOAD_PATH_FILE.exists()){
            DOWNLOAD_PATH_FILE.mkdirs();
        }



        List<TRYNEW> Thread_List = new ArrayList<TRYNEW>();



        //
        TRYNEW
                thread1 = null, thread2=null, thread3=null, thread4=null, thread5=null, thread6=null, thread7=null, thread8=null;


        int Thread_num = 4;
        int total_task_num=ts_fregmetns_list.size();
        int task_per_t=total_task_num/Thread_num;
        int task_res = total_task_num % Thread_num;

        //建立线程vector
        Vector<Thread> threadVector = new Vector<Thread>();
        threadVector.add(thread1);
        threadVector.add(thread2);
        threadVector.add(thread3);
        threadVector.add(thread4);
        threadVector.add(thread5);
        threadVector.add(thread6);
        threadVector.add(thread7);
        threadVector.add(thread8);

        //count down latch
//        final CountDownLatch latch1 = new CountDownLatch(4);

        //通用 file task per t
        if (Thread_num == 4) {
            thread1 = new TRYNEW("thread1", (ArrayList) ts_fregmetns_list, DOWNLOAD_PATH_FILE, "thread1", task_per_t, task_per_t * 0);
            thread1.start();


            //
            thread2 = new TRYNEW("thread2", (ArrayList) ts_fregmetns_list, DOWNLOAD_PATH_FILE, "thread2", task_per_t, task_per_t * 1);
            thread2.start();

            //
            thread3 = new TRYNEW("thread3", (ArrayList) ts_fregmetns_list, DOWNLOAD_PATH_FILE, "thread3", task_per_t, task_per_t * 2);
            thread3.start();

            //
            thread4 = new TRYNEW("thread4", (ArrayList) ts_fregmetns_list, DOWNLOAD_PATH_FILE, "thread4", task_per_t + task_res, task_per_t * 3);
            thread4.start();

            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        }




        if (Thread_num == 6) {
            thread1 = new TRYNEW("thread1", (ArrayList) ts_fregmetns_list, DOWNLOAD_PATH_FILE, "thread1", task_per_t, task_per_t * 0);
            thread1.start();
            thread2 = new TRYNEW("thread2", (ArrayList) ts_fregmetns_list, DOWNLOAD_PATH_FILE, "thread1", task_per_t, task_per_t * 1);
            thread2.start();
            thread3 = new TRYNEW("thread3", (ArrayList) ts_fregmetns_list, DOWNLOAD_PATH_FILE, "thread1", task_per_t, task_per_t * 2);
            thread3.start();
            thread4 = new TRYNEW("thread4", (ArrayList) ts_fregmetns_list, DOWNLOAD_PATH_FILE, "thread1", task_per_t , task_per_t * 3);
            thread4.start();
            thread4 = new TRYNEW("thread5", (ArrayList) ts_fregmetns_list, DOWNLOAD_PATH_FILE, "thread1", task_per_t , task_per_t * 4);
            thread4.start();
            thread4 = new TRYNEW("thread6", (ArrayList) ts_fregmetns_list, DOWNLOAD_PATH_FILE, "thread1", task_per_t + task_res, task_per_t * 5);
            thread4.start();
        }



//        for (Thread sub_thread : threadVector){
//            sub_thread.join();
//        }

        String this_video_name = ts_fregmetns_list.get(0);
        this_video_name=this_video_name.substring(this_video_name.lastIndexOf("/")+1,this_video_name.lastIndexOf("."));

        System.out.println("##########\n******线程全部运行完毕！");
        new MERGE_FILE(DOWNLOAD_PATH_FILE, Org_Download_Path, this_video_name);
        System.out.println("##########\n******Merge!!!！");



        System.out.println("******************\nfinished");


//        if(thread1.getState() == Thread.State.TERMINATED){
//            System.out.println("13123");
//
//        }




    }
}
