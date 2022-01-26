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
 * @Data: 2022-01-08 12:41
 * @Description: 品牌实体类
 */
@Getter
@Setter
@Entity
@Table(name = "bf_brand")
@ApiModel(value = "品牌实体类", description = "")
public class Brand implements Serializable {

    private static final long serialVersionUID = 2318029638925670503L;

    @Id
    @ApiModelProperty(example = "1111111111111111111", value = "Default String", required = true, notes = "ID")
    private String id;

    @ApiModelProperty(example = "华为", required = true, notes = "品牌名称")
    private String name;

    @ApiModelProperty(example = "/static/image/huawei.png", notes = "品牌LOGO")
    private String image;

    @ApiModelProperty(example = "H", notes = "品牌首字母")
    private char letter;

    @ApiModelProperty(example = "0", notes = "品牌排序")
    private int sort;

}
