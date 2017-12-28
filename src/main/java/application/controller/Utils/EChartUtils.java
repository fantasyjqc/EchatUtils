package application.controller.Utils;

import com.github.abel533.echarts.series.MarkLine;
import com.github.abel533.echarts.series.MarkPoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EChartUtils {

    public static MarkPoint makeMarkPointMaxAndMin(){
        MarkPoint markPoint = new MarkPoint();
        List<Map> data = new ArrayList<Map>();
        Map data_1 = new HashMap();
        data_1.put("type","max");
        data_1.put("name","最大值");
        Map data_2 = new HashMap();
        data_2.put("type","min");
        data_2.put("name","最小值");
        data.add(data_1);
        data.add(data_2);
        markPoint.setData(data);
        return markPoint;
    }

    public static MarkLine makeMarkLineAverage(){
        MarkLine markLine = new MarkLine();
        List<Map> data = new ArrayList<Map>();
        Map data_1 = new HashMap();
        data_1.put("type","average");
        data_1.put("name","平均值");
        data.add(data_1);
        markLine.setData(data);
        return markLine;
    }

    public static MarkLine makeMarkLineMax(){
        MarkLine markLine = new MarkLine();
        List<Object> data = new ArrayList<Object>();
        List<Map> data_1 = new ArrayList<Map>();
        Map data_1_1 = new HashMap();
        data_1_1.put("symbol","none");
        data_1_1.put("x","90%");
        data_1_1.put("yAxis","max");
        Map data_1_2 = new HashMap();
        data_1_2.put("symbol","circle");
        data_1_2.put("type","max");
        data_1_2.put("name","最高点");
        Map data_1_2_1 = new HashMap();
        Map data_1_2_1_1 = new HashMap();
        data_1_2_1_1.put("position","start");
        data_1_2_1_1.put("formatter","最大值");
        data_1_2_1.put("normal",data_1_2_1_1);
        data_1_2.put("label",data_1_2_1);
        data_1.add(data_1_1);
        data_1.add(data_1_2);
        data.add(data_1);
        markLine.setData(data);
        return markLine;
    }

    public static MarkLine makeMarkLineMaxLineAndAverage(){
        MarkLine markLine = new MarkLine();
        List<Object> data = new ArrayList<Object>();
        List<Map> data_1 = new ArrayList<Map>();
        Map data_1_1 = new HashMap();
        data_1_1.put("symbol","none");
        data_1_1.put("x","90%");
        data_1_1.put("yAxis","max");
        Map data_1_2 = new HashMap();
        data_1_2.put("symbol","circle");
        data_1_2.put("type","max");
        data_1_2.put("name","最高点");
        Map data_1_2_1 = new HashMap();
        Map data_1_2_1_1 = new HashMap();
        data_1_2_1_1.put("position","start");
        data_1_2_1_1.put("formatter","最大值");
        data_1_2_1.put("normal",data_1_2_1_1);
        data_1_2.put("label",data_1_2_1);
        data_1.add(data_1_1);
        data_1.add(data_1_2);
        Map data_2 = new HashMap();
        data_2.put("type","average");
        data_2.put("name","平均值");
        data.add(data_1);
        data.add(data_2);
        markLine.setData(data);
        return markLine;
    }

}
