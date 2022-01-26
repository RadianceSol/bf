package bzu.lgx.bf.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-25 09:56
 * @Description: 类别实体类
 */
@Getter
@Setter
@Entity
@Table(name = "bf_category")
@ApiModel(value = "类别实体类", description = "")
public class Category implements Serializable {

    private static final long serialVersionUID = -5774832339379007451L;

    @Id
    @ApiModelProperty(example = "1111111111111111111", value = "Default String", required = true, notes = "ID")
    private String id;

    @ApiModelProperty(example = "手机", required = true, notes = "分类名称")
    private String name;

    @ApiModelProperty(example = "0", notes = "分类下商品数量")
    private int goodsNum;

    @ApiModelProperty(example = "Y/N", notes = "是否显示")
    private Byte isShow;

    @ApiModelProperty(example = "Y/N", notes = "是否导航")
    private Byte isMenu;

    @ApiModelProperty(example = "0", notes = "分类排序")
    private int sort;

    @ApiModelProperty(example = "1111111111111111111", value = "Default String", required = true, notes = "ID")
    private String parentId;

    @ApiModelProperty(example = "1111111111111111111", value = "Default String", required = true, notes = "ID")
    private String templateId;

}
