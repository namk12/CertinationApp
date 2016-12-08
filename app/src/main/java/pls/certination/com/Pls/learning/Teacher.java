package pls.certination.com.Pls.learning;

import java.util.Date;

/**
 * Created by Raman Singh on 7/28/2016.
 */
public class Teacher {

    String tchr_name;
    String completion_date;
    String submission_date;
    String subn_id;
    String tchr_subject;

    public Teacher(String tchr_name, String completion_date, String submission_date, String subn_id, String tchr_subject) {
        this.tchr_name = tchr_name;
        this.completion_date = completion_date;
        this.submission_date = submission_date;
        this.subn_id = subn_id;
        this.tchr_subject = tchr_subject;
    }
    public Teacher(){

    }


    public String getTchr_name() {
        return tchr_name;
    }

    public void setTchr_name(String tchr_name) {
        this.tchr_name = tchr_name;
    }

    public String getCompletion_date() {
        return completion_date;
    }

    public void setCompletion_date(String completion_date) {
        this.completion_date = completion_date;
    }

    public String getSubmission_date() {
        return submission_date;
    }

    public void setSubmission_date(String submission_date) {
        this.submission_date = submission_date;
    }

    public String getSubn_id() {
        return subn_id;
    }

    public void setSubn_id(String subn_id) {
        this.subn_id = subn_id;
    }

    public String getTchr_subject() {
        return tchr_subject;
    }

    public void setTchr_subject(String tchr_subject) {
        this.tchr_subject = tchr_subject;
    }
}

