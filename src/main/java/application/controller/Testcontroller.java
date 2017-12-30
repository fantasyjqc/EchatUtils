package application.controller;

import application.controller.Dto.Mapper.DssInStoreMapper;
import application.controller.Dto.Po.DssInStorePO;
import application.controller.Utils.EChartUtils;
import application.controller.Utils.ExcelUtils;
import com.github.abel533.echarts.*;
import com.github.abel533.echarts.DataZoom;
import com.github.abel533.echarts.axis.AxisLabel;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.*;
import com.github.abel533.echarts.feature.*;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Line;
import com.google.gson.Gson;
import com.xuxueli.poi.excel.ExcelExportUtil;
import jxl.write.WritableWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class Testcontroller {

    @Autowired
    DssInStoreMapper dssInStoreMapper;

    @RequestMapping(value = "/greeting")
    public String test1(){
        return "greeting";
    }

    @RequestMapping(value = "/greeting22")
    @ResponseBody
    public String test() {
        GsonOption option = new GsonOption();

        option.title("未来一周气温变化","纯属虚构").tooltip(Trigger.axis);
        Legend legend = new Legend();
        List<String> legend_data = new ArrayList<String>();
        legend_data.add("最高气温");
        legend_data.add("最低气温");
        DataZoom dataZoom = new DataZoom();
        dataZoom.setyAxisIndex("none");
        option.legend(legend_data).toolbox().show(true).feature(dataZoom,Tool.dataView, Tool.mark, new MagicType(Magic.line,Magic.bar), Tool.restore, Tool.saveAsImage);

        ValueAxis valueAxis = new ValueAxis();
        valueAxis.setType(AxisType.category);
        valueAxis.setBoundaryGap(false);
        List<String> valueAxis_data = new ArrayList<String>();
        valueAxis_data.add("周一");
        valueAxis_data.add("周二");
        valueAxis_data.add("周三");
        valueAxis_data.add("周四");
        valueAxis_data.add("周五");
        valueAxis_data.add("周六");
        valueAxis_data.add("周日");
        valueAxis.setData(valueAxis_data);
        option.xAxis(valueAxis);

        ValueAxis valueAxis2 = new ValueAxis();
        valueAxis2.setType(AxisType.value);
        AxisLabel axisLabel = new AxisLabel();
        axisLabel.setFormatter("{value} ℃");
        valueAxis2.setAxisLabel(axisLabel);
        option.yAxis(valueAxis2);

        Line line1 = new Line();
        line1.name("最高气温").type(SeriesType.line).data("11","11","15","13","12","13","10");

        line1.setMarkPoint(EChartUtils.makeMarkPointMaxAndMin());
        line1.setMarkLine(EChartUtils.makeMarkLineAverage());

        Line line2 = new Line();
        line2.name("最低气温").type(SeriesType.line).data("1","-2","2","5","3","2","0");
        line2.setMarkLine(EChartUtils.makeMarkLineMaxLineAndAverage());

        option.series(line1,line2);
        return option.toString();
    }

    @RequestMapping(value = "/testMy", method = RequestMethod.GET)
    @ResponseBody
    public void test2(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Long start = System.currentTimeMillis();
        Map map = new HashMap();
        List<DssInStorePO> result = dssInStoreMapper.list(map);
        List<DssInStorePO> result_big = new ArrayList<DssInStorePO>();
//        for(int i = 0 ; i < 30 ; i++){
//            result_big.addAll(result);
//        }
        ExcelUtils excelUtils = new ExcelUtils();
        String[] headers = {"编号","入库编号","入库时间","入库类型","仓库编号","仓库名称","生产线编号","生产线名称"};
        String[] cols = {"id","in_no","in_date","in_type","store_id","store_name","product_line_id","product_line_name"};
//        HSSFWorkbook hssfWorkbook = excelUtils.exportExcel2003("入库信息",headers,cols,result,null);
//        SXSSFWorkbook sxssfWorkbook = excelUtils.exportExcel2007BigData("入库信息",headers,cols,result,null);
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition","attachment;fileName=ExportData.xls");
//        excelUtils.exportExcelJXI2003("入库信息",headers,cols,result,null,response);
        Workbook workbook = ExcelExportUtil.exportWorkbook(result);
//        OutputStream outputStream = response.getOutputStream();
//        sxssfWorkbook.write(outputStream);
        workbook.write(response.getOutputStream());
        Long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000);
    }


}