package UI;

import java.io.*;
import java.util.ArrayList;

public class MERGE_FILE {
    public MERGE_FILE(File DOWNLOAD_PATH_INPUT, String Org_Download_Path, String this_video_name1) throws IOException, InterruptedException {

        File video_file = new File(Org_Download_Path+"\\this_time1.ts");
        BufferedInputStream bf_input_stream;
        BufferedOutputStream bf_output_stream = new BufferedOutputStream(new FileOutputStream(video_file.getAbsolutePath()));
//
        File[] files = DOWNLOAD_PATH_INPUT.listFiles();

        //找到video名字
        String this_video_name=files[0].getCanonicalPath();
        this_video_name=this_video_name.substring(0, this_video_name.lastIndexOf(".")-1);

        int num_file = files.length;
        for (int i = 0;i<num_file;i++){

//            if (file.getName().endsWith(".ts")){}
            try{
                bf_input_stream = new BufferedInputStream(new FileInputStream(this_video_name+i+".ts"));
                byte[] byte_list = new byte[1024];
                int len;
                while((len=bf_input_stream.read(byte_list))!=-1){
                    bf_output_stream.write(byte_list, 0, len);
                    bf_output_stream.flush();
                }
                bf_input_stream.close();

            }catch(IOException e){
                throw new RuntimeException("io error");
            }

        }
//        删除folder
        bf_output_stream.close();
//        bf_input_stream.close();

        delete_file(DOWNLOAD_PATH_INPUT);
    }
    public void delete_file(File FILE){
        File[] files = FILE.listFiles();
        for (File file:files){
            if (file.isDirectory()){
                delete_file(file);
            }else{
                System.out.println("del "+file.getName());
                file.delete();
            }
        }
        FILE.delete();

    }

}
