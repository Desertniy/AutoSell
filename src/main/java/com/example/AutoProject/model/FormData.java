package com.example.AutoProject.model;



import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import javax.validation.constraints.Size;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormData {
    @Size(min = 12)
    private String phone_number;
    @Size(min = 2, max = 20)
    private String client_name;
    @Size(min = 2)
    private String remark;
    private String dateTime;

    String parseDateTime(ZonedDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return dateTime.format(formatter);
    }
    public FormData() {
        this.dateTime = parseDateTime(ZonedDateTime.now(ZoneId.of("Europe/Moscow")));
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime() {
        this.dateTime = parseDateTime(ZonedDateTime.now(ZoneId.of("Europe/Moscow")));
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public boolean check_phone_number(){
        String regex = "^\\+\\d{11}$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(this.phone_number);
        if (matcher.matches()){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "{" +
                "phone_number :'" + phone_number + '\'' +
                ", client_name :'" + client_name + '\'' +
                ", remark :'" + remark + '\'' +
                ", time :'" + dateTime + '\'' +
                '}';
    }
}
