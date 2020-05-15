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
import java.util.*;

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
        String examFilePath="E:\\exam_test.json";
        String choseFilePath="E:\\chose_test.json";
        String examFilePath2="E:\\exam.json";
        String choseFilePath2="E:\\chose.json";
        String menuFilePath="E:\\menu.json";
        FileOutputStream examFos = new FileOutputStream(examFilePath);
        FileOutputStream examFos2 = new FileOutputStream(examFilePath2);
        FileOutputStream choseFos = new FileOutputStream(choseFilePath);
        FileOutputStream choseFos2 = new FileOutputStream(choseFilePath2);
        String preExamId = "";
        String preType = "";
        int count = 0;
        Map<Integer,Integer> totalMap = new HashMap<>();
        Map<Integer,Integer> testTotalMap = new HashMap<>();
        for (Exam exam : list) {
            JSONObject jsonObject = new JSONObject();
            String examId = exam.getExamId();
            String[] examIdArr = examId.split("-");
            jsonObject.put("queryId",examIdArr[1]);
            jsonObject.put("find",examId);
            String testType = exam.getType();
            if(preExamId.equals(examId) && preType.equals(testType)){//说明是题目的选项
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
                preType = testType;
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
                    if(testTotalMap.get(exam.getLeibie()) == null){
                        testTotalMap.put(exam.getLeibie(),1);
                    }else{
                        testTotalMap.put(exam.getLeibie(),testTotalMap.get(exam.getLeibie())+1);
                    }

                }else if(testType.equals("正式")){
                    examFos2.write(jsonObject.toJSONString().getBytes());
                    examFos2.write("\r\n".getBytes());
                    if(totalMap.get(exam.getLeibie()) == null){
                        totalMap.put(exam.getLeibie(),1);
                    }else{
                        totalMap.put(exam.getLeibie(),totalMap.get(exam.getLeibie())+1);
                    }
                }else{
                    examFos.write(jsonObject.toJSONString().getBytes());
                    examFos.write("\r\n".getBytes());
                    examFos2.write(jsonObject.toJSONString().getBytes());
                    examFos2.write("\r\n".getBytes());
                    if(totalMap.get(exam.getLeibie()) == null){
                        totalMap.put(exam.getLeibie(),1);
                    }else{
                        totalMap.put(exam.getLeibie(),totalMap.get(exam.getLeibie())+1);
                    }
                    if(testTotalMap.get(exam.getLeibie()) == null){
                        testTotalMap.put(exam.getLeibie(),1);
                    }else{
                        testTotalMap.put(exam.getLeibie(),testTotalMap.get(exam.getLeibie())+1);
                    }
                }
            }
        }
        examFos.close();
        choseFos.close();
        examFos2.close();
        choseFos2.close();
        FileOutputStream menuFile = new FileOutputStream(menuFilePath);
        String a = "研发1(10,11,13,14,21)";
        String b = "研发2(10,11,13,14,15,21)";
        String c = "研发3(10,11,13,14,15,16,18,21)";
        String d = "制控1(10,14,15,16,17,18,19,20)";
        String e = "制控2(10,15,16,17)";
        String f = "制控3(10,15,17)";
        String f1 = "制控4(10,16,17)";
        String g = "质量1(10,17)";
        String g1 = "质量2(10,18)";
        String h = "设备处(10,22)";
        String j = "安环(10,20)";
        String k = "生产计划1(10,16,20)";
        String k1 = "生产计划2(10,16,19,20)";
        String l = "物流(10,19)";
        String m = "采购(10,16)";
        String n = "客供件(10,21)";

        List<String> ss = new ArrayList<>();
        ss.add(a);
        ss.add(b);
        ss.add(c);
        ss.add(d);
        ss.add(e);
        ss.add(f);
        ss.add(f1);
        ss.add(g);
        ss.add(g1);
        ss.add(h);
        ss.add(j);
        ss.add(k);
        ss.add(k1);
        ss.add(l);
        ss.add(m);
        ss.add(n);

        int order = 1;
        for (String s : ss) {
            JSONObject menuJson = new JSONObject();
            menuJson.put("name",s.replace("10,",""));
            menuJson.put("orderNum",order++);
            int start = s.indexOf("(")+1;
            int end = s.indexOf(")");
            String leibieStr = s.substring(start,end);
            menuJson.put("type",leibieStr);

            String[] leibieArr = leibieStr.split(",");
            Integer a1 = 0;
            Integer a2 = 0;
            for (int i = 0; i < leibieArr.length; i++) {
                Integer leibie = Integer.valueOf(leibieArr[i]);

                a1 += totalMap.get(leibie);
                a2 += testTotalMap.get(leibie);
            }
            menuJson.put("questionNum",a1);
            menuJson.put("questionTestNum",a2);
            if(a1 > 40){
                menuJson.put("time",60);
            }else{
                menuJson.put("time",45);
            }

            menuFile.write(menuJson.toJSONString().getBytes());
            menuFile.write("\r\n".getBytes());
        }

        menuFile.close();
    }
}
