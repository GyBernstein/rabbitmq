package com.gaoyuan.spring.common;

/**
 * 2016年11月15日下午4:10:35
 * @author zhangx
 * 常量
 */
public class ImesConstant {
	
	public static final int DEFAULT_TIME_TO_LIVE_SECONDS=120;
	public static final int DEFAULT_STATE=0;
	
	public static final String RESULT_CODE="code";
	public static final String RESULT_CODE_SUCCESS="1";
	public static final String RESULT_CODE_ERROR="0";
	
	
	public static final String RESULT_DATA="data";
	public static final String RESULT_DATA_TOTAL_COUNT="totalCount";
	public static final String RESULT_DATA_PAGE_NO="pageNo";
	public static final String RESULT_DATA_PAGE_SIZE="pageSize";
	public static final String RESULT_DATA_LIST="list";
	public static final String RESULT_MSG="message";
	
	public static final String RESULT_ERROR_MSG="服务器异常！";
	public static final String RESULT_CODE_REPEAT_MSG="编码仍重复";
	
	public static final String OPERATE_ADD="add";
	public static final String OPERATE_DEL="delete";
	public static final String OPERATE_UPD="update";
	
	/**
	 * 24小时制格式化
	 */
	public static final String DATA_FORMAT_YMDHMS_24="yyyy-MM-dd HH:mm:ss";
	/**
	 * 年月日
	 */
	public static final String DATA_FORMAT_YMD="yyyy-MM-dd";
	
	/**
	 * 唯一性检查失败
	 */
	public static final int CHECK_UNIQUE_CONFLICT=-2;
	public static final int CHECK_UNIQUE_CONFLICT2=-3;
	
	
//	编码规则定义
	public static final String CODE_RULE_MATERIAL_VERSION="Material_Version";
	public static final String CODE_RULE_MATERIAL_CODE="Material_Code";
	public static final String CODE_RULE_ORG_CODE="Org_Code";
	public static final String CODE_RULE_DEFECT_CODE="DEF_CODE";
	public static final String CODE_RULE_SPAREPARTS_CHECKCODE="SPAREPARTS_CHECKCODE";
	public static final String CODE_RULE_EQUIP_FAULT_REPAIR="equifail_Code";
	public static final String CODE_RULE_BUSINESS_RULE_CODE="BUSINESSRULE_CODE";
	public static final String CODE_RULE_BUSINESS_PARAM="BUSINESS_PARAM";
	public static final String CODE_RULE_MATERIAL_MOVE_CODE="MOVE_CODE";
	public static final String CODE_RULE_MATERIAL_IN_CODE="MATERIALINWARE_CODE";
	public static final String CODE_RULE_MATERIAL_OUT_CODE="MATERIALOUTWARE_CODE";
	public static final String CODE_RULE_DOC_MANAGEMENT="DocmentManage";
//	代码定义
	public static final String CODE_NO_DBTYPE = "DbType";
	public static final String CODE_NO_FROMDATABASE="FromDataBase";
	public static final String CODE_NO_SERVERADDR="ServerAddr";
	public static final String CODE_NO_USERNAME="UserName";
	public static final String CODE_NO_PASSWORD="Password";
	public static final String CODE_NO_EQUIP_TYPE_MAINTAIN="MP_5";
	public static final String CODE_NO_EQUIP_TYPE_REPAIR = "MP_4";
	public static final String CODE_NO_WORK_UNIT="CX_WORK_UNIT";
	public static final String CODE_NO_WORK_PROCESS="CX_PROCESS";
	public static final String CODE_NO_MANUALLY_ADD="ManuallyAdd";
	public static final String CODE_NO_BOM_MATERIAL_MADE="BOM_MATERIAL_MADE";

//	业务参数定义
	public static final String BUSINESS_PARAM_DEFAULT_IN = "BPC002";
	public static final String BUSINESS_PARAM_DEFAULT_OUT = "BPC001";
	
	//分隔符
	public static final String ORDER_CODE_SEPARATOR = ",";
	
	/** 物料库单状态为创建 */
	public static final int WAREHOUSE_STATE_CREATE = 0;
	/** 物料库单状态为确认 */
	public static final int WAREHOUSE_STATE_CONFIRM = 1;
	/** 物入库单状态为红冲 */
	public static final int WAREHOUSE_STATE_WITHDRAW = 2;
	
	/** 物料移动需求状态-创建 */
	public static final int MATERIAL_MOVE_STATE_CREATE = 0;
	/** 物料移动需求状态-已提交 */
	public static final int MATERIAL_MOVE_STATE_SUBMIT = 1;
	/** 物料移动需求状态-审核通过 */
	public static final int MATERIAL_MOVE_STATE_CHECK_PASS = 2;
	/** 物料移动需求状态-审核不通过 */
	public static final int MATERIAL_MOVE_STATE_CHECK_FAILED=3;
	/** 物料移动需求状态-已发送 */
	public static final int MATERIAL_MOVE_STATE_SEND = 4;
	/** 物料移动需求状态-作废 */
	public static final int MATERIAL_MOVE_STATE_CANCEL = 5;
	
	
	
}
