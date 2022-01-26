package bzu.lgx.bf.commons;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-08 21:10
 * @Description:
 */
@Getter
@Setter
public class PageResult<T> {

    private Long total;

    private List<T> rows;

    public PageResult(Long total, List<T> rows) {
        super();
        this.total = total;
        this.rows = rows;
    }
}
