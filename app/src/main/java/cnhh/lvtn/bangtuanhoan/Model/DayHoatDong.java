package cnhh.lvtn.bangtuanhoan.Model;

public class DayHoatDong {
    private String mIon;
    private String mHoaTri;

    public DayHoatDong() {
    }

    public DayHoatDong(String mIon, String mHoaTri) {
        this.mIon = mIon;
        this.mHoaTri = mHoaTri;
    }

    public String getIon() {
        return mIon;
    }

    public void setIon(String mIon) {
        this.mIon = mIon;
    }

    public String getHoaTri() {
        return mHoaTri;
    }

    public void setHoaTri(String mHoaTri) {
        this.mHoaTri = mHoaTri;
    }
}
