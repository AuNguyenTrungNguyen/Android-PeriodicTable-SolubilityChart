package cnhh.lvtn.bangtuanhoan;

public class Cation {
    private int mIdCation;
    private String mTenCation;
    private String mHoaTri;

    public Cation() {

    }

    public Cation(int mIdCation, String mTenCation, String mHoaTri) {
        this.mIdCation = mIdCation;
        this.mTenCation = mTenCation;
        this.mHoaTri = mHoaTri;
    }

    public int getIdCation() {
        return mIdCation;
    }

    public void setIdCation(int mIdCation) {
        this.mIdCation = mIdCation;
    }

    public String getTenCation() {
        return mTenCation;
    }

    public void setTenCation(String mTenCation) {
        this.mTenCation = mTenCation;
    }

    public String getHoaTri() {
        return mHoaTri;
    }

    public void setHoaTri(String mHoaTri) {
        this.mHoaTri = mHoaTri;
    }
}
