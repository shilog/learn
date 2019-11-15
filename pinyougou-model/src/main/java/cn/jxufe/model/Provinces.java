package cn.jxufe.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "tb_provinces")
public class Provinces implements Serializable {
    /**
     * 唯一ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 省份ID
     */
    @Column(name = "provinceid")
    private String provinceid;

    /**
     * 省份名称
     */
    @Column(name = "province")
    private String province;

    private static final long serialVersionUID = 1L;

    /**
     * 获取唯一ID
     *
     * @return id - 唯一ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置唯一ID
     *
     * @param id 唯一ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取省份ID
     *
     * @return provinceid - 省份ID
     */
    public String getProvinceid() {
        return provinceid;
    }

    /**
     * 设置省份ID
     *
     * @param provinceid 省份ID
     */
    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid == null ? null : provinceid.trim();
    }

    /**
     * 获取省份名称
     *
     * @return province - 省份名称
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份名称
     *
     * @param province 省份名称
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }
}