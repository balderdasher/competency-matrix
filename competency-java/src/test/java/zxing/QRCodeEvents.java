//package zxing;
//
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.EncodeHintType;
//import com.google.zxing.MultiFormatWriter;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
//import com.google.zxing.common.BitMatrix;
//
//import java.io.File;
//import java.util.Hashtable;
//
///**
// * @author huxiong
// * @date 2017-04-27 9:34
// */
//public class QRCodeEvents {
//    public static void main(String[] args) throws Exception {
//        String text = "http://lottery.home.news.cn/51shake/index.html";
//        int width = 100;
//        int height = 100;
//        String format = "png";
//        Hashtable hints = new Hashtable();
//        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
//        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
//        File outputFile = new File("luck.png");
//        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
//
//    }
//}
