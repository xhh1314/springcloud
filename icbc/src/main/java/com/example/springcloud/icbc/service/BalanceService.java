package com.example.springcloud.icbc.service;

import com.example.springcloud.bankofchina.manage.Restful;
import com.example.springcloud.icbc.dao.BalanceDao;
import com.example.springcloud.icbc.entity.BalanceDO;
import com.example.springcloud.icbc.manage.BalanceManage;
import com.example.springcloud.icbc.vo.BalanceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 *转账服务
 *@author lh
 *@date 2017/12/19
 *@since
 */
@Service
public class BalanceService {
    private static final Logger log= LoggerFactory.getLogger(BalanceService.class);
    @Autowired
    private BalanceManage balanceManage;
    @Autowired
    private BalanceDao balanceDao;
    private final Lock lock=new ReentrantLock();


    /**
     *减少账户余额
     *@date 2017/12/19
     *@param
     *@author lh
     *@since
     */
    @Transactional(rollbackFor = {Exception.class})
    public Restful decreaseAmount(Integer id, double number) {
        BalanceVO oldBalance = balanceManage.getBalanceById(id);
        if (oldBalance == null)
            return Restful.failure("账户不存在");
        if (number > oldBalance.getAmount())
            return Restful.failure("账户余额不足");
        BigDecimal origin = new BigDecimal(oldBalance.getAmount());
        BigDecimal decreaseNumber = new BigDecimal(number);
        oldBalance.setAmount(origin.subtract(decreaseNumber).doubleValue());
        balanceManage.saveBalance(oldBalance);
        return Restful.success();
    }
    /**
     *增加账户余额
     *@date 2017/12/19
     *@param
     *@author lh
     *@since
     */
    @Transactional(rollbackFor = {Exception.class},isolation = Isolation.REPEATABLE_READ)
    public Restful increaseAmount(Integer id,double number){
        try {
            BalanceDO oldBalance = balanceDao.getBalanceById(id);
            if (oldBalance == null)
                return Restful.failure("账户不存在");
            BigDecimal origin = new BigDecimal(oldBalance.getAmount());
            BigDecimal increaseNumber = new BigDecimal(number);
            oldBalance.setAmount(origin.add(increaseNumber).doubleValue());
            balanceManage.saveBalance(new BalanceVO(oldBalance));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

        }
        //  log.info("账户:{}成功增加金额:{}",id,number);
        return Restful.success();
    }

}
