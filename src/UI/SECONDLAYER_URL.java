package UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class SECONDLAYER_URL {

    private static String getStream_String(String ts_list_url) throws IOException {
        URL url1 = new URL(ts_list_url);
        InputStream input = url1.openStream();   // 打开输入流
        InputStreamReader inputreader = new InputStreamReader(input, "UTF-8");
        BufferedReader bfr = new BufferedReader(inputreader);
//        String text = IOUtils.toString(input);
        String results = "";
        String newLine = "";
        ArrayList<String> res_list = new ArrayList<>();
        while ((newLine = bfr.readLine()) != null) {
            results += newLine + "\n";
//            res_list.add(newLine);
            //判断 stream inf
        }
//        System.out.println(results);
        return results;
    }

    private static ArrayList<String> Get_ts_fregments(String SecondLayerRes, String base_url){
        //check
        //pass
        //array
        ArrayList<String> ts_fregment_list = new ArrayList<String>();

//        String m3u8_pos = ".m3u8";

        String[] res_segment = SecondLayerRes.split("\n");

        for (int i =0, n = res_segment.length; i<n; i++){
            if (res_segment[i].contains("EXTINF")){
//                    System.out.println(res_segment[i]);
                ts_fregment_list.add(base_url+res_segment[i+1]);
            }
        }

        return ts_fregment_list;
    }

    public ArrayList<String> SECONDLAYER_URL(String m3u8) throws IOException{
//        String m3u8 = "https://streaming.azure.queensu.ca/ensemble/_definst_/smil:JamesStewartstewartjqueensu.ca/GHOolt_gRUSwDFLssR7F4A.smil/chunklist_w142500334_b834088.m3u8";
//        String m3u8 ="https://streaming.azure.queensu.ca/ensemble/_definst_/smil:JamesStewartstewartjqueensu.ca/GHOolt_gRUSwDFLssR7F4A.smil/playlist.m3u8";

//        FIRSTLAYER_URL  URL = new FIRSTLAYER_URL();
//        System.out.println(URL.FIRSTLAYER_URL(m3u8));
        String secondlayer_url = new FIRSTLAYER_URL().FIRSTLAYER_URL(m3u8);
        String base_url = secondlayer_url.substring(0, secondlayer_url.lastIndexOf("/"))+"/";

        //this
        String secondlayer_res=getStream_String(secondlayer_url);

        ArrayList<String> ts_fregment_lsit = Get_ts_fregments( secondlayer_res, base_url);

//        System.out.println( ts_fregment_lsit);
        return ts_fregment_lsit;

    }
}
