package cn.jxufe.sellergoods.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.jxufe.mapper.ItemCatMapper;
import cn.jxufe.model.ItemCat;
import cn.jxufe.sellergoods.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

	/**
	 * 返回ItemCat全部列表
	 * @return
	 */
	@Override
    public List<ItemCat> getAll(){
        return itemCatMapper.selectAll();
    }


    /***
     * 分页返回ItemCat列表
     * @param pageNum
     * @param pageSize
     * @return
     */
	@Override
    public PageInfo<ItemCat> getAll(ItemCat itemCat,int pageNum, int pageSize) {
        //执行分页
        PageHelper.startPage(pageNum,pageSize);
       
        //执行查询
        List<ItemCat> all = itemCatMapper.select(itemCat);
        PageInfo<ItemCat> pageInfo = new PageInfo<ItemCat>(all);
        return pageInfo;
    }



    /***
     * 增加ItemCat信息
     * @param itemCat
     * @return
     */
    @Override
    public int add(ItemCat itemCat) {
        return itemCatMapper.insertSelective(itemCat);
    }


    /***
     * 根据ID查询ItemCat信息
     * @param id
     * @return
     */
    @Override
    public ItemCat getOneById(Long id) {
        return itemCatMapper.selectByPrimaryKey(id);
    }


    /***
     * 根据ID修改ItemCat信息
     * @param itemCat
     * @return
     */
    @Override
    public int updateItemCatById(ItemCat itemCat) {
        return itemCatMapper.updateByPrimaryKeySelective(itemCat);
    }


    /***
     * 根据ID批量删除ItemCat信息
     * @param ids
     * @return
     */
    @Override
    public int deleteByIds(List<Long> ids) {
        //创建Example，来构建根据ID删除数据
        Example example = new Example(ItemCat.class);
        Example.Criteria criteria = example.createCriteria();

        //所需的SQL语句类似 delete from tb_itemCat where id in(1,2,5,6)
        criteria.andIn("id",ids);
        return itemCatMapper.deleteByExample(example);
    }

    /***
     * 根据父ID查询所有子类
     * select * from tb_item_cat where parent_id=0;
     * @param id
     * @return
     */
    @Override
    public List<ItemCat> findByParentId(long id) {
        ItemCat itemCat = new ItemCat();
        itemCat.setParentId(id);
        return itemCatMapper.select(itemCat);
    }
}
