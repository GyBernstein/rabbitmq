package com.gaoyuan.spring.dto;

import java.util.Date;

import com.gaoyuan.spring.common.BaseDto;
import com.gaoyuan.spring.common.CommonUtil;
import com.gaoyuan.spring.common.ImesConstant;

/**
 * 2016年12月7日上午10:32:03
 * @author 张旭
 * MES_Product_Collect
 * 产品执行采集表
 */
public class ProductCollect extends BaseDto{
	/**
	 * @author 高源
	 * @Date 2017年5月2日 下午2:28:39
	 * 
	 */
	private static final long serialVersionUID = 7960792137416491705L;

	private Integer id;

	/**
	 * 产品编码
	 */
	private String productCode;

	/**
	 * 产品名称
	 */
	private String productName;

	/**
	 * 订单编码
	 */
	private String orderCode;

	/**
	 * 型号编码
	 */
	private String modelCode;

	/**
	 * 计划数量
	 */
	private Integer planNum;

	/**
	 * 完成数量
	 */
	private int finishNum;

	/**
	 * 差异数量
	 */
	private int diffNum;
	
	/**
	 * 超期天数
	 */
	private int overdueNum;
	
	/**
	 * 超期状态
	 */
	private String overdueStatus;
	
	/**
	 * 超期名称
	 */
	private String overdueName;

	/**
	 * 第一台上线时间
	 */
	private Date onLineTime;
	private String onLineTimeStr;
	
	/**
	 * 上线数量
	 */
	private int onLineCount;
	/**
	 * 下线数量
	 */
	private int offLineCount;

	/**
	 * 最后一台下线时间
	 */
	private Date offLineTime;
	private String offLineTimeStr;

	/**
	 * 计划开始时间
	 */
	private Date planStartTime;
	private String planStartTimeStr;

	/**
	 * 计划结束时间
	 */
	private Date planEndTime;
	private String planEndTimeStr;

	/**
	 * 业务类型： 上线-下线 
	 * OnLine/OffLine
	 */
	private String buzType;

	/**
	 *  0：未开始执行
		1：部分开始执行
		2：全部开始执行
		3：部分完成
		4：全部完成

	 */
	private String orderStatus;
	private String orderStatusName;

	/**
	 * 操作人编码
	 */
	private String operatorCode;

	/**
	 * 操作人名称
	 */
	private String operatorName;
	
	/**
	 * 操作次数
	 */
	private String OperateNum;

	/**
	 * 操作时间
	 */
	private Date operateTime;
	private String operateTimeStr;

	/**
	 * 工作单元编码
	 */
	private String workUnitCode;

	/**
	 * 工作单元名称
	 */
	private String workUnitName;

	/**
	 * 班组编码
	 */
	private String classGroupCode;
	private String classGroupName;

	/**
	 * 班次编码
	 */
	private String classLevelCode;
	private String classLevelName;
	
