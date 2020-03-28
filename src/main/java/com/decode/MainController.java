package com.decode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.decode.Decoder;


@Controller
public class MainController {

    @RequestMapping("/")
    public String index(Model model,
                        @RequestParam(value = "value", required = false) String value,
                        @RequestParam(value = "form", required = false) String formCode,
                        @RequestParam(value = "type", required = false) String operationType
                      ){
        Decoder decoder = new Decoder();
        if (value != null) {
            String result = " ";
            int intValue;
            if (operationType.equals("code")) {
                try {
                    intValue = Integer.parseInt(value);
                }
                catch (NumberFormatException e) {
                    return "index";
                }
                if (formCode.equals("short")) {
                    result = decoder.toShortCode(intValue);
                }
                else if (formCode.equals("long")){
                    result = decoder.toLongCode(intValue);
                }
            }
            else if (operationType.equals("decode")) {
                if (formCode.equals("short")) {
                    result = decoder.decodeFromShort(value);

                }
                else if(formCode.equals("long")) {
                    result = decoder.decodeFromLong(value);
                }
            }
            model.addAttribute("result", result);
        }
        return "index";
    }
}
