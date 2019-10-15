package org.test.pdf;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class PDFTest {
    public static void main(String[] args) {
        try {
            PDFTest pf = new PDFTest();
            String ts = pf.GetTextFromPdf("D:\\FDX207G-01-16R3-11260925-1.PDF");
            /*OutputStreamWriter osw = new OutputStreamWriter(
                    new FileOutputStream("D:\\aa.txt"));
            System.out.println(ts);
            osw.write(ts);
            osw.flush();
            osw.close();*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String GetTextFromPdf(String filename) throws Exception {
        //创建文档对象
        PDDocument doc =null;
        String content="";
        try {
            //加载一个pdf对象
            doc =PDDocument.load(new File(filename));
            //获取一个PDFTextStripper文本剥离对象
            PDFTextStripper textStripper =new PDFTextStripper();
            content=textStripper.getText(doc);
            String[] arr = content.split("\r\n");
            System.out.println(arr.length);
            System.out.println(arr[8]);
            String[] t = arr[8].split(" ");
            for (int i = 0; i < t.length; i++) {
                System.out.println(t[i]);
            }
            //System.out.println("内容:"+content);
            //关闭文档
            doc.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return content;
    }
}
