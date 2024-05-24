package cn.insectmk.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.insectmk.common.utils.PageUtils;
import cn.insectmk.gulimall.ware.entity.PurchaseDetailEntity;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author InsectMk
 * @email 3067836615@qq.com
 * @date 2024-05-09 11:14:48
 */
public interface PurchaseDetailService extends IService<PurchaseDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取采购单下所有的采购项
     * @param id
     * @return
     */
    List<PurchaseDetailEntity> listDetailByPurchaseId(Long id);
}

