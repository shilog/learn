package cn.jxufe.sellergoods.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.jxufe.mapper.SpecificationOptionMapper;
import cn.jxufe.mapper.TypeTemplateMapper;
import cn.jxufe.model.Specification;
import cn.jxufe.model.SpecificationOption;
import cn.jxufe.model.TypeTemplate;
import cn.jxufe.sellergoods.service.TypeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
import java.util.Map;

@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {

    @Autowired
    private TypeTemplateMapper typeTemplateMapper;

    /**
     * 返回TypeTemplate全部列表
     * @return
     */
    @Override
    public List<TypeTemplate> getAll(){
        return typeTemplateMapper.selectAll();
    }


    /***
     * 分页返回TypeTemplate列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<TypeTemplate> getAll(TypeTemplate typeTemplate,int pageNum, int pageSize) {
        //执行分页
        PageHelper.startPage(pageNum,pageSize);

        //执行查询
        List<TypeTemplate> all = typeTemplateMapper.select(typeTemplate);
        PageInfo<TypeTemplate> pageInfo = new PageInfo<TypeTemplate>(all);
        return pageInfo;
    }



    /***
     * 增加TypeTemplate信息
     * @param typeTemplate
     * @return
     */
    @Override
    public int add(TypeTemplate typeTemplate) {
        return typeTemplateMapper.insertSelective(typeTemplate);
    }


    /***
     * 根据ID查询TypeTemplate信息
     * @param id
     * @return
     */
    @Override
    public TypeTemplate getOneById(Long id) {
        return typeTemplateMapper.selectByPrimaryKey(id);
    }


    /***
     * 根据ID修改TypeTemplate信息
     * @param typeTemplate
     * @return
     */
    @Override
    public int updateTypeTemplateById(TypeTemplate typeTemplate) {
        return typeTemplateMapper.updateByPrimaryKeySelective(typeTemplate);
    }


    /***
     * 根据ID批量删除TypeTemplate信息
     * @param ids
     * @return
     */
    @Override
    public int deleteByIds(List<Long> ids) {
        //创建Example，来构建根据ID删除数据
        Example example = new Example(TypeTemplate.class);
        Example.Criteria criteria = example.createCriteria();

        //所需的SQL语句类似 delete from tb_typeTemplate where id in(1,2,5,6)
        criteria.andIn("id",ids);
        return typeTemplateMapper.deleteByExample(example);
    }

    @Autowired
    private SpecificationOptionMapper specificationOptionMapper;

    @Override
    public List<Map> getOptionsByTypeId(long id) {
        //先查询出模板中的规格信息
        TypeTemplate template = typeTemplateMapper.selectByPrimaryKey(id);

        // spec_ids=[{"id":32,"text":"机身内存"},{"id":36,"text":"网络"}]
        //将spec_id转成JSON，并循环
        List<Map> dataMap = JSON.parseArray(template.getSpecIds(),Map.class);
        //{"id":32,"text":"机身内存"}
        //Map key-value = JSON  key-value
        //{"id":36,"text":"网络"}

        for (Map map : dataMap) {
            //获取规格ID
            long specId = Long.parseLong(map.get("id").toString());     //规格ID

            //根据spec_id的json值中的id值去数据(tb_specification_option)查询规格选项
            //select * from tb_specification_option where spec_id=?
            SpecificationOption specificationOption = new SpecificationOption();
            specificationOption.setSpecId(specId);
            List<SpecificationOption> options = specificationOptionMapper.select(specificationOption);

            //组装JSON数据格式
            map.put("options",options);
        }
        return dataMap;
    }
}
