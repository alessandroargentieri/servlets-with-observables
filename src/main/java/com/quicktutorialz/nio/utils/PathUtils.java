package com.quicktutorialz.nio.utils;

import java.util.HashMap;
import java.util.Map;

public class PathUtils {

    public static Map<String, String> getPathVariables(String endpointPath, String requestPath){

        Map<String, String> pathVariables = new HashMap<>();

        if(!requestPath.startsWith("/")) requestPath = "/"+requestPath;
        if(!endpointPath.startsWith("/")) endpointPath = "/"+endpointPath;

        if(requestPath.endsWith("/")) requestPath = requestPath.substring(0, requestPath.length()-1);
        if(endpointPath.endsWith("/")) endpointPath = endpointPath.substring(0, endpointPath.length()-1);

        String[] split1 = requestPath.split("/");
        String[] split2 = endpointPath.split("/");

        for(int i=0; i<split1.length; i++){
            String chunck1 = split1[i];
            String chunck2 = split2[i];

            if(!chunck1.equals(chunck2)){
                if(chunck2.startsWith("{") && chunck2.endsWith("}")) {
                    String paramName = chunck2.replaceAll("\\{","")
                            .replaceAll("\\}","")
                            .replaceAll(" ", "");
                    pathVariables.put(paramName, chunck1);
                }
            }
        }
        return pathVariables;
    }
}
