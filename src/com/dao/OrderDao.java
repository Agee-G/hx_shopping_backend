package com.dao;
import com.Utils.Page;
import com.entity.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @author:20155808李连芸
 * @date:18/4/20 09 28
 * @description
 * orderStatus - 0:待付款 1:待发货 2:待收货 3:已收获 4:以评价 5:仅退款 6:退货退款
 */
public class OrderDao extends BaseDaoImpl<OrdersEntity>{
}
