package application.controller.Utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PDFUtils<T> {

    public void exportPDF(String title, float[] widths, Rectangle pageSize, String[] headers, String[] Col, Collection<T> dataset, String pattern, HttpServletResponse response) throws Exception{
        if(pattern == null || pattern.equals("")) pattern = "yyy-MM-dd";
        // 声明一个工作薄
        Document document = new Document(pageSize);
        BaseFont bfChinese = BaseFont.createFont("/Users/JQC/Library/Fonts/信黑体W5.ttf",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font fontZH = new Font(bfChinese, 12.0F, 0);
        PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        Paragraph paragraph = new Paragraph(new Chunk(title, fontZH).setLocalDestination(title));
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
        document.add(new Paragraph("\n"));
        PdfPTable table = new PdfPTable(headers.length);
        table.setWidths(widths);
        table.setHeaderRows(1);
        table.getDefaultCell().setHorizontalAlignment(1);
        // 写入第一行标题
        for (short i = 0; i < headers.length; i++) {
            table.addCell(new Paragraph(headers[i], fontZH));
        }
        // 遍历集合数据，产生数据行
        Iterator<T> it = dataset.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            T t = (T) it.next();
            String[] fields = Col;
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
                            table.addCell(new Paragraph(Double.valueOf(textValue).toString(), fontZH));
                        } else {
                            table.addCell(new Paragraph(textValue, fontZH));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        document.add(table);
        document.add(new Paragraph("\n"));
        document.close();
    }
}