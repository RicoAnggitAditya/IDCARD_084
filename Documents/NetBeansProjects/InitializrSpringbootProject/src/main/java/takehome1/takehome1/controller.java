/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takehome1.takehome1;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author acer
 */

@Controller
public class controller {
    @RequestMapping ("/send")
    //@ResponseBody
    public String getData (@RequestParam (value="inputnama")String getUsernama,
                            @RequestParam (value="inputtanggal") String getTanggal,
                            @RequestParam (value="inputfoto") MultipartFile getFoto,
                            Model model)
    throws IOException{
        byte[] img = getFoto.getBytes();
        String base64Image = Base64.encodeBase64String(img);
        String imglink ="data:image/png;base64,".concat(base64Image);
        model.addAttribute("kirimannama",getUsernama) ;
        model.addAttribute("kirimantanggal", getTanggal);
        model.addAttribute("kirimangambar", imglink);
        
        return "main";
    }
   
    
}
