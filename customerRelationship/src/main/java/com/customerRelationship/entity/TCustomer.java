package com.customerRelationship.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author gf
 * @since 2020-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TCustomer extends Model<TCustomer> {

    private static final long serialVersionUID = 1L;

    /**
     * 客户编号id，主键
     */
    @TableId(value = "customer_id", type = IdType.AUTO)
    private Integer customerId;

    /**
     * 客户名称
     */
    private String customerName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContacts() {
        return contacts;
    }

    public TCustomer() {
    }

    public TCustomer(Integer customerId, String customerName, String contacts, String phoneNumber, String address, String remarks) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contacts = contacts;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.remarks = remarks;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 联系人电话
     */
    private String phoneNumber;

    /**
     * 客户地址
     */
    private String address;

    /**
     * 备注
     */
    private String remarks;


    @Override
    protected Serializable pkVal() {
        return this.customerId;
    }

}
