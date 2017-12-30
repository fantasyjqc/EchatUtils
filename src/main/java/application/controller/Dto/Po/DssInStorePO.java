package application.controller.Dto.Po;

import com.xuxueli.poi.excel.annotation.ExcelField;
import com.xuxueli.poi.excel.annotation.ExcelSheet;
import org.apache.poi.hssf.util.HSSFColor;

import java.util.Date;

/**
 * <b>dss_in_store[dss_in_store]数据持久化对象</b>
 * <p>
 * 注意:此文件由AOS平台自动生成-禁止手工修改。
 * </p>
 * 
 * @author fantasyjqc
 * @date 2017-12-30 20:34:04
 */
@ExcelSheet(name = "出库清单", headColor = HSSFColor.HSSFColorPredefined.SKY_BLUE)
public class DssInStorePO{

	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@ExcelField(name = "序号")
	private Integer id;
	
	/**
	 * 入库编号
	 */
	@ExcelField(name = "入库编号")
	private String in_no;
	
	/**
	 * 入库时间
	 */
	@ExcelField(name = "入库时间")
	private Date in_date;
	
	/**
	 * 入库类型
	 */
	@ExcelField(name = "入库类型")
	private String in_type;
	
	/**
	 * 仓库编号
	 */
	@ExcelField(name = "仓库编号")
	private Integer store_id;
	
	/**
	 * 仓库名称
	 */
	@ExcelField(name = "仓库名称")
	private String store_name;
	
	/**
	 * 生产线编号
	 */
	@ExcelField(name = "生产线编号")
	private Integer product_line_id;
	
	/**
	 * 生产线名称
	 */
	@ExcelField(name = "生产线名称")
	private String product_line_name;
	

	/**
	 * id
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * 入库编号
	 * 
	 * @return in_no
	 */
	public String getIn_no() {
		return in_no;
	}
	
	/**
	 * 入库时间
	 * 
	 * @return in_date
	 */
	public Date getIn_date() {
		return in_date;
	}
	
	/**
	 * 入库类型
	 * 
	 * @return in_type
	 */
	public String getIn_type() {
		return in_type;
	}
	
	/**
	 * 仓库编号
	 * 
	 * @return store_id
	 */
	public Integer getStore_id() {
		return store_id;
	}
	
	/**
	 * 仓库名称
	 * 
	 * @return store_name
	 */
	public String getStore_name() {
		return store_name;
	}
	
	/**
	 * 生产线编号
	 * 
	 * @return product_line_id
	 */
	public Integer getProduct_line_id() {
		return product_line_id;
	}
	
	/**
	 * 生产线名称
	 * 
	 * @return product_line_name
	 */
	public String getProduct_line_name() {
		return product_line_name;
	}
	

	/**
	 * id
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * 入库编号
	 * 
	 * @param in_no
	 */
	public void setIn_no(String in_no) {
		this.in_no = in_no;
	}
	
	/**
	 * 入库时间
	 * 
	 * @param in_date
	 */
	public void setIn_date(Date in_date) {
		this.in_date = in_date;
	}
	
	/**
	 * 入库类型
	 * 
	 * @param in_type
	 */
	public void setIn_type(String in_type) {
		this.in_type = in_type;
	}
	
	/**
	 * 仓库编号
	 * 
	 * @param store_id
	 */
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	
	/**
	 * 仓库名称
	 * 
	 * @param store_name
	 */
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	
	/**
	 * 生产线编号
	 * 
	 * @param product_line_id
	 */
	public void setProduct_line_id(Integer product_line_id) {
		this.product_line_id = product_line_id;
	}
	
	/**
	 * 生产线名称
	 * 
	 * @param product_line_name
	 */
	public void setProduct_line_name(String product_line_name) {
		this.product_line_name = product_line_name;
	}
	

}