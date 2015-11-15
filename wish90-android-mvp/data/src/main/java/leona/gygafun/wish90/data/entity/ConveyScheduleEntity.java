package leona.gygafun.wish90.data.entity;

/**
 * Created by rkrasniqi on 10/6/15.
 */

import com.google.gson.annotations.SerializedName;


public class ConveyScheduleEntity {


    private int scheduleID;
    private int momentID;
    private String scheduleInstrument;
    private String template;
    private String deliverInstrument;

    public ConveyScheduleEntity() {}

    public int getScheduleID() {

        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }
    public int getMomentID() {
        return momentID;
    }
    public void setMomentID(int momentID) {
        this.momentID = momentID;
    }
    public String getScheduleInstrument() {
        return scheduleInstrument;
    }
    public void setScheduleInstrument(String scheduleInstrument) {
        this.scheduleInstrument = scheduleInstrument;
    }

    public String getTemplate() {
        return template;
    }
    public void setTemplate(String template) {
        this.template = template;
    }
    public String getDeliverInstrument() {
        return deliverInstrument;
    }

    public void setDeliverInstrument(String deliverInstrument) {
        this.deliverInstrument = deliverInstrument;
    }

    @Override
    public String toString() {
        return "ConveyScheduleEntity{" +
                "scheduleID=" + scheduleID +
                ", momentID=" + momentID +
                ", scheduleInstrument='" + scheduleInstrument + '\'' +
                ", template=" + template +
                ", deliverInstrument='" + deliverInstrument + '\'' +
                '}';
    }


}
