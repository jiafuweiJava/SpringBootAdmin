package com.example.core.page;

import java.io.Serializable;
import java.util.List;

/**
 * 用于装载查询结果
 *
 * @author leiwenjie leiwenjie.cn@gmail.com
 * @date 2017年4月21日 上午10:35:41
 */
public class PageResult<E> implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1273175334927538692L;

    /**
     * 总记录数
     */
    private Long count;

    /**
     * 数据列表
     */
    private List<E> data;


    public PageResult(){

    }

    public PageResult(Long count, List<E> data){
        this.count=count;
        this.data=data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }
}
