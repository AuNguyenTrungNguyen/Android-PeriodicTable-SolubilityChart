package cnhh.lvtn.bangtuanhoan;

public class ChatHoaHoc {
    private int mIdChat;
    private String mKyHieuChat;
    private String mTenChat;
    private int mChuKy;
    private String mNhom;
    private int mVitri;

    public ChatHoaHoc() {
    }

    public ChatHoaHoc(int mIdChat, String mKyHieuChat, String mTenChat, int mChuKy, String mNhom, int mViTri) {
        this.mIdChat = mIdChat;
        this.mKyHieuChat = mKyHieuChat;
        this.mTenChat = mTenChat;
        this.mChuKy = mChuKy;
        this.mNhom = mNhom;
        this.mVitri = mViTri;
    }

    public int getIdChat() {
        return mIdChat;
    }

    public void setIdChat(int mIdChat) {
        this.mIdChat = mIdChat;
    }

    public String getKyHieuChat() {
        return mKyHieuChat;
    }

    public void setKyHieuChat(String mKyHieuChat) {
        this.mKyHieuChat = mKyHieuChat;
    }

    public String getTenChat() {
        return mTenChat;
    }

    public void setTenChat(String mTenChat) {
        this.mTenChat = mTenChat;
    }

    public int getChuKy() {
        return mChuKy;
    }

    public void setChuKy(int mChuKy) {
        this.mChuKy = mChuKy;
    }

    public String getNhom() {
        return mNhom;
    }

    public void setNhom(String mNhom) {
        this.mNhom = mNhom;
    }

    public int getVitri() {
        return mVitri;
    }

    public void setVitri(int mVitri) {
        this.mVitri = mVitri;
    }
}
