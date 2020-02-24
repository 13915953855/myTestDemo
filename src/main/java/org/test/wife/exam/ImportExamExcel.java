package org.test.wife.exam;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ImportExamExcel {


    public static void main(String[] args) {
        ImportParams params = new ImportParams();
        //params.setTitleRows(1);
        params.setHeadRows(1);
        long start = new Date().getTime();
        List<Exam> list = ExcelImportUtil.importExcel(
                new File("src/main/resources/a.xlsx"),
                Exam.class, params);
        long times = (new Date().getTime() - start);
        System.out.println("导入excel一共用时:"+times+"毫秒！数据量一共"+list.size()+"行！");
        //System.out.println(ReflectionToStringBuilder.toString(list.get(0)));
        try {
            convertToJson(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void convertToJson(List<Exam> list) throws IOException {
        String examFilePath="E:\\exam.json";
        String choseFilePath="E:\\chose.json";
        String examFilePath2="E:\\exam_test.json";
        String choseFilePath2="E:\\chose_test.json";
        FileOutputStream examFos = new FileOutputStream(examFilePath);
        FileOutputStream examFos2 = new FileOutputStream(examFilePath2);
        FileOutputStream choseFos = new FileOutputStream(choseFilePath);
        FileOutputStream choseFos2 = new FileOutputStream(choseFilePath2);
        String preExamId = "";
        int count = 0;
        for (Exam exam : list) {
            JSONObject jsonObject = new JSONObject();
            String examId = exam.getExamId();
            String [] examIdArr = examId.split("-");
            String testType = exam.getType();
            if(preExamId.equals(examId)){//说明是题目的选项
                jsonObject.put("examId",count);
                jsonObject.put("item",exam.getTitle());
                jsonObject.put("isChose",exam.getIsChose());
                //jsonObject.put("id","A");
                if(testType.equals("模拟")){
                    choseFos.write(jsonObject.toJSONString().getBytes());
                    choseFos.write("\r\n".getBytes());
                }else if(testType.equals("正式")){
                    choseFos2.write(jsonObject.toJSONString().getBytes());
                    choseFos2.write("\r\n".getBytes());
                }else{
                    choseFos.write(jsonObject.toJSONString().getBytes());
                    choseFos.write("\r\n".getBytes());
                    choseFos2.write(jsonObject.toJSONString().getBytes());
                    choseFos2.write("\r\n".getBytes());
                }
            }else{//说明是题目
                preExamId = examId;
                count++;
                jsonObject.put("title",exam.getTitle());
                jsonObject.put("type",exam.getIsChose());
                jsonObject.put("leibie",exam.getLeibie());
                jsonObject.put("detail",exam.getDetail());
                jsonObject.put("picUrl",exam.getPicUrl());
                jsonObject.put("id",count);
                if(testType.equals("模拟")){
                    examFos.write(jsonObject.toJSONString().getBytes());
                    examFos.write("\r\n".getBytes());
                }else if(testType.equals("正式")){
                    examFos2.write(jsonObject.toJSONString().getBytes());
                    examFos2.write("\r\n".getBytes());
                }else{
                    examFos.write(jsonObject.toJSONString().getBytes());
                    examFos.write("\r\n".getBytes());
                    examFos2.write(jsonObject.toJSONString().getBytes());
                    examFos2.write("\r\n".getBytes());
                }
            }
        }
        examFos.close();
        choseFos.close();
        examFos2.close();
        choseFos2.close();
    }
}
