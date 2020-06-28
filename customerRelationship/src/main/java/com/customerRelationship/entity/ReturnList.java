package com.customerRelationship.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("t_customer_return_list")
public class ReturnList extends Model<ReturnList> {

    private static final long serialVersionUID = 1L;

    /**
     * 客户退货单id，主键
     */
    @TableId(value = "customer_return_list_id", type = IdType.AUTO)
    private Integer customerReturnListId;

    /**
     * 退货单号
     */
    private String returnNumber;

    /**
     * 退货日期
     */
    private String returnDate;

    /**
     * 实付金额
     */
    private Float amountPaid;

    /**
     * 应付金额
     */
    private Float amountPayable;

    /**
     * 状态，是否付款
     */
    private Integer state;

    /**
     * 客户编号id，外键
     */
    private Integer customerId;

    /**
     * 操作员，用户id，外键
     */
    private Integer userId;

    /**
     * 备注
     */
    private String remarks;


    @Override
    protected Serializable pkVal() {
        return this.customerReturnListId;
    }

}
