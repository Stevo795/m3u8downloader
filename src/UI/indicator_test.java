package UI;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class indicator_test {
    public static void main(String[] args) throws InterruptedException, IOException {
//        Vector<Thread> threadVector = new Vector<Thread>();
//        for (int i = 0; i < 5; i++) {
//            Thread childt = new Thread(new Runnable() {
//                @Override
//                public void run(){
//                    try {
//                        for (int j = 0; j<30; j++){
//                            Thread.sleep(1000);
//                            System.out.println("this is "+j);
//
//                        }
//                    }catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                    System.out.println("sub thread");
//                }
//
//            });
//            threadVector.add(childt);
//            childt.start();
//        }
//        for (Thread thread :  threadVector){
//            thread.join();
//        }
//        System.out.println("main process");
        File DOWNLOAD_PATH_INPUT = new File("C:\\Users\\STEVO\\Desktop\\download09172106252");
        File video_file = new File("C:\\Users\\STEVO\\Desktop\\this3.ts");
        BufferedInputStream bf_input_stream;
        BufferedOutputStream bf_output_stream = new BufferedOutputStream(new FileOutputStream(video_file.getCanonicalPath()));
//
        File[] files = DOWNLOAD_PATH_INPUT.listFiles();


        String this_video_name = DOWNLOAD_PATH_INPUT.listFiles()[0].getCanonicalPath();
//        this_video_name.lastIndexOf("\\")+1
        this_video_name=this_video_name.substring(0, this_video_name.lastIndexOf(".")-1);

        //末尾数字
        ArrayList l1=new ArrayList();
        Pattern pt = Pattern.compile("[0-9]+(^0-9)*$");
        for (File file : files){
            String filename=file.getName().substring(0, file.getName().length()-3);
            Matcher mt = pt.matcher(filename);
            while(mt.find()){
//                System.out.println(mt.group());
                l1.add(mt.group());
            }
            System.out.println(l1.get(l1.size()-1));
//            System.out.println(pattern.matcher(filename).find());
        }
        System.out.println(l1);

//        for(int i = 0 ; i< files.length; i++){
//            System.out.println(files[i].getName());
//        }

//        for (File file : files) {
////
////            try {
////
////                String filename=file.getCanonicalPath().substring(0, file.getName().length()-3);
////                Matcher mt = pt.matcher(filename);
////                while(mt.find()){
//////                System.out.println(mt.group());
////                    l1.add(mt.group());
////                }
////                System.out.println(l1.get(l1.size()-1));
////
////
////
////
////                bf_input_stream = new BufferedInputStream(new FileInputStream(this_video_name+x+".ts"));
////                System.out.println("processing "+this_video_name+x);
////                byte[] by = new byte[1024];
////                int len;
////                while((len=bf_input_stream.read(by))!=-1)
////                {
////                    bf_output_stream.write(by,0,len);
////                    bf_output_stream.flush();
////                }
////            } catch (FileNotFoundException e) {
////                throw new RuntimeException("第"+x+"次循环未找到文件");
////            } catch (IOException e) {
////                throw new RuntimeException("第"+x+"次循环IO流异常");
////            }
////        }
////
////
    }
}