//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mycompany.app;

import java.util.Iterator;
import java.util.List;
import com.mycompany.app.dto.NewSmsDto;
//import com.mycompany.app.utils.AfricaTalkingUtil;

public class SmsSender {
    public SmsSender() {
    }

    public void getAndSendSms() {
        List<NewSmsDto> newSmsDtoList = (new DbManager()).getNewSmses();
        Iterator var2 = newSmsDtoList.iterator();

        while(var2.hasNext()) {
            NewSmsDto sms = (NewSmsDto)var2.next();
//            AfricaTalkingUtil.getInstance().sendSMS(sms.getPhone(), sms.getText());
            new DbManager();
        }

    }
}

