package pls.certination.com.Pls.Job_portal;

/**
 * Created by AtreeTech on 8/14/2016.
 */
public class DataModel {

    String jobPost;
    String jobDesciption;
    String keySkill;
    int id_;


    public DataModel(String jobPost, String jobDescription,String keySkill ,int id_) {
        this.jobPost = jobPost;
        this.jobDesciption = jobDescription;
        this.keySkill = keySkill;
        this.id_ = id_;

    }

    public String getJobPost() {
        return jobPost;
    }

    public String getJobDescription() {
        return jobDesciption;
    }


    public int getId() {
        return id_;
    }



    public String getKeySkill() {
        return keySkill;
    }
}
