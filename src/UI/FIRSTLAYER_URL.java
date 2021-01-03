package UI;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class FIRSTLAYER_URL {




    private String getStream_String(String m3u8) throws IOException {
        URL url1 = new URL(m3u8);
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
        System.out.println(results);
        return results;
    }
    private String Check_M3u8(String FirstLayerRes){
        //check
        Boolean Contain_EXTM3U = FirstLayerRes.contains("#EXTM3U");
        Boolean Stream_inf = FirstLayerRes.contains("EXT-X-STREAM-INF");
//        String m3u8_pos = ".m3u8";
        if(Contain_EXTM3U & Stream_inf){
            String[] res_segment = FirstLayerRes.split("\n");
            for (int i =0, n = res_segment.length; i<n; i++){
                if (res_segment[i].contains(".m3u8")){
//                    System.out.println(res_segment[i]);
                    //
                    return res_segment[i];
                }
            }
        }else{
//            throw new IllegalArgumentException("无效链接");
            return null;
        }
        return null;
    }

    public String FIRSTLAYER_URL(String m3u8) throws IOException {
//        String m3u8 = "https://streaming.azure.queensu.ca/ensemble/_definst_/smil:JamesStewartstewartjqueensu.ca/GHOolt_gRUSwDFLssR7F4A.smil/playlist.m3u8";

//        TEXTTEST res = new TEXTTEST();
        String FirstLayerRes = getStream_String(m3u8);
//        System.out.println(FirstLayerRes.lines());
        String m3u8_link = Check_M3u8(FirstLayerRes);

        String base_link = m3u8.substring(0, m3u8.lastIndexOf("/")) ;

        System.out.println(base_link+"/"+m3u8_link);
        return base_link+"/"+m3u8_link;
    }
}
