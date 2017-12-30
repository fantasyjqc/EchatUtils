package application.controller.Dto.Mapper;

import java.util.List;
import java.util.Map;

import application.controller.Dto.Po.DssInStorePO;

/**
 * <b>dss_in_store[dss_in_store]数据访问接口</b>
 * 
 * <p>
 * 注意:此文件由AOS平台自动生成-禁止手工修改
 * </p>
 * 
 * @author fantasyjqc
 * @date 2017-12-30 20:34:04
 */
public interface DssInStoreMapper {

	/**
	 * 根据Dto查询并返回数据持久化对象集合
	 * 
	 * @return List<Dss_in_storePO>
	 */
	List<DssInStorePO> list(Map map);
	
}
