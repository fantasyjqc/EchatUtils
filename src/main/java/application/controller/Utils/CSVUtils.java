package application.controller.Utils;

import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVUtils<T> {

    public void exportCSV(String[] headers, String[] Col, Collection<T> dataset, String pattern, HttpServletResponse response) throws Exception{
        if(pattern == null || pattern.equals("")) pattern = "yyy-MM-dd";
        // 声明一个工作薄
        CsvWriter csvWriter = new CsvWriter(response.getOutputStream(),new CsvWriterSettings());
        // 生成一个表格
        // 写入第一行标题
        csvWriter.writeHeaders(headers);
        // 遍历集合数据，产生数据行
        Iterator<T> it = dataset.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            T t = (T) it.next();
            String[] fields = Col;
            String[] object = new String[fields.length];
            for (short i = 0; i < fields.length; i++) {
                String fieldName = fields[i];
                try {
                    Object value = "";
                    Class tCls = null;
                    Map map = null;
                    if(t instanceof Map){
                        map = (Map)t;
                        value = map.get(fieldName);
                    } else {
                        String getMethodName = "get"
                                + fieldName.substring(0, 1).toUpperCase()
                                + fieldName.substring(1);
                        tCls = t.getClass();
                        Method getMethod = tCls.getMethod(getMethodName,new Class[] {});
                        value = getMethod.invoke(t, new Object[] {});
                    }
                    if(value == null ) value = "";
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    if (value instanceof Date) {
                        Date date = (Date) value;
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                        textValue = sdf.format(date);
                    } else if (value instanceof byte[]) {

                    } else {
                        // 其它数据类型都当作字符串简单处理
                        textValue = value.toString();
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            Number number = new Number(i, index , Double.valueOf(textValue));
                            object[i] = Double.valueOf(textValue).toString();
                        } else {
                            object[i] = textValue;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            csvWriter.writeRow(object);
        }
        csvWriter.flush();
        csvWriter.close();
    }

    public void exportCSVRows(CsvWriter csvWriter, String[] Col, Collection<T> dataset, String pattern) throws Exception{
        if(pattern == null || pattern.equals("")) pattern = "yyy-MM-dd";
        // 遍历集合数据，产生数据行
        Iterator<T> it = dataset.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            T t = (T) it.next();
            String[] fields = Col;
            String[] object = new String[fields.length];
            for (short i = 0; i < fields.length; i++) {
                String fieldName = fields[i];
                try {
                    Object value = "";
                    Class tCls = null;
                    Map map = null;
                    if(t instanceof Map){
                        map = (Map)t;
                        value = map.get(fieldName);
                    } else {
                        String getMethodName = "get"
                                + fieldName.substring(0, 1).toUpperCase()
                                + fieldName.substring(1);
                        tCls = t.getClass();
                        Method getMethod = tCls.getMethod(getMethodName,new Class[] {});
                        value = getMethod.invoke(t, new Object[] {});
                    }
                    if(value == null ) value = "";
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    if (value instanceof Date) {
                        Date date = (Date) value;
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                        textValue = sdf.format(date);
                    } else if (value instanceof byte[]) {

                    } else {
                        // 其它数据类型都当作字符串简单处理
                        textValue = value.toString();
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            Number number = new Number(i, index , Double.valueOf(textValue));
                            object[i] = Double.valueOf(textValue).toString();
                        } else {
                            object[i] = textValue;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            csvWriter.writeRow(object);
        }
    }

}
