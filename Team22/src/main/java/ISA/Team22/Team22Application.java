package ISA.Team22;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@SpringBootApplication
public class Team22Application {

	public static void main(String[] args) {
		SpringApplication.run(Team22Application.class, args);
		
		MyQr myQr = new MyQr();
		
		 // The data that the QR code will contain
		String drug1 = "brufen";
		String drug2 = "aspirin";
        String data = "792521!brufen_555_5;aspirin_1010_7";
        ArrayList<String> drugs = new ArrayList<String>();
        drugs.add(drug1);
        drugs.add(drug2);
 
        // The path where the image will get saved
        String path = "C:\\Users\\user\\Desktop\\isa\\ISA-team22\\Team22\\src\\main\\resources\\qrCodes\\code1.png";
 
        // Encoding charset
        String charset = "UTF-8";
 
        Map<EncodeHintType, ErrorCorrectionLevel> hashMap
            = new HashMap<EncodeHintType,
                          ErrorCorrectionLevel>();
 
        hashMap.put(EncodeHintType.ERROR_CORRECTION,
                    ErrorCorrectionLevel.L);
 
        // Create the QR code and save
        // in the specified folder
        // as a jpg file
        try {
			myQr.createQR(data, path, charset, hashMap, 200, 200);
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("QR Code Generated!!! ");
	}

}
