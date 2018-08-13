package cnhh.lvtn.bangtuanhoan.Model;

public class Anion {
    private int mIdAinon;
    private String mTenAnion;
    private String mHoaTriAnion;

    public Anion() {
    }

    public Anion(int mIdAinon, String mTenAnion, String mHoaTriAnion) {
        this.mIdAinon = mIdAinon;
        this.mTenAnion = mTenAnion;
        this.mHoaTriAnion = mHoaTriAnion;
    }

    public int getIdAinon() {
        return mIdAinon;
    }

    public void setIdAinon(int mIdAinon) {
        this.mIdAinon = mIdAinon;
    }

    public String getTenAnion() {
        return mTenAnion;
    }

    public void setTenAnion(String mTenAnion) {
        this.mTenAnion = mTenAnion;
    }

    public String getHoaTriAnion() {
        return mHoaTriAnion;
    }

    public void setHoaTriAnion(String mHoaTriAnion) {
        this.mHoaTriAnion = mHoaTriAnion;
    }
}
