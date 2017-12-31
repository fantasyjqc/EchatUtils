package application.controller.Utils;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtils {

    public static void addUTF8BOM(HttpServletResponse response) throws Exception{
        response.getOutputStream().write(new   byte []{( byte ) 0xEF ,( byte ) 0xBB ,( byte ) 0xBF });
    }

}
