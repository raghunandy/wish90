package com.fernandocejas.android10.sample.data.net;

/**
 * Created by Deepti B on 10/22/2015.
 */
class ContactDetailsTemplate {
    String name;
    String dateofbirth;
    ContactDetailsTemplate(String x,String y){
        name=x;
        dateofbirth=y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }
}