	/**
	 * 质检结果
	 */
	private String qualityResult;
	private String qualityResultName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode == null ? null : productCode.trim();
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName == null ? null : productName.trim();
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode == null ? null : orderCode.trim();
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode == null ? null : modelCode.trim();
	}

	public Integer getPlanNum() {
		return planNum;
	}

	public void setPlanNum(Integer planNum) {
		this.planNum = planNum;
	}

	public Date getPlanStartTime() {
		return planStartTime;
	}

	public void setPlanStartTime(Date planStartTime) {
		this.planStartTime = planStartTime;
		if (planStartTime!=null) {

			setPlanStartTimeStr(CommonUtil.formatData(ImesConstant.DATA_FORMAT_YMD, this.planStartTime));
		}
	}

	public Date getPlanEndTime() {
		return planEndTime;
	}

	public void setPlanEndTime(Date planEndTime) {
		this.planEndTime = planEndTime;
		if (planEndTime!=null) {

			setPlanEndTimeStr(CommonUtil.formatData(ImesConstant.DATA_FORMAT_YMD, this.planEndTime));
		}
	}

	public String getBuzType() {
		return buzType;
	}

	public void setBuzType(String buzType) {
		this.buzType = buzType == null ? null : buzType.trim();
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode == null ? null : operatorCode.trim();
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName == null ? null : operatorName.trim();
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
		if (operateTime!=null) {

			setOperateTimeStr(CommonUtil.formatData(null, this.operateTime));
		}
	}

	public String getOperateTimeStr() {
		return operateTimeStr;
	}

	public void setOperateTimeStr(String operateTimeStr) {
		this.operateTimeStr = operateTimeStr;
	}

	public String getWorkUnitCode() {
		return workUnitCode;
	}

	public void setWorkUnitCode(String workUnitCode) {
		this.workUnitCode = workUnitCode == null ? null : workUnitCode.trim();
	}

	public String getWorkUnitName() {
		return workUnitName;
	}

	public void setWorkUnitName(String workUnitName) {
		this.workUnitName = workUnitName == null ? null : workUnitName.trim();
	}

	public String getClassGroupCode() {
		return classGroupCode;
	}

	public void setClassGroupCode(String classGroupCode) {
		this.classGroupCode = classGroupCode == null ? null : classGroupCode.trim();
	}

	public String getClassLevelCode() {
		return classLevelCode;
	}

	public void setClassLevelCode(String classLevelCode) {
		this.classLevelCode = classLevelCode == null ? null : classLevelCode.trim();
	}

	public int getFinishNum() {
		return finishNum;
	}

	public void setFinishNum(int finishNum) {
		this.finishNum = finishNum;
	}

	public int getDiffNum() {
		return diffNum;
	}

	public void setDiffNum(int diffNum) {
		this.diffNum = diffNum;
	}

	public Date getOnLineTime() {
		return onLineTime;
	}

	public void setOnLineTime(Date onLineTime) {
		this.onLineTime = onLineTime;
		if (onLineTime!=null) {

			setOnLineTimeStr(CommonUtil.formatData(ImesConstant.DATA_FORMAT_YMD, this.onLineTime));
		}
	}

	public String getOnLineTimeStr() {
		return onLineTimeStr;
	}

	public void setOnLineTimeStr(String onLineTimeStr) {
		this.onLineTimeStr = onLineTimeStr;
	}

	public Date getOffLineTime() {
		return offLineTime;
	}

	public void setOffLineTime(Date offLineTime) {
		this.offLineTime = offLineTime;
		if (offLineTime!=null) {

			setOffLineTimeStr(CommonUtil.formatData(ImesConstant.DATA_FORMAT_YMD, this.offLineTime));
		}else {
			setOffLineTimeStr("");
		}
	}

	public String getOffLineTimeStr() {
		return offLineTimeStr;
	}

	public void setOffLineTimeStr(String offLineTimeStr) {
		this.offLineTimeStr = offLineTimeStr;
	}

	public String getPlanStartTimeStr() {
		return planStartTimeStr;
	}

	public void setPlanStartTimeStr(String planStartTimeStr) {
		this.planStartTimeStr = planStartTimeStr;
	}

	public String getPlanEndTimeStr() {
		return planEndTimeStr;
	}

	public void setPlanEndTimeStr(String planEndTimeStr) {
		this.planEndTimeStr = planEndTimeStr;
	}
	

	public String getQualityResult() {
		return qualityResult;
	}

	public void setQualityResult(String qualityResult) {
		this.qualityResult = qualityResult;
		switch (this.qualityResult) {
		case "0":
			setQualityResultName("合格");
			break;
		case "1":
			setQualityResultName("不合格");
			break;
//		case "2":
//			setQualityResultName("不良品");
//			break;
//		case "3":
//			setQualityResultName("废品");
//			break;
		default:
			break;
		}
	}

	public String getQualityResultName() {
		return qualityResultName;
	}

	public void setQualityResultName(String qualityResultName) {
		this.qualityResultName = qualityResultName;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
		switch (this.orderStatus) {
		case "0":
			setOrderStatusName("未开始执行");
			break;
		case "1":
			setOrderStatusName("部分开始执行");
			break;
		case "2":
			setOrderStatusName("全部开始执行");
			break;
		case "3":
			setOrderStatusName("部分完成");
			break;
		case "4":
			setOrderStatusName("全部完成");
			break;
		default:
			break;
		}
	}

	public String getOrderStatusName() {
		return orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

	public String getClassGroupName() {
		return classGroupName;
	}

	public void setClassGroupName(String classGroupName) {
		this.classGroupName = classGroupName;
	}

	public String getClassLevelName() {
		return classLevelName;
	}

	public void setClassLevelName(String classLevelName) {
		this.classLevelName = classLevelName;
	}

	public String getOperateNum() {
		return OperateNum;
	}

	public void setOperateNum(String operateNum) {
		OperateNum = operateNum;
	}

	public int getOverdueNum() {
		return overdueNum;
	}

	public void setOverdueNum(int overdueNum) {
		this.overdueNum = overdueNum;
	}

	public String getOverdueStatus() {
		return overdueStatus;
	}

	public void setOverdueStatus(String overdueStatus) {
		this.overdueStatus = overdueStatus;
		switch (this.overdueStatus) {
		case "0":
			setOverdueName("未按计划开始");
			break;
		case "1":
			setOverdueName("未按计划结束");
			break;
		default:
			break;
		}
	}

	public String getOverdueName() {
		return overdueName;
	}

	public void setOverdueName(String overdueName) {
		this.overdueName = overdueName;
	}

	public int getOnLineCount() {
		return onLineCount;
	}

	public void setOnLineCount(int onLineCount) {
		this.onLineCount = onLineCount;
	}

	public int getOffLineCount() {
		return offLineCount;
	}

	public void setOffLineCount(int offLineCount) {
		this.offLineCount = offLineCount;
	}
	
}