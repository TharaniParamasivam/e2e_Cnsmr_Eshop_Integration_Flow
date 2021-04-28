package com.ctl.it.qa.eshop.tools.steps;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BMShippingRequest {

@SerializedName("ban")
@Expose
private String ban;
@SerializedName("dateOfSignOff")
@Expose
private String dateOfSignOff;
@SerializedName("macId")
@Expose
private String macId;
@SerializedName("repairInd")
@Expose
private String repairInd;
@SerializedName("serialNo")
@Expose
private String serialNo;
@SerializedName("serviceGroup")
@Expose
private String serviceGroup;
@SerializedName("subServiceGroup")
@Expose
private String subServiceGroup;
@SerializedName("timeOfSignOff")
@Expose
private String timeOfSignOff;
@SerializedName("trackingId")
@Expose
private String trackingId;
@SerializedName("transactionId")
@Expose
private String transactionId;
@SerializedName("wtn")
@Expose
private String wtn;

public String getBan() {
return ban;
}

public void setBan(String ban) {
this.ban = ban;
}

public String getDateOfSignOff() {
return dateOfSignOff;
}

public void setDateOfSignOff(String dateOfSignOff) {
this.dateOfSignOff = dateOfSignOff;
}

public String getMacId() {
return macId;
}

public void setMacId(String macId) {
this.macId = macId;
}

public String getRepairInd() {
return repairInd;
}

public void setRepairInd(String repairInd) {
this.repairInd = repairInd;
}

public String getSerialNo() {
return serialNo;
}

public void setSerialNo(String serialNo) {
this.serialNo = serialNo;
}

public String getServiceGroup() {
return serviceGroup;
}

public void setServiceGroup(String serviceGroup) {
this.serviceGroup = serviceGroup;
}

public String getSubServiceGroup() {
return subServiceGroup;
}

public void setSubServiceGroup(String subServiceGroup) {
this.subServiceGroup = subServiceGroup;
}

public String getTimeOfSignOff() {
return timeOfSignOff;
}

public void setTimeOfSignOff(String timeOfSignOff) {
this.timeOfSignOff = timeOfSignOff;
}

public String getTrackingId() {
return trackingId;
}

public void setTrackingId(String trackingId) {
this.trackingId = trackingId;
}

public String getTransactionId() {
return transactionId;
}

public void setTransactionId(String transactionId) {
this.transactionId = transactionId;
}

public String getWtn() {
return wtn;
}

public void setWtn(String wtn) {
this.wtn = wtn;
}

}