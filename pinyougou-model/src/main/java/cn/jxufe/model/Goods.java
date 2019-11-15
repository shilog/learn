package cn.jxufe.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Table(name = "tb_goods")
public class Goods implements Serializable {

    /****
     * tb_goods_desc  一对一映射
     */
    private GoodsDesc goodsDesc;

    /***
     * tb_item  一对多关系
     */
    private List<Item> items;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 商家ID
     */
    @Column(name = "seller_id")
    private String sellerId;

    /**
     * SPU名
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 默认SKU
     */
    @Column(name = "default_item_id")
    private Long defaultItemId;

    /**
     * 状态
     */
    @Column(name = "audit_status")
    private String auditStatus;

    /**
     * 是否上架
     */
    @Column(name = "is_marketable")
    private String isMarketable;

    /**
     * 品牌
     */
    @Column(name = "brand_id")
    private Long brandId;

    /**
     * 副标题
     */
    @Column(name = "caption")
    private String caption;

    /**
     * 一级类目
     */
    @Column(name = "category1_id")
    private Long category1Id;

    /**
     * 二级类目
     */
    @Column(name = "category2_id")
    private Long category2Id;

    /**
     * 三级类目
     */
    @Column(name = "category3_id")
    private Long category3Id;

    /**
     * 小图
     */
    @Column(name = "small_pic")
    private String smallPic;

    /**
     * 商城价
     */
    @Column(name = "price")
    private BigDecimal price;

    /**
     * 分类模板ID
     */
    @Column(name = "type_template_id")
    private Long typeTemplateId;

    /**
     * 是否启用规格
     */
    @Column(name = "is_enable_spec")
    private String isEnableSpec;

    /**
     * 是否删除
     */
    @Column(name = "is_delete")
    private String isDelete;

    private static final long serialVersionUID = 1L;

    public GoodsDesc getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(GoodsDesc goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取商家ID
     *
     * @return seller_id - 商家ID
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * 设置商家ID
     *
     * @param sellerId 商家ID
     */
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    /**
     * 获取SPU名
     *
     * @return goods_name - SPU名
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置SPU名
     *
     * @param goodsName SPU名
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * 获取默认SKU
     *
     * @return default_item_id - 默认SKU
     */
    public Long getDefaultItemId() {
        return defaultItemId;
    }

    /**
     * 设置默认SKU
     *
     * @param defaultItemId 默认SKU
     */
    public void setDefaultItemId(Long defaultItemId) {
        this.defaultItemId = defaultItemId;
    }

    /**
     * 获取状态
     *
     * @return audit_status - 状态
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置状态
     *
     * @param auditStatus 状态
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    /**
     * 获取是否上架
     *
     * @return is_marketable - 是否上架
     */
    public String getIsMarketable() {
        return isMarketable;
    }

    /**
     * 设置是否上架
     *
     * @param isMarketable 是否上架
     */
    public void setIsMarketable(String isMarketable) {
        this.isMarketable = isMarketable == null ? null : isMarketable.trim();
    }

    /**
     * 获取品牌
     *
     * @return brand_id - 品牌
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * 设置品牌
     *
     * @param brandId 品牌
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    /**
     * 获取副标题
     *
     * @return caption - 副标题
     */
    public String getCaption() {
        return caption;
    }

    /**
     * 设置副标题
     *
     * @param caption 副标题
     */
    public void setCaption(String caption) {
        this.caption = caption == null ? null : caption.trim();
    }

    /**
     * 获取一级类目
     *
     * @return category1_id - 一级类目
     */
    public Long getCategory1Id() {
        return category1Id;
    }

    /**
     * 设置一级类目
     *
     * @param category1Id 一级类目
     */
    public void setCategory1Id(Long category1Id) {
        this.category1Id = category1Id;
    }

    /**
     * 获取二级类目
     *
     * @return category2_id - 二级类目
     */
    public Long getCategory2Id() {
        return category2Id;
    }

    /**
     * 设置二级类目
     *
     * @param category2Id 二级类目
     */
    public void setCategory2Id(Long category2Id) {
        this.category2Id = category2Id;
    }

    /**
     * 获取三级类目
     *
     * @return category3_id - 三级类目
     */
    public Long getCategory3Id() {
        return category3Id;
    }

    /**
     * 设置三级类目
     *
     * @param category3Id 三级类目
     */
    public void setCategory3Id(Long category3Id) {
        this.category3Id = category3Id;
    }

    /**
     * 获取小图
     *
     * @return small_pic - 小图
     */
    public String getSmallPic() {
        return smallPic;
    }

    /**
     * 设置小图
     *
     * @param smallPic 小图
     */
    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic == null ? null : smallPic.trim();
    }

    /**
     * 获取商城价
     *
     * @return price - 商城价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置商城价
     *
     * @param price 商城价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取分类模板ID
     *
     * @return type_template_id - 分类模板ID
     */
    public Long getTypeTemplateId() {
        return typeTemplateId;
    }

    /**
     * 设置分类模板ID
     *
     * @param typeTemplateId 分类模板ID
     */
    public void setTypeTemplateId(Long typeTemplateId) {
        this.typeTemplateId = typeTemplateId;
    }

    /**
     * 获取是否启用规格
     *
     * @return is_enable_spec - 是否启用规格
     */
    public String getIsEnableSpec() {
        return isEnableSpec;
    }

    /**
     * 设置是否启用规格
     *
     * @param isEnableSpec 是否启用规格
     */
    public void setIsEnableSpec(String isEnableSpec) {
        this.isEnableSpec = isEnableSpec == null ? null : isEnableSpec.trim();
    }

    /**
     * 获取是否删除
     *
     * @return is_delete - 是否删除
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除
     *
     * @param isDelete 是否删除
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }
}