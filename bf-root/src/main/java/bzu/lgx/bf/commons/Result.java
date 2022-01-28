package bzu.lgx.bf.commons;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-08 12:52
 * @Description: HTTP结果封装
 */
@Getter
@Setter
@ApiModel(value = "基础返回类")
public class Result {

    @ApiModelProperty(example = "TRUE")
    private boolean flag;

    @ApiModelProperty(example = "200")
    private Integer code;

    @ApiModelProperty(example = "成功")
    private String message;

    private Object data;

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-08 12:55
     * @Description:
     */
    public Result() {

    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-08 12:55
     * @Description:
     */
    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-08 12:55
     * @Description:
     */
    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
