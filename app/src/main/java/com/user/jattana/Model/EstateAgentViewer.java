package com.user.jattana.Model;

import java.util.Date;

public class EstateAgentViewer {
    private int reportId;
    private String agentEmail;
    private int propertyId;
    private Date date_of_Viewing;
    private String interest;
    private double offer_price;
    private Date offer_expiry_date;
    private String conditions_of_offer;
    private String viewing_comments;

    public EstateAgentViewer(int reportId, String agentEmail, int propertyId, Date date_of_Viewing, String interest, double offer_price, Date offer_expiry_date, String conditions_of_offer, String viewing_comments) {
        this.reportId = reportId;
        this.agentEmail = agentEmail;
        this.propertyId = propertyId;
        this.date_of_Viewing = date_of_Viewing;
        this.interest = interest;
        this.offer_price = offer_price;
        this.offer_expiry_date = offer_expiry_date;
        this.conditions_of_offer = conditions_of_offer;
        this.viewing_comments = viewing_comments;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public void setAgentEmail(String agentEmail) {
        this.agentEmail = agentEmail;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public void setDate_of_Viewing(Date date_of_Viewing) {
        this.date_of_Viewing = date_of_Viewing;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public void setOffer_price(double offer_price) {
        this.offer_price = offer_price;
    }

    public void setOffer_expiry_date(Date offer_expiry_date) {
        this.offer_expiry_date = offer_expiry_date;
    }

    public void setConditions_of_offer(String conditions_of_offer) {
        this.conditions_of_offer = conditions_of_offer;
    }

    public void setViewing_comments(String viewing_comments) {
        this.viewing_comments = viewing_comments;
    }

    public int getReportId() {
        return reportId;
    }

    public String getAgentEmail() {
        return agentEmail;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public Date getDate_of_Viewing() {
        return date_of_Viewing;
    }

    public String getInterest() {
        return interest;
    }

    public double getOffer_price() {
        return offer_price;
    }

    public Date getOffer_expiry_date() {
        return offer_expiry_date;
    }

    public String getConditions_of_offer() {
        return conditions_of_offer;
    }

    public String getViewing_comments() {
        return viewing_comments;
    }

    @Override
    public String toString() {
        return "EstateAgentViewer{" +
                "reportId:" + reportId +
                ", agentEmail:'" + agentEmail + '\'' +
                ", propertyId:" + propertyId +
                ", date_of_Viewing:" + date_of_Viewing +
                ", interest:'" + interest + '\'' +
                ", offer_price:" + offer_price +
                ", offer_expiry_date:" + offer_expiry_date +
                ", conditions_of_offer:'" + conditions_of_offer + '\'' +
                ", viewing_comments:'" + viewing_comments + '\'' +
                '}';
    }
}

