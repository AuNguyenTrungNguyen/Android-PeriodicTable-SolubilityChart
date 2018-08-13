package cnhh.lvtn.bangtuanhoan.Model;

public class Cation {
    private int mIdCation;
    private String mTenCation;
    private String mHoaTriCation;

    public Cation() {

    }

    public Cation(int mIdCation, String mTenCation, String mHoaTriCation) {
        this.mIdCation = mIdCation;
        this.mTenCation = mTenCation;
        this.mHoaTriCation = mHoaTriCation;
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

    public String getHoaTriCation() {
        return mHoaTriCation;
    }

    public void setHoaTriCation(String mHoaTriCation) {
        this.mHoaTriCation = mHoaTriCation;
    }
}
