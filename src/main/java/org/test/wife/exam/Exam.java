package org.test.wife.exam;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

@Data
public class Exam implements Serializable {

    @Excel(name="排序")
    private String id;

    @Excel(name = "正式or模拟")
    private String type;

    @Excel(name = "知识点")
    private String note;

    @Excel(name="id/examId")
    private String examId;

    @Excel(name = "title/item")
    private String title;

    @Excel(name = "type/isChose")
    private String isChose;

    @Excel(name = "detail")
    private String detail;

    @Excel(name = "picUrl")
    private String picUrl;

    @Excel(name = "objectId")
    private String objectId;

    @Excel(name = "分类")
    private String leibie;
}
