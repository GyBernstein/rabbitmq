package com.gaoyuan.spring.common;

import java.io.Serializable;
import java.util.Date;


/**
 * 2016年11月15日下午2:37:52
 * @author zhangx
 * 翻页使用
 */
public class BaseDto implements Serializable{

	/**
	 * @author 高源
	 * @Date 2017年5月2日 下午2:28:23
	 * 
	 */
	private static final long serialVersionUID = -4532918190229337047L;

	private Integer timeToLiveSeconds = ImesConstant.DEFAULT_TIME_TO_LIVE_SECONDS;
	
	private Integer totalCount;
	
	private Integer startIndex;
	
	private Integer pageNo;
	
	private Integer pageSize;
	
	 /**
     * 可用标识 1可用 0停用
     */
    private Integer markAble;

    /**
     * 删除标志 1 删除 0 正常
     */
    private Boolean isDel;

    /**
     * 创建人 personCode
     */
    private String createUser;
    
    /**
     * 创建人名称
     */
    private String createUserName;

    /**
     * 创建日期啊
     */
    private Date createDate;
    
    /**
     * 创建日期格式化
     */
    private String createDateStr;

    /**
     * 更新人 personCode
     */
    private String updateUser;
    
    /**
     * 更新人名称
     */
    private String updateUserName;

    /**
     * 更新日期
     */
    private Date updateDate;
    
    /**
     * 更新日期格式化
     */
    private String updateDateStr;
    
	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	
	public Integer getMarkAble() {
        return markAble;
    }

    public void setMarkAble(Integer markAble) {
        this.markAble = markAble;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
        if (createDate!=null) {
			
        	setCreateDateStr(CommonUtil.formatData(null, this.createDate));
		}
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        if (updateDate!=null) {
			
        	setUpdateDateStr(CommonUtil.formatData(null, this.updateDate));
		}
    }

	public String getCreateDateStr() {
		return createDateStr;
	}

	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	public String getUpdateDateStr() {
		return updateDateStr;
	}

	public void setUpdateDateStr(String updateDateStr) {
		this.updateDateStr = updateDateStr;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public Integer getTimeToLiveSeconds() {
		return timeToLiveSeconds;
	}

	public void setTimeToLiveSeconds(Integer timeToLiveSeconds) {
		this.timeToLiveSeconds = timeToLiveSeconds;
	}
	
}
