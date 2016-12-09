package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.listView;

import java.io.Serializable;

/**
 * Created by SAEED-PC on 11/22/2015.
 */
public class Info_HiDoctor_UserApp implements Serializable {

    private int id ;

    private String sendDate ;
    private String receiveDate;
    private String subject;
    private String question;
    private String answer;
    private String flag_new_answered;
    private String reservation1;
    private String reservation2;
    private String reservation3;
    private String reservation4;
    private String reservation5;



    public  String getReservation5() {
        return reservation5;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  void setReservation5(String reservation5) {
        this.reservation5 = reservation5;
    }

    public  String getReservation3() {
        return reservation3;
    }

    public  void setReservation3(String reservation3) {
        this.reservation3 = reservation3;
    }

    public  String getReservation4() {
        return reservation4;
    }

    public  void setReservation4(String reservation4) {
        this.reservation4 = reservation4;
    }

    public  String getReservation2() {
        return reservation2;
    }

    public  void setReservation2(String reservation2) {
        this.reservation2 = reservation2;
    }

    public  String getReservation1() {
        return reservation1;
    }

    public  void setReservation1(String reservation1) {
        this.reservation1 = reservation1;
    }



    public  String getFlag_new_answered() {
        return flag_new_answered;
    }

    public  void setFlag_new_answered(String flag_new_answered) {
        this.flag_new_answered = flag_new_answered;
    }

    public  String getSendDate() {
        return sendDate;
    }

    public  void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public  String getAnswer() {
        return answer;
    }

    public  void setAnswer(String answer) {
        this.answer = answer;
    }

    public  String getReceiveDate() {
        return receiveDate;
    }

    public  void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public   String getSubject() {
        return subject;
    }

    public  void setSubject(String subject) {
        this.subject = subject;
    }

    public  String getQuestion() {
        return question;
    }

    public  void setQuestion(String question) {
        this.question = question;
    }
}
