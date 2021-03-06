/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ti.enterprise.project.KTP;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author weann
 */
@Controller
public class DataController {

    DataKtpJpaController datactrl = new DataKtpJpaController();
    List<DataKtp> newdata = new ArrayList<>();

    @RequestMapping("/data")
    public String getDataKtp(Model model) {

        int record = datactrl.getDataKtpCount();
        String result = "";
        try {
            newdata = datactrl.findDataKtpEntities();
        } catch (Exception e) {
            result = e.getMessage();
        }

        model.addAttribute("goData", newdata);
        model.addAttribute("record", record);
        return "database";
    }

    @RequestMapping("/edit")
    public String doEdit() {
        return "editktp";
    }

}
