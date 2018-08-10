package cnhh.lvtn.bangtuanhoan;

public class BangTinhTan {
    private int mAnion;
    private int mCation;
    private String mTinhTan;

    public BangTinhTan() {

    }

    public BangTinhTan(int mAnion, int mCation, String mTinhTan) {
        this.mAnion = mAnion;
        this.mCation = mCation;
        this.mTinhTan = mTinhTan;
    }

    public int getAnion() {
        return mAnion;
    }

    public void setAnion(int mAnion) {
        this.mAnion = mAnion;
    }

    public int getCation() {
        return mCation;
    }

    public void setCation(int mCation) {
        this.mCation = mCation;
    }

    public String getTinhTan() {
        return mTinhTan;
    }

    public void setTinhTan(String mTinhTan) {
        this.mTinhTan = mTinhTan;
    }
}
