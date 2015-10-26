package leona.gygafun.wish90.presentation.model;

/**
 * Created by rkrasniqi on 10/23/15.
 */


public class ConveyScheduleModel {

    private int scheduleID;
    private int momentID;
    private String scheduleInstrument;
    private String template;
    private String deliverInstrument;


    public ConveyScheduleModel(int scheduleID) {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConveyScheduleModel that = (ConveyScheduleModel) o;

        if (scheduleID != that.scheduleID) return false;
        if (momentID != that.momentID) return false;
        if (scheduleInstrument != null ? !scheduleInstrument.equals(that.scheduleInstrument) : that.scheduleInstrument != null)
            return false;
        if (template != null ? !template.equals(that.template) : that.template != null)
            return false;
        return !(deliverInstrument != null ? !deliverInstrument.equals(that.deliverInstrument) : that.deliverInstrument != null);

    }

    @Override
    public int hashCode() {
        int result = scheduleID;
        result = 31 * result + momentID;
        result = 31 * result + (scheduleInstrument != null ? scheduleInstrument.hashCode() : 0);
        result = 31 * result + (template != null ? template.hashCode() : 0);
        result = 31 * result + (deliverInstrument != null ? deliverInstrument.hashCode() : 0);
        return result;
    }
}